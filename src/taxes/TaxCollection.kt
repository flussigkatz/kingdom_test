package taxes

import Peasants.Peasant

interface TaxCollection {
    fun collection(peasant: Peasant): Int
}