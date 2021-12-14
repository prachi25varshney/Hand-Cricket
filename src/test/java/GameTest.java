import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class GameTest {
    @Test
    void shouldReturnWonOrLoseWhenBatsmanTargetRunsIsNotBeyondThirtySix() {
        Batsman batsman = new Batsman();
        Game game = new Game(28, batsman);

        game.play();

        assertThat(game.result(), anyOf(is(Result.WON), is(Result.LOSE)));
    }

    @Test
    void shouldReturnNULLWhenBatsmanTargetRunsIsBeyondThirtySix() {
        Batsman batsman = new Batsman();
        Game game = new Game(45, batsman);

        game.play();

        assertThat(game.result(), is(equalTo(null)));
    }
}
