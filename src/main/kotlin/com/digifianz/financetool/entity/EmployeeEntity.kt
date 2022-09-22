package com.digifianz.financetool.entity

import com.digifianz.financetool.util.*
import javax.persistence.Entity
import javax.persistence.ManyToOne

// TODO make all these values customizable from UI
const val MONTHS_IN_A_YEAR = 12
const val DAYS_IN_A_MONTH = 30
const val VACATION_DAYS = 14
val BRUTE_SALARY_PERCENTAGE = (100.0 / 83.0 - 1.0).decimalToPercentage()
val VACATION_PERCENTAGE = 20.percent
val VACATION_SAC_TAX_PERCENTAGE = 38.percent
val AVERAGE_OSDE_COST = 1_700.ars
val ADDITIONAL_BENEFIT_PERCENTAGE = 5.percent
val CLICKUP_USER_COST = 9.usd
val GSUITE_COST = 6.usd
val GSUITE_ADDITIONAL_STORAGE_COST = 5.usd

@Entity(name = "employee")
class EmployeeEntity(
    var name: String,

    @ManyToOne var team: TeamEntity,

    var netSalary: Ars = 0.ars,
    var unionSalary: Usd = 0.usd,

    var hasClickUpUser: Boolean = true,
    var hasGSuite: Boolean = true,
    var hasGSuiteAdditionalStorage: Boolean = false,
    var hasHR: Boolean = true,

    var potentialTerminationCost: Usd = 0.usd,
) : DatabaseEntity() {
    val bruteSalary get() = Ars(netSalary.ars * (1 + BRUTE_SALARY_PERCENTAGE.decimal))
    val sacByMonth get() = Ars(bruteSalary.ars / MONTHS_IN_A_YEAR)
    val vacations get() = Ars(bruteSalary.ars / DAYS_IN_A_MONTH * VACATION_PERCENTAGE.decimal * VACATION_DAYS / MONTHS_IN_A_YEAR)
    val taxes get() = Ars(bruteSalary.ars * (0.24 + 0.0065) + 0.6 + 19.03) // TODO decode and lift to constants
    val vacationAndSacTaxes get() = Ars((vacations.ars + sacByMonth.ars) * VACATION_SAC_TAX_PERCENTAGE.decimal)
    val osde get() = AVERAGE_OSDE_COST
    val additionalBenefits get() = Ars(bruteSalary.ars * ADDITIONAL_BENEFIT_PERCENTAGE.decimal)

    val clickUpUserCost get() = if (hasClickUpUser) CLICKUP_USER_COST else 0.usd
    val gSuiteCost get() = if (hasGSuite) GSUITE_COST else 0.usd
    val gSuiteAdditionalStorageCost get() = if (hasGSuiteAdditionalStorage) GSUITE_ADDITIONAL_STORAGE_COST else 0.usd

    // TODO calculate correctly. Depends on People Experience team total salaries divided by the head count of operative employees
    val hrCost get() = if (hasHR) 98.19.usd else 0.usd

    val totalArsCostWithoutTermination: Ars
        get() {
            return if (netSalary.ars == 0.0) 0.ars
            else Ars(arrayOf(
                bruteSalary, sacByMonth, vacations, taxes, vacationAndSacTaxes, osde, additionalBenefits
                // TODO add HR cost to sum
            ).sumOf { it.ars })
        }

    val totalUsdCost: Usd
        get() {
            var totalUsd = totalArsCostWithoutTermination.usd + unionSalary.usd
            if (totalUsd != 0.0) {
                totalUsd += arrayOf(
                    clickUpUserCost,
                    gSuiteCost,
                    gSuiteAdditionalStorageCost,
                    hrCost,
                    potentialTerminationCost,
                ).sumOf { it.usd }
            }
            return Usd(totalUsd)
        }
}


fun EmployeeEntity.calculateRelativeCost(employees: List<EmployeeEntity>) =
    (totalUsdCost.usd / employees.sumOf { it.totalUsdCost.usd }).decimalToPercentage()