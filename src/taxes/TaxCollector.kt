package taxes

import Peasants.Peasant

class TaxCollector: TaxCollection {
    override fun collection(peasant: Peasant): Int = peasant.occupation.taxRate
}