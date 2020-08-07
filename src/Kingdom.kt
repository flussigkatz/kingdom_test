import Peasants.Peasant
import army.Fighter
import monarchy.Noble
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

    val ruler: Noble = createRuler()
    val heirs: List<Noble> = createHeirs()

    val army: List<Fighter> = createArmy()
    val peasants: List<Peasant> = createPeasants()

    val taxCollector: TaxCollector = TaxCollector()

    /**
     * Создайте правителя и выведите следующее приветствие:
     * "Hail to the King ${it.name}!"
     */
    private fun createRuler() {}


    /**
     * Создайте несколько наследников престола, каждому дайте свое имя,выведите в консоль приветствие
     * каждому наследнику:
     * "Hail to ${it.name}!"
     */
    private fun createHeirs(): List<Noble> {}

    /**
     * Создайте армию, пусть каждый воторой будет лучник
     */
    private fun createArmy(): List<Fighter> {}


    /**
     * Создайте крестьян, пусть крестьяне с номером кратным трем будут фермеры
     * кратные двум - строителями
     * все остальные рабочими
     */
    private fun createPeasants() {}
}

/**
 * Соберите налоги, и реализуйте метод в соответсвии с вызовом в методе main
 */
private fun collectTaxes(kingdom: Kingdom, function: (tax: Int) -> Unit) {
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