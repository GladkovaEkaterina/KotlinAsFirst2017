package testing

import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class RunResultsKtTest {

    @Test
    fun runResults() {
        assertEquals("Николаев  12:48, Михайлов 12:51, Фомин 12:59, Анфисов 13:00", runResults("Фомин 12:59, Анфисов 13:00, Николаев  12:48, Михайлов 12:51"))
    }
}