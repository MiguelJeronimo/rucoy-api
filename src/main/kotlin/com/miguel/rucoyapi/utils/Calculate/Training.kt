package Calculate

import Calculate.Formulas.Formula
import Calculate.Ranks.Ranks
import model.Mob
import model.NormalTrain

class Training {
    var formula = Formula()
    val ranks = Ranks()
    val mobs = arrayOf(
        Mob("Rat Lv.1", 4, 25),
        Mob("Rat Lv.3",  7, 35),
        Mob("Crow Lv.6",  13, 40),
        Mob("Wolf Lv.9",  17, 50),
        Mob("Scorpion Lv.12",  18, 50),
        Mob("Cobra Lv.13",  18, 50),
        Mob("Worm Lv.14",  19, 55),
        Mob("Goblin Lv.15",  21, 60),
        Mob("Mummy Lv.25",  36, 80),
        Mob("Pharaoh Lv.35",  51, 100),
        Mob("Assassin Lv.45",  71, 120),
        Mob("Assassin Lv.50",  81, 140),
        Mob("Assassin Ninja Lv.55",  91, 160),
        Mob("Skeleton Archer Lv.80",  101, 300),
        Mob("Zombie Lv.65",  106, 200),
        Mob("Skeleton Lv.75",  121, 300),
        Mob("Skeleton Warrior Lv.90",  146, 375),
        Mob("Vampire Lv.100", 171, 450),
        Mob("Vampire Lv.110",  186, 530),
        Mob("Drow Ranger Lv.125",  191, 600),
        Mob("Drow Mage Lv. 130", 191, 600),
        Mob("Drow Assassin Lv.120",  221, 620),
        Mob("Drow Sorceress Lv.140",  221, 600),
        Mob("Drow Fighter Lv.135",  246, 680),
        Mob("Lizard Archer Lv.160",  271, 650),
        Mob("Lizard Shaman Lv.170",  276, 600),
        Mob("Dead Eyes Lv.170",  276, 600),
        Mob("Lizard Warrior Lv.150",  301, 680),
        Mob("Djinn Lv.150",  301, 640),
        Mob("Lizard High Shaman Lv.190",  326, 740),
        Mob("Gargoyle Lv.190",  326, 740),
        Mob("Dragon Hatchling Lv. 240",  331, 10000),
        Mob("Lizard Captain lv.180",  361, 815),
        Mob("Minotaur Lv.225",  511, 4250),
        Mob("Minotaur Lv.250",  591, 5000),
        Mob("Dragon Lv.250",  501, 20000),
        Mob("Dragon Warden Lv.280",  626, 30000),
        Mob("Ice Elemental Lv.300",  676, 40000),
        Mob("Minotaur Lv.275",  691, 5750),

    )

    fun trainingCalculator(base:Int, stat:Int, weapon: Int, buff: Int) {
        val normal_min_raw_damage = formula.normalMinRawDamage(stat.toFloat(), weapon.toFloat(), base.toFloat())
        val special_min_raw_damage = formula.specialPhysicalMinSpecialDamage(stat.toFloat(), weapon.toFloat(), base.toFloat())
        val special_min_raw_damage_mage = formula.specialMagicMinDamage(stat.toFloat(), weapon.toFloat(), base.toFloat())
        val normal_max_raw_damage = formula.normalMaxRawDamage(stat.toFloat(), weapon.toFloat(), base.toFloat())
        val special_max_damage = formula.specialMaxDamage(stat.toFloat(), weapon.toFloat(), base.toFloat())
        val special_magic_max_damage = formula.specialMagicMaxDamage(stat.toFloat(), weapon.toFloat(), base.toFloat())
        val arrayNormalTrainning = ArrayList<NormalTrain>()
        val arrayPTrainnigSpecial = ArrayList<NormalTrain>()
        val arrayPTrainningSpecialMage = ArrayList<NormalTrain>()

        println("MIN DAMAGE")
        println("Level: ${base}, Skill: ${stat}, Weapon: ${weapon}")
        println("Min Damage: ${normal_min_raw_damage}")
        println("SPECIAL_MIN_DAMAGE: ${special_min_raw_damage}")
        println("SPECIAL_MIN_DAMAGE_MAGE: ${special_min_raw_damage_mage}")
        println("MAX DAMAGE")
        println("Max Damage: ${normal_max_raw_damage}")
        println("SPECIAL_MAX_DAMAGE_MAGE: ${special_max_damage}")
        println("SPECIAL_MAGIC_MAX_DAMAGE_MAGE: ${special_magic_max_damage}")
        println("---------------NORMAL ATTACK--------------------")
        //esto es por cada mob
        for(creature in mobs){
            //skill normal
            val normal_attack_min_damage = formula.MinDamage(normal_min_raw_damage.toFloat(),
                creature.defense.toFloat()
            )
            val normal_attack_max_damage = formula.MaxDamage(normal_max_raw_damage.toFloat(),
                creature.defense.toFloat()
            )
            val normalAttackPorcentageDamage = formula.AttackPorcentageDamage(
                normal_attack_max_damage.toFloat(),
                normal_min_raw_damage.toFloat(), normal_max_raw_damage.toFloat()
            )
            val timeCalculated = formula.calculateTimeKillingMoster(
                normal_attack_min_damage.toFloat(),
                normal_attack_max_damage.toFloat(),
                normalAttackPorcentageDamage.toFloat(),
                creature.health.toFloat()
            )
            //PTrain fisico
            val special_attack_min_damage = formula.MinDamage(special_min_raw_damage.toFloat(), creature.defense.toFloat())
            val special_attack_max_damage = formula.MaxDamage(special_max_damage.toFloat(), creature.defense.toFloat())
            val specialAttackPorcentageDamage = formula.AttackPorcentageDamage(special_attack_max_damage.toFloat(),special_min_raw_damage.toFloat(),
                special_max_damage.toFloat()
            )
            //PTrainMage
            val special_attack_min_damage_mage = formula.MinDamage(special_min_raw_damage_mage.toFloat(), creature.defense.toFloat())
            val special_attack_max_damage_mage = formula.MaxDamage(special_magic_max_damage.toFloat(), creature.defense.toFloat())
            val specialAttackPorcentageDamageMagic = formula.AttackPorcentageDamage(
                special_attack_max_damage_mage.toFloat(),
                special_min_raw_damage_mage.toFloat(),
                special_magic_max_damage.toFloat()
            )
            arrayNormalTrainning.add(
                    NormalTrain(
                        creature.name,
                        normal_attack_min_damage,
                        normal_attack_max_damage,
                        normalAttackPorcentageDamage
                    )
                )
            arrayPTrainnigSpecial.add(
                NormalTrain(
                    creature.name,
                    special_attack_min_damage,
                    special_attack_max_damage,
                    specialAttackPorcentageDamage
                )
            )
            arrayPTrainningSpecialMage.add(
                NormalTrain(
                    creature.name,
                    special_attack_min_damage_mage,
                    special_attack_max_damage_mage,
                    specialAttackPorcentageDamageMagic
                )
            )
            println("CREATURE: ${creature.name}, MINATTACK: ${normal_attack_min_damage} ,MAXATTACK: ${normal_attack_max_damage}, DAÑO NORMAL: ${normalAttackPorcentageDamage}%, Time: ${formula.convertTime(timeCalculated)}, Numero: ${timeCalculated}")
        }
        println("Skill normal: ${ranks.PorcentageDamage(arrayNormalTrainning)}")
        println("PTrain Special: ${ranks.PorcentageDamage(arrayPTrainnigSpecial)}")
        println("PTrain Magic: ${ranks.PorcentageDamage(arrayPTrainningSpecialMage)}")
    }
}