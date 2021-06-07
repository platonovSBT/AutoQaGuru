package lesson5;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class InitTest {
    @BeforeAll
    public static void setup() {
        Configuration.startMaximized = true;
    }
}
