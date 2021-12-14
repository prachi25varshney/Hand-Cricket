import java.util.Random;

public class Batsman {
    public Batsman() {
    }

    public int bat() {
        return getRandomNumberForRun();
    }

    private int getRandomNumberForRun() {
        int maxRunPerBall = 6;
        Random random = new Random();
        return random.nextInt(maxRunPerBall);
    }
}
