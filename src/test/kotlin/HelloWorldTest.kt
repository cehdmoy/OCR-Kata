import org.junit.Assert.assertEquals
import org.junit.Test

class HelloWorldTest {


    private val buildHelloWorld: HelloWorld by lazy {
        val helloWorld = HelloWorld();helloWorld
    }

    @Test
    fun checkHelloWorld() {
        val helloWorld = buildHelloWorld
        assertEquals("Yeah baby this is my first ktl code", helloWorld.hello())
    }
}

