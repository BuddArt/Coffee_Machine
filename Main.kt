package machine

var hasWater = 500
var hasMilk = 540
var hasCB = 120
var hasCups = 9
var hasMoney = 550
var exit = 0

fun main () {
    do {
        print("\nWrite action (buy, fill, take, remaining, exit):\n> ")
        val inpAction = readln()
        when (inpAction) {
            "remaining" -> remaining()
            "buy" -> buy()
            "fill" -> fill()
            "take" -> take()
            "exit" -> exit = 1
        }
    } while (exit == 0)
}

fun remaining() {
    println("""
                
        The coffee machine has:
        $hasWater ml of water
        $hasMilk ml of milk
        $hasCB g of coffee beans
        $hasCups disposable cups
        $$hasMoney of money
    """.trimIndent())
}

fun buy() {
    print("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:\n> ")
    val wantToBuy = readln().toString()

    if (wantToBuy == "1") { if (hasWater < 250) {
        println("Sorry, not enough water!")
    } else if (hasCB < 16) {
        println("Sorry, not enough coffee beans!")
    } else if (hasCups < 1) {
        println("Sorry, not enough cups!")
    } else {
        println("I have enough resources, making you a coffee!")
        hasWater -= 250; hasCB -= 16; hasCups -= 1; hasMoney += 4
    }
    } else if (wantToBuy == "2") { if (hasWater < 350) {
        println("Sorry, not enough water!")
    } else if (hasCB < 20) {
        println("Sorry, not enough coffee beans!")
    } else if (hasCups < 1) {
        println("Sorry, not enough cups!")
    } else if (hasMilk < 75) {
        println("Sorry, not enough milk!")
    } else {
        println("I have enough resources, making you a coffee!")
        hasWater -= 350; hasMilk -= 75; hasCB -= 20; hasCups -= 1; hasMoney += 7
    }
    } else if (wantToBuy == "3") { if (hasWater < 200) {
        println("Sorry, not enough water!")
    } else if (hasCB < 12) {
        println("Sorry, not enough coffee beans!")
    } else if (hasCups < 1) {
        println("Sorry, not enough cups!")
    } else if (hasMilk < 100) {
        println("Sorry, not enough milk!")
    } else {
        println("I have enough resources, making you a coffee!")
        hasWater -= 200; hasMilk -= 100; hasCB -= 12; hasCups -= 1; hasMoney += 6
    }
    } else if (wantToBuy == "back") return
}

fun fill() {
    print("\nWrite how many ml of water you want to add:\n> ")
    val addwater = readln().toInt()
    print("Write how many ml of milk you want to add:\n> ")
    val addMilk = readln().toInt()
    print("Write how many grams of coffee beans you want to add:\n> ")
    val addCB = readln().toInt()
    print("Write how many disposable cups you want to add:\n> ")
    val addCups = readln().toInt()

    hasWater += addwater; hasMilk += addMilk; hasCB += addCB; hasCups += addCups
}

fun take() {
    print("\nI gave you $hasMoney\n")
    hasMoney = 0
}

