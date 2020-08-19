package org.kotlinlang.play

fun printMessage(message: String): Unit {
    println(message)
}

fun printMessageWithPrefix(message: String, prefix: String = "Info") {
    print("[$prefix] $message")
}

fun sum(x: Int, y: Int): Int {
    return x + y
}

fun multiply(x: Int, y: Int) = x * y // Inferred

//

class Person(val name: String) {
    val likedPeople = mutableListOf<Person>()
    infix fun likes(other: Person) { likedPeople.add(other) }
}

// varargs...

fun printAll(vararg messages: String) {
    for (m in messages) println(m)
}

fun printAllWithPrefix(vararg messages: String, prefix: String) {
    for (m in messages) println(prefix + m)
}

fun log(vararg entries: String) {
    printAll(*entries) // entries is Array<out String>. To convert vararg, use *.
}

fun main() {
    println("Hello World!!!")

    // Default Parameter Values and Named Arguments
    printMessage("Hello")
    printMessageWithPrefix("Hello", "Log")
    printMessageWithPrefix("Hello")
    printMessageWithPrefix(prefix = "Log", message = "Hello")
    println(sum(1, 3))
    println(multiply(8,3))

    // Infix Functions
//    infix fun Int.times(str: String) = str.repeat(this)
//    println(2 times "Bye")

    val pair = "Ferrari" to "Katrina" // (String, String)
    println(pair)

    infix fun String.onto(other: String) = Pair(this, other)
    val myPair = "McLaren" onto "Lucas"
    println(myPair)

    val sophia = Person("Sophia")
    val claudia = Person("Claudia")
    sophia likes claudia
    println(sophia.likedPeople)

    operator fun Int.times(str: String) = str.repeat(this)
    println(2 * "Bye") // Operator supports 'times' and '*', but infix only supports 'times'.

    operator fun String.get(range: IntRange) = substring(range)
    val str = "Always forgive your enemies; nothing annoys them so much."
    println(str[0..14])

    // varargs
    printAll("Hello", "Hallo", "Salut", "Hola", "你好")

    printAllWithPrefix(
            "Hello", "Hallo", "Salut", "Hola", "你好",
            prefix = "Greeting: "
    )
}