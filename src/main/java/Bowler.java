import java.util.Random;

public class Bowler {
    public Bowler() {
    }

    public int bowl() {
        return runsPerBall();
    }

    private int runsPerBall() {
        int maxRunPerBall = 6;
        Random random = new Random();
        return random.nextInt(maxRunPerBall);
    }
}
