def cons = new BufferedReader(new InputStreamReader(System.in))

print "Enter a number: "
String str = cons.readLine()
int input = Integer.parseInt(str)

boolean done = false
int count = 1
int testUp, testDown
boolean primeUp, primeDown
int allNums


while (!done) {

    // get numbers to test
    testUp = input + count
    testDown = input - count

    //test for primes
    primeUp = true
    allNums = 2
    while (allNums < testUp) {
        if (testUp % allNums == 0) {
            primeUp = false
            break
        }
        allNums++
    }

    primeDown = true
    allNums = 2
    while (allNums < testDown) {
        if (testDown % allNums == 0) {
            primeDown = false
            break
        }
        allNums++
    }
    // output answer
    if (primeUp && primeDown) {
        println "BOTH DIRECTIONS"
        done = true
    }
    if (primeUp) {
        println "Up: " + testUp
        done = true
    }
    if (primeDown) {
        println "Down: " + testDown
        done = true
    }

    count++
}
