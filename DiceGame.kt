package com.example.myapplication

/*
    Student ID           :- A00254708
    Student Name         :- Ruchit Patel

    
    Program & Assignment :- MAPD /
    Program Defination   :- Lab1 - Classes/ Objects
 */
object DiceGame {
    @JvmStatic
    fun main(args: Array<String>) {
        var sideUp: Int
        var sides: Int
        var name: String

        // ************ Create different sized dice using each constructor ************
        // Constructor 1: Default Dice
        println("\n")
        println("1-")
        println("This is default dice")
        val dice = Die()
        sideUp = dice.sideUp
        sides = dice.getSides()
        name = dice.diceName
        showDiceData(sides, sideUp, name)
        println("\n")

        // ************ Roll the dice and display their results (before and after)
        diceResultBeforeAndAfter(dice)

        // Constructor 2: Dice with number of sides parameter
        println("\n")
        println("2-")
        println("This is  dice with number of sides parameter")
        val diceWithSides = Die(10)
        sideUp = diceWithSides.sideUp
        sides = diceWithSides.getSides()
        name = diceWithSides.diceName
        showDiceData(sides, sideUp, name)
        println("\n")

        // ************ Roll the dice and display their results (before and after)
        diceResultBeforeAndAfter(diceWithSides)

        // Constructor 3: Dice with number of sides and name parameter
        println("\n")
        println("3-")
        println("This is dice with number of sides and name parameter")
        val diceWithNameAndSides = Die(10, "Death Roll")
        sideUp = diceWithNameAndSides.sideUp
        sides = diceWithNameAndSides.getSides()
        name = diceWithNameAndSides.diceName
        showDiceData(sides, sideUp, name)
        println("\n")

        // ************ Roll the dice and display their results (before and after)
        diceResultBeforeAndAfter(diceWithNameAndSides)

        // ************ Choose one Die object and set it to show it's highest value
        println("\n")
        println("4-")
        diceWithSides.showHighestValue()

        // ************ BONUS (optional): create 5 six-sided dice. Roll each Die in a
        // loop until you get 5 of a kind. Count and display the number of rolls.
        // ************
        println("\n")
        println("5-")
        find5OfKind()
        println("\n")
    }

    // This method takes sides, sideUp and name as argument and show it to user
    //
    fun showDiceData(sides: Int, sideUp: Int, name: String) {
        println("Number of sides: $sides")
        println("Face of dice: $sideUp")
        println("Name of dice: $name")
    }

    // This method takes dice object as parameter
    // Shows Side up before and after a single roll
    //
    fun diceResultBeforeAndAfter(dice: Die) {
        val sideUp = dice.sideUp
        println("Face before roll: $sideUp")
        dice.roll()
        val sideUpAfterRoll = dice.sideUp
        println("Face after roll: $sideUpAfterRoll")
    }

    // This method create 5 dice objects
    // Then roll all dices one by one until a 5 of a kind appears
    // Shows number of total rolls before 5 of a kind happened
    //
    fun find5OfKind() {
        val diceArray = arrayOfNulls<Die>(5)
        for (i in diceArray.indices) {
            diceArray[i] = Die()
        }
        var prevSide = -1
        var count = 0

        /* This is the logic to roll the dice one by one */
        var i = 0
        while (i < diceArray.size) {
            val dice = diceArray[i]
            dice!!.roll()
            val sideUp = dice.sideUp
            if (prevSide == -1) {
                prevSide = sideUp
            } else if (prevSide != sideUp) {
                i = 0
                count += 1
            } else {
                i += 1
            }
        }


        println("Found 5 of a kind in: $count")
    }
}