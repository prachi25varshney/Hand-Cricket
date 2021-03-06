import java.util.Random;

enum Type {
    ZERO,
    ONE
}
public class Batsman {
    private final Type type;

    public Batsman(Type type) {
        this.type = type;
    }

    public int bat() {
        if(this.type== Type.ZERO)
            return runsPerBallForTypeZeroBatsman();
        return runsPerBallForTypeOneBatsman();
    }

    private int runsPerBallForTypeOneBatsman() {
        int[] scores = new int[]{0, 4, 6};
        int random_index = new Random().nextInt(scores.length);
        return scores[random_index];
    }

    private int runsPerBallForTypeZeroBatsman() {
        int maxRunPerBall = 6;
        Random random = new Random();
        return random.nextInt(maxRunPerBall);
    }
}
