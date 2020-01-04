// Functions
fun double(x: Int): Int{
	return 2*x
}

fun sum(a: Int, b: Int) = a + b // Return type was inferred as Int

// Default Arguments
fun foo(i: Int = 10): Int{
	return i
}

open class A{
	open fun foo(i: Int = 10): Int{
		return i
	}
}

class B : A() {
	override fun foo(i: Int): Int {
		return i
	}
}

fun foo_2(bar: Int = 0, baz: Int): Int{
	return bar + baz
}

// end

fun foo_3(bar: Int = 0, baz: Int = 1, qux: () -> Unit){
	qux()
}

fun foo_4(str: String, bool: Boolean = true, wordSeparator: Char = '_'){
	print("${str}${wordSeparator}${bool}\n")
}

fun foo_5(vararg integers: Int){
	for (i in integers)
		println(i)
}

fun printHello(name: String?): Unit{
	if (name != null)
		println("Hello, ${name}")
	else
		println("Hi there!")
}

infix fun Int.shl(x: Int): Int {
	return x
}

// main
fun main(){
	println("Hello World!")
	
	// Functions
	println("Functions\n")
	
	val result_1 = double(3)
	println("Double of 3: ${result_1}")
	println("Sum of 3 and 4: ${sum(3, 4)}")
	println("Default argument: ${foo()}")
	println("Changed argument: ${foo(30)}")
	val a = A()
	println("a.foo(): ${a.foo()}")
	val b = B()
	println("b.foo(30): ${b.foo(30)}")
	println("foo_2(baz=30): ${foo_2(baz=30)}")
	
	foo_3() {println("Test")}
	foo_4("String", bool = false)
	
	//println(Arrays.toString(intArrayOf(1, 2)))
	intArrayOf(1,2,3).forEach {println(it)}
	println("Test")
	foo_5(3, 4, 3, *intArrayOf(2, 3)) // * is 'spread operator
	
	printHello("Kate")
	printHello(null)
	
	print(3.shl(3))
}

