package Calculate.Formulas

class Formula {
    //min attack
    fun normalMinRawDamage(stat: Float, weapon: Float, base: Float): Int {
        val stat_weapon = ((stat*weapon)/20)
        val level = (base/4)
        val min_raw_damage = stat_weapon+level
        return Math.round(min_raw_damage)
    }
    fun specialPhysicalMinSpecialDamage(stat: Float, weapon: Float, base: Float): Int {
        val min_raw_damage = 1.5*normalMinRawDamage(stat, weapon, base)
        return Math.round(min_raw_damage.toFloat())
    }
    fun specialMagicMinDamage(stat: Float, weapon: Float, base: Float): Int {
        val min_damage = 1.6*normalMinRawDamage(stat, weapon, base)
        return Math.round(min_damage.toFloat())
    }
    fun normalMaxRawDamage(stat: Float, weapon: Float, base: Float): Int {
        //(B2*(B3/10))+B1/4
        val max_raw_damage = ((stat*weapon)/10)+(base/4)
        return Math.round(max_raw_damage)
    }

    fun specialMaxDamage(stat: Float, weapon: Float, base: Float): Int {
        val max_damage = 1.5 * normalMaxRawDamage(stat, weapon, base)
        return Math.round(max_damage.toFloat())
    }
    fun specialMagicMaxDamage(stat: Float, weapon: Float, base: Float): Int {
        val min_raw_damage = 1.6 * normalMaxRawDamage(stat, weapon, base)
        return Math.round(min_raw_damage.toFloat())
    }
    //Maximos y minimos normal attack
    fun MinDamage(min_damage: Float, mob_defense: Float): Int {
        var min_damage = min_damage - mob_defense
        if (min_damage < 0F){
            min_damage = 0F
            return min_damage.toInt()
        }else{
          return min_damage.toInt()
        }
    }
    fun MaxDamage(max_damage: Float, mob_defense: Float): Int {
        var max_damage: Float = max_damage - mob_defense
        if (max_damage < 0F) {
            max_damage = 0F
            return max_damage.toInt()
        } else{
            return max_damage.toInt()
        }
    }
    //porcentaje de daño
    fun AttackPorcentageDamage(normal_attack_max_damage: Float, min_damage: Float, max_damage: Float): Int {
        var normalAttackPorcentageDamage: Float = ((normal_attack_max_damage) / (max_damage - min_damage))
        if (normalAttackPorcentageDamage>1.00){
             normalAttackPorcentageDamage = 1.0F
             return normalAttackPorcentageDamage.toInt()*100
        }
        return (normalAttackPorcentageDamage*100).toInt()
    }

    /*
                               hp/((max_damage+min_damage))*0.5*(porcentajeDamage)
    * NSHORA(0,0,REDONDEAR.MAS(E23/((G23+F23)*0.5*H23))))
    * */
    fun calculateTimeKillingMoster(min_damage: Float, max_damage: Float, porcentageDamage: Float, hp_creature: Float): Double {
        val sumDamage = max_damage + min_damage
        val calculateTime: Double
        if (sumDamage == 0F){
            calculateTime = 0.0
        } else{
            calculateTime = hp_creature/((sumDamage)*0.5*porcentageDamage)
        }
        return calculateTime
    }

    fun convertTime(decimal: Double): String {
        /*val Hora = 0
        val minutos = Math.ceil(decimal).toInt()
        //val minutos = decimal.toInt()
        val segundos = Math.abs(((decimal - minutos) * 60).toInt())*/
        val hora = 0
        val minuto = decimal.toInt()
        val minutos: Int
        if (minuto > 0){
            minutos = Math.ceil(decimal).toInt()
        } else{
            minutos = decimal.toInt()
        }
        val segundos = Math.ceil(((decimal - minuto) * 60)).toInt()
        //val segundos = ((decimal - horas - (minutos / 60.0)) * 3600).toInt()
        return String.format("%02d:%02d:%02d",hora, minutos, segundos)
    }
}