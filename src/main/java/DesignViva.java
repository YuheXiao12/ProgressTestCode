public class DesignViva extends Assessment {

    private final double designMark;
    private final double explanationMark;

    public DesignViva(String cid) {
        super(AssessmentFeed.DESIGN_VIVA, false);
        designMark = AssessmentFeed.getResult(cid, AssessmentFeed.DESIGN_VIVA, AssessmentFeed.DESIGN_MARK);
        explanationMark = AssessmentFeed.getResult(cid, AssessmentFeed.DESIGN_VIVA, AssessmentFeed.EXPLANATION_MARK);
    }

    @Override
    public double calculateMark() {
        return 0.5 * designMark + 0.5 * explanationMark;
    }

    @Override
    public void printDetails() {
        System.out.printf("Design mark: %.2f%%%n", designMark);
        System.out.printf("Explanation mark: %.2f%%%n", explanationMark);
    }
}


