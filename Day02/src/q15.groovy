def cons = new BufferedReader(new InputStreamReader(System.in))

int numToGuess = Math.abs(1000 * Math.random())

int countGuess = 0
boolean gotIt = false

println "Try to guess my number"

while (!gotIt) {

    print "Tell me a number: "
    String str = cons.readLine()
    int thisGuess = Integer.parseInt(str)
    countGuess++

    if (thisGuess < numToGuess) {
        println " No, my number is higher"
    }

    if (thisGuess > numToGuess) {
        println " No, my number is lower"
    }

    gotIt = thisGuess == numToGuess
    if (gotIt) {
        println "CORRECT"
        println "You needed " + countGuess + " guesses."
    }
}
