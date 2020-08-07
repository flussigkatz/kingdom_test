package army

data class Fighter (val specialization: Specialization) {
    val type: String
    var weapon: String
    var strength: Int
    var dextirity: Int

    init {
        when (specialization) {
            Specialization.ARCHER -> {
                type = "Archer"
                weapon = "Bow"
                strength = 5
                dextirity = 10
            }

            Specialization.SWORDSMAN -> {
                type = "Swordsman"
                weapon = "Sword"
                strength = 10
                dextirity = 5
            }
        }
    }
}