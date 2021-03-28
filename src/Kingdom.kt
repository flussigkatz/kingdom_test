import Peasants.Occupation
import Peasants.Peasant
import army.Fighter
import army.Specialization
import monarchy.Noble
import monarchy.Ruler
import taxes.TaxCollector

/**
 * Напишите extension функцию, которая будет, в зависимости от класса бойца, давать
 * ему улучшенное оружие(Просто более кртое название) и прокачивать статы
 */

fun Fighter.upgrade() {
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

class Kingdom {
    var treasury = 0

    val ruler: Ruler = createRuler()
    val heirs: List<Noble> = createHeirs()

    val army: List<Fighter> = createArmy()
    val peasants: List<Peasant> = createPeasants()

    val taxCollector: TaxCollector = TaxCollector()

    /**
     * Создайте правителя и выведите следующее приветствие:
     * "Hail to the King ${it.name}!"
     */
    private fun createRuler(): Ruler {
      val ruler = Ruler("HUI S GORI")
          ruler.let { println("Hail to the King ${it.name}!")}
      return ruler
    }


    /**
     * Создайте несколько наследников престола, каждому дайте свое имя,выведите в консоль приветствие
     * каждому наследнику:
     * "Hail to ${it.name}!"
     */
    private fun createHeirs(): List<Noble> {
        val list = mutableListOf<Noble>()
        list.add(object : Noble("First"){})
        list.add(object : Noble("Second"){})
        list.add(object : Noble("Third"){})
        return list
    }

    /**
     * Создайте армию, пусть каждый воторой будет лучник
     */
    private fun createArmy(): List<Fighter> {
        val list = mutableListOf<Fighter>()
        for (i in 1 .. 100) {
            /*if (i % 2 == 0) {
                list.add(Fighter(Specialization.ARCHER))
            } else {
                list.add(Fighter(Specialization.SWORDSMAN))
            }*/
            when {
                i % 2 == 0 -> list.add(Fighter(Specialization.ARCHER))
                else -> list.add(Fighter(Specialization.SWORDSMAN))
            }
        }
        return list
    }


    /**
     * Создайте крестьян, пусть крестьяне с номером кратным трем будут фермеры
     * кратные двум - строителями
     * все остальные рабочими
     */
    private fun createPeasants(): List<Peasant> {
        val list = mutableListOf<Peasant>()
        for (i in 1 .. 200) {
            when {
                i % 3 == 0 -> list.add(Peasant(Occupation.FARMER))
                i % 2 == 0 -> list.add(Peasant(Occupation.BUILDER))
                else -> list.add(Peasant(Occupation.WORKER))
            }
        }
        return list
    }
}

/**
 * Соберите налоги, и реализуйте метод в соответсвии с вызовом в методе main
 */
private fun collectTaxes(kingdom: Kingdom, function: (tax: Int) -> Unit) {
//    val taxGroup = kingdom.peasants.filter {it.occupation == Occupation.WORKER }
    kingdom.peasants.forEach{kingdom.treasury += it.occupation.taxRate}
    function(kingdom.treasury)
}

/**
 * Сделайте апгрейд ваший армии использую expression
 */
private fun upgradeArmy(army: List<Fighter>) {}


/**
 * В этом методе реализуйте выбор претенденат на трон, нужно сравнить по их параметрам сила
 * + интеллект, должен быть выбран саммый спосбный
 */
fun whoWillInheritThrone(heirs: List<Noble>, function: (Noble) -> Unit) {
}