package work.nitycnyuta.helloworld

class Calculator(private val a: Int, private val b: Int) {
    fun plus(): Int {
        return a + b
    }

    fun minus(): Int {
        return a - b
    }

    fun mul(): Int {
        return a * b
    }

    fun div(): Int {
        return a / b
    }
}
