import kotlin.test.Test
import kotlin.test.assertEquals
import work.nitycnyuta.helloworld.Calculator

class CalculatorTest {
    @Test
    fun testPlus() {
        val calculator = Calculator(20, 10)
        assertEquals(30, calculator.plus())
    }
}
