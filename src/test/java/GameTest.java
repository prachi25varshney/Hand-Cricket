import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameTest {

    Batsman batsman;
    Bowler bowler;

    @BeforeEach
    public void beforeEach() {
        batsman = mock(Batsman.class);
        bowler = mock(Bowler.class);
    }

    @Test
    void shouldWonOrLoseWhenBatsmanTargetRunsIsNotBeyondThirtySix() {
        Game game = new Game(12, 1, batsman, bowler);
        when(batsman.bat()).thenReturn(2, 3, 4, 3);

        game.play();

        assertThat(game.result(), anyOf(is(Result.WON)));
    }

    @Test
    void shouldLostWhenBatsmanCannotMakeTargetRunsInGivenOvers() {
        Game game = new Game(45, 1, batsman, bowler);
        when(batsman.bat()).thenReturn(2, 3, 4, 3, 5, 6);

        game.play();

        assertThat(game.result(), is(equalTo(Result.LOST)));
    }

    @Test
    void shouldLostWhenBatsmanGotOut() {
        Game game = new Game(28, 2, batsman, bowler);
        when(batsman.bat()).thenReturn(2, 3, 4, 3, 5, 6);
        when(bowler.bowl()).thenReturn(0, 1, 2, 5, 4, 6);

        game.play();

        assertThat(game.result(), is(equalTo(Result.LOST)));
    }

    @Test
    void shouldHitByHitterManWhenBatsmanTypeIsOne() {
        Batsman batsman1 = new Batsman(Type.ONE);
        Game game = new Game(10, 1, batsman1, bowler);
        when(bowler.bowl()).thenReturn(1, 1, 2, 5, 2, 2);

        game.play();

        assertThat(game.result(), is(equalTo(Result.WON)));
    }
}

