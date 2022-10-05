var myName = "Unbekannt"
var selection = "Unbekannt"
var selectionENEMY = "Unbekannt"
var resultList = mutableListOf<String>()
var myPoints = 0
var enemyPoints = 0


fun main(){
    newGame()
    newRound()
}

fun newRound(){
    computerSelection()
    readUserInput()
    if(selection == "EXIT") {
        println("Spiel wird beendet! \n")
        printResults()
    } else {
        evaluateGame()
    }
}

fun printResults(){
    println("===== ERGEBNISSE =====")
    println("Punkte (du) $myPoints")
    println("Punkte (Gegner) $enemyPoints")
    resultList.forEachIndexed {index, value ->
        var nexIndex = index + 1
        println("($nexIndex) $value")
    }
}

fun computerSelection(){
    val computerChoice = (1..3).random()
    selectionENEMY = when(computerChoice) {
        1 -> "Schere"
        2 -> "Stein"
        3 -> "Papier"
        else -> "Unbekannt"
    }
}

fun newGame(){
    println("Bitte gebe deinen Namen ein: ")
    myName = readln()
    println("Herzlich willkommen zu diesem Spiel.")
    println("Heutiger Spieler: $myName \n")
}

fun readUserInput() {
    println("======= Deine Auswahl =======")
    println("(1) Schere")
    println("(2) Stein")
    println("(3) Papier")
    println("(9) Spiel beenden")
    var userSelect = readln()


    selection = when(userSelect) {
        "1" -> "Schere"
        "2" -> "Stein"
        "3" -> "Papier"
        "9" -> "EXIT"
        else -> "Unbekannt"
    }

    if (selection == "Unbekannt") {
        println("Falsche Eingabe! \n")
        readUserInput()
    }
}

fun evaluateGame(){
    println("Deine Auswahl: $selection")
    println("Dein Gegener: $selectionENEMY")
    if(selection == selectionENEMY) {
        println("Unentschieden")
        resultList.add("[Du] $selection [Gegner] $selectionENEMY -> Unentschieden")
    } else {
        if(selection == "Schere") {
            if(selectionENEMY == "Papier") {
                println("Gewonnen!")
                myPoints++
                resultList.add("[Du] $selection [Gegner] $selectionENEMY -> Gewonnen")
            } else {
                println("Verloren")
                enemyPoints++
                resultList.add("[Du] $selection [Gegner] $selectionENEMY -> Verloren")
            }
        }

        if(selection == "Papier") {
            if(selectionENEMY == "Schere") {
                println("Verloren!")
                enemyPoints++
                resultList.add("[Du] $selection [Gegner] $selectionENEMY -> Verloren")
            } else {
                println("Gewonnen")
                myPoints++
                resultList.add("[Du] $selection [Gegner] $selectionENEMY -> Gewonnen")
            }
        }


        if(selection == "Stein") {
            if(selectionENEMY == "SCHERE") {
                println("Gewonnen!")
                myPoints++
                resultList.add("[Du] $selection [Gegner] $selectionENEMY -> Gewonnen")
            } else {
                println("Verloren")
                enemyPoints++
                resultList.add("[Du] $selection [Gegner] $selectionENEMY -> Verloren")
            }
        }
    }


    newRound()
}