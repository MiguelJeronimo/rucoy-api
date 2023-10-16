package Calculate.Ranks

import model.NormalTrain

class Ranks {
    fun PorcentageDamage(ArrayElements: ArrayList<NormalTrain>): List<NormalTrain> {
        val listAccending = ArrayElements.filter { it.porcentage_damage > 0 }
            .sortedBy { it.porcentage_damage }
        return listAccending.takeWhile { it.porcentage_damage == listAccending.first().porcentage_damage }
    }
}