import Peasants.Occupation
import Peasants.Peasant
import army.Fighter
import army.Specialization
import monarchy.Heir
import monarchy.Noble
import monarchy.Ruler
import taxes.TaxCollector

fun Fighter.upgrade() {
    when (specialization) {
        Specialization.SWORDSMAN -> {
            weapon = "Long sword"
            strength += 1
        }

        Specialization.ARCHER -> {
            weapon = "Long Bow"
            dextirity += 2
        }
    }
}

fun main() {
    val kingdom = Kingdom()

    collectTaxes(kingdom) {
        println("My Lord, we have collected: $it gold coins!")
    }

    upgradeArmy(kingdom.army)

    whoWillInheritThrone(kingdom.heirs) {
        println("Next King is ${it.name}!")
    }
}

fun whoWillInheritThrone(heirs: List<Noble>, function: (Noble) -> Unit) {
    val heir = heirs.maxBy {
        it.power + it.intellect
    }

    function(heir!!)
}

class Kingdom {
    var treasury = 0

    val ruler: Noble = createRuler()
    val heirs: List<Noble> = createHeirs()

    val army: List<Fighter> = createArmy()
    val peasants: List<Peasant> = createPeasnts()

    val taxCollector: TaxCollector = TaxCollector()

    private fun createRuler() = Ruler("Maximus").also {
        println("Hail to the King ${it.name}!")
    }

    private fun createHeirs(): List<Noble> = mutableListOf<Noble>().apply {
        add(Heir("Joffrey"))
        add(Heir("Balanor"))
        add(Heir("William"))

        forEach {
            println("Hail to ${it.name}!")
        }
    }

    private fun createArmy(): List<Fighter> = mutableListOf<Fighter>().apply {
        repeat(50) {
            if (it % 2 == 0) {
                add(Fighter(Specialization.ARCHER))
            } else {
                add(Fighter(Specialization.SWORDSMAN))
            }
        }
    }

    private fun createPeasnts() = mutableListOf<Peasant>().apply {
        repeat(100) {
            when  {
                it % 3 == 0 -> add(Peasant(Occupation.FARMER))
                it % 2 == 0 -> add(Peasant(Occupation.BUILDER))
                else -> add(Peasant(Occupation.WORKER))
            }
        }
    }
}

private fun collectTaxes(kingdom: Kingdom, function: (tax: Int) -> Unit) {
    kingdom.peasants.forEach {
        val tax = kingdom.taxCollector.collection(it)
        kingdom.treasury += tax
    }

    function(kingdom.treasury)
}

private fun upgradeArmy(army: List<Fighter>) {
    army.forEach {
        it.upgrade()
    }
}