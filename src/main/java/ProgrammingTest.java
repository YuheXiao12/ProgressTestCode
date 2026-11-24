public class ProgrammingTest extends Assessment {

    private final double programMark;
    private final boolean explainedSuccessfully;

    public ProgrammingTest(String cid) {
        super(AssessmentFeed.PROGRAMMING_TEST, false);
        programMark = AssessmentFeed.getResult(cid, AssessmentFeed.PROGRAMMING_TEST, AssessmentFeed.PROGRAM_MARK);
        explainedSuccessfully = AssessmentFeed.getResult(cid, AssessmentFeed.PROGRAMMING_TEST, AssessmentFeed.EXPLAINED_SUCCESSFULLY) == 1.0;
    }

    @Override
    public double calculateMark() {
        if (explainedSuccessfully) {
            return programMark;
        }
        return Math.min(programMark, 40.0);
    }

    @Override
    public void printDetails() {
        System.out.printf("Program mark: %.2f%%%n", programMark);
        System.out.println("Explained successfully: " + explainedSuccessfully);
    }
}



