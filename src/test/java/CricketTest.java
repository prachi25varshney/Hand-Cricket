import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CricketTest {
    @Test
    void shouldReturnWonOrLoseWhenBatsmanTargetRunsIsNotBeyondThirtySix() {
        Batsman batsman = new Batsman();
        Cricket cricket = new Cricket(28, batsman);

        cricket.play();

        assertThat(cricket.result(), anyOf(is(Result.WON), is(Result.LOSE)));
    }

    @Test
    void shouldReturnNULLWhenBatsmanTargetRunsIsBeyondThirtySix() {
        Batsman batsman = new Batsman();
        Cricket cricket = new Cricket(45, batsman);

        cricket.play();

        assertThat(cricket.result(), is(equalTo(null)));
    }
}
