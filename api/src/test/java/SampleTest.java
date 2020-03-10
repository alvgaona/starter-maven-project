import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class SampleTest {
    @Test
    public void givenHello_whenWorld_thenMessage() {
        final String message = "Hello, World!";
        Assertions.assertThat(message).isNotEmpty();
    }
}
