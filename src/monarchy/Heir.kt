package monarchy

class Heir(name: String): Ruler(name) {

    init {
        calculateStats()
    }

    private fun calculateStats() {
        intellect *= coefficient()
        power *= coefficient()
    }

    private fun coefficient(): Float {
        return (1 .. 200).random() / 100f
    }
}