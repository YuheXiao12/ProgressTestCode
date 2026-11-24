public class AIproject extends Assessment{
    private double functionalityMark;
    private double verificationMark;

    public AIproject(String cid) {
        super(AssessmentFeed.AI_PROJECT, true);
        functionalityMark = AssessmentFeed.getResult(cid, AssessmentFeed.AI_PROJECT, AssessmentFeed.FUNCTIONALITY_MARK);
        verificationMark = AssessmentFeed.getResult(cid, AssessmentFeed.AI_PROJECT, AssessmentFeed.VERIFICATION_MARK);
    }

    @Override
    public double calculateMark() {
        return 0.4*functionalityMark +0.6*verificationMark;
    }

    @Override
    public void printDetails() {
        System.out.printf("Functionality mark:%.2f%%%n");
        System.out.printf("verification mark:%.2f%%%n");
    }
}
