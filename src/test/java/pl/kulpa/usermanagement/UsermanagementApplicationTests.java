package pl.kulpa.usermanagement;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class UsermanagementApplicationTests {

    @Test
    void contextLoads() {
        Optional<String> s = Optional.of("3");

        System.out.println(s.isPresent());
    }

}
