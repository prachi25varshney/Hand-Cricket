enum Result {
    LOSE,
    WON
}

public class Cricket {
    private final int targetRuns;
    private final Batsman batsman;
    private Result result;

    public Cricket(int targetRuns, Batsman batsman) {
        this.targetRuns = targetRuns;
        this.batsman = batsman;
    }

    public void play() {
        if (!validateTargetRuns(targetRuns))
            return;
        int totalRuns = 0;
        for (int i = 1; i <= 6; i++) {
            totalRuns = totalRuns + batsman.bat();
            if (isRunsChased(totalRuns)) {
                result = Result.WON;
                return;
            }
        }
        result = Result.LOSE;
    }

    private boolean validateTargetRuns(int targetRuns) {
        int maxRunsPerOver = 36;
        return targetRuns <= maxRunsPerOver;
    }

    public Result result() {
        return result;
    }

    private boolean isRunsChased(int totalRuns) {
        return totalRuns >= targetRuns;
    }
}
