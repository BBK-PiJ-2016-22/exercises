def cons = new BufferedReader(new InputStreamReader(System.in))

boolean quit = false
boolean valid = false
boolean done = false
int atCount = 0
int i
boolean from = false
String mailFrom = ""
String mailTo = ""

//get MAIL FROM
//and check MAIL FROM is valid ("MAIL FROM:" && includes an @ not 1st or last)
// if QUIT, terminate WITH A BYE
// if INVALID, say invalid

while (!done) {
    print ">>> "
    str = cons.readLine()

    if (str == "QUIT") {
        quit = true
        break
    }

    if (str.length() > 11) {
        if (str.substring(0, 10) == "MAIL FROM:") {
            from = true
        }
    }

    if (!from) {
        println "Invalid command"
    }

    if (from) {
        for (i = 12; i <= str.length() - 2; i++) {
            if (str.substring(i, i + 1) == "@") {
                atCount++
            }
        }

        if (atCount == 1) {
            mailFrom = str.substring(10, str.length())
            done = true
        } else {
            println "Invalid email address"
            from = false
            atCount = 0
        }
    }

}

//get RCPT TO
//and check RCPT TO is valid ("RCPT TO:" && includes an "@ not 1st or last)
// if QUIT, terminate WITH A BYE
// if INVALID, say invalid

done = false
from = false
atCount = 0

while (!done && !quit) {
    print ">>> "
    str = cons.readLine()
    if (str == "QUIT") {
        quit = true
        break
    }
    if (str.length() > 9) {
        if (str.substring(0, 8) == "RCPT TO:") {
            from = true
        }
    }
    if (!from) {
        println "Invalid command"
    }

    if (from) {
        for (i = 10; i <= str.length() - 2; i++) {
            if (str.substring(i, i + 1) == "@") {
                atCount++
            }
        }
        if (atCount == 1) {
            mailTo = str.substring(8, str.length())
            done = true
        } else {
            System.out.println("Invalid email address")
            from = false
            atCount = 0
        }
    }
}

//get DATA
// only start once DATA entered, if QUIT terminate
// enter line by line until line is only "." and then stop reading


boolean data = false
done = false
String str = ""
int k = 0
String[] content = new String[100]

while (!done && !quit) {
    print ">>> "
    str = cons.readLine()

    if (str == "QUIT") {
        quit = true
        break
    }

    if (str == "DATA") {
        data = true
    }

    if (!data) {
        println "Invalid command"
    }

    if (data) {
        while (!done) {
            print "> "
            str = cons.readLine();
            if (str == "QUIT") {
                quit = true
                break
            }
            if (str == ".") {
                done = true
            } else {
                content[k] = str
                k++
            }
        }
    }

    if (quit) {
        break
    }
}

//write out MAIL FROM, REPT TO AND THE DATA
if (!quit) {
    println "Sending email..."
    println "FROM: " + mailFrom
    println "to: " + mailTo

    int j = 0
    while (j < k) {
        println content[j]
        j++
    }
    println "...done!"

    while (true) {
        print ">>> "
        str = cons.readLine()
        if (str == "QUIT") {
            quit = true
            break
        } else {
            println "enter QUIT to quit.."
        }
    }
}

println "Bye!"
