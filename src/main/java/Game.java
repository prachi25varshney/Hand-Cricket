enum Result {
    LOST,
    WON
}

public class Game {
    private final int targetRuns;
    private final int overs;
    private final Batsman batsman;
    private final Bowler bowler;
    private Result result;

    public Game(int targetRuns, int overs, Batsman batsman, Bowler bowler) {
        this.targetRuns = targetRuns;
        this.overs = overs;
        this.batsman = batsman;
        this.bowler = bowler;
    }

    public void play() {

        chasingTargetRuns();
        if (result == Result.WON) return;
        result = Result.LOST;
    }

    public Result result() {
        return result;
    }

    public void chasingTargetRuns() {
        int totalScoredRuns = 0;
        int totalBalls = 6 * this.overs;

        for (int i = 1; i <= totalBalls; i++) {
            int batsmanRun = batsman.bat();
            int bowlerRun = bowler.bowl();

            if (isBatsmanOut(batsmanRun, bowlerRun)) {
                return;
            }

            totalScoredRuns += batsmanRun;
            if (isRunsChased(totalScoredRuns)) {
                result = Result.WON;
                return;
            }
        }
    }

    private boolean isBatsmanOut(int batsmanRun, int bowlerRun) {
        return batsmanRun == bowlerRun;
    }

    private boolean isRunsChased(int totalRuns) {
        return totalRuns >= targetRuns;
    }
}
