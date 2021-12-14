import java.util.Random;

public class Batsman {
    public Batsman() {
    }

    public int bat() {
        return getRandomScoreForRun();
    }

    private int getRandomScoreForRun() {
        int maxRunPerBall = 6;
        Random random = new Random();
        return random.nextInt(maxRunPerBall);
    }
}
