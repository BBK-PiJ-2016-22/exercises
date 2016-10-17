def cons = new BufferedReader(new InputStreamReader(System.in))

//get input text and its length
print "Please write a text: "
String inputText = cons.readLine()
int inputLength = inputText.length()

//adapt string to exclude non letters and make them all lower case
int j = 0
char checkLetter
String revisedString = ""
while (j < inputLength) {
    checkLetter = inputText.charAt(j)
    if (checkLetter.isLetter()) {
        revisedString = revisedString + checkLetter.toLowerCase()
    }
    j++
}
println revisedString

//test letters against each other
String frontLetter, backLetter
int i = 0
boolean palindrome = true
inputText = revisedString
inputLength = inputText.length()

while (i < inputLength) {
    frontLetter = inputText.charAt(i)
    backLetter = inputText.charAt(inputLength - i - 1)
    if (frontLetter != backLetter) {
        palindrome = false
    }
    i++
}

//output
if (palindrome) {
    println "That's a relaxed palindrome"
} else {
    println "That's NOT a relaxed palindrome"
}

