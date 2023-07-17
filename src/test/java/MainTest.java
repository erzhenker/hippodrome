import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Disabled
    @Timeout(value = 22)
    @Test
    void timeoutMain() throws Exception {
        Main.main(null);
    }
}