import java.util.ArrayList;
import java.util.List;

public class Student {

    private final String cid;
    private final String name;
    private final String type;

    private final ArrayList<Assessment> assessments;
    private final ArrayList<Double> weights;

    public Student(String cid) {
        this.cid = cid;
        name = AssessmentFeed.getStudentName(cid);
        type = AssessmentFeed.getStudentType(cid);

        assessments = new ArrayList<>();
        weights = new ArrayList<>();

        if (type.equalsIgnoreCase("MSc")) {//the weights fir msc students

            addAssessment(new ProgrammingTest(cid), 0.25);
            addAssessment(new AIproject(cid), 0.45);
            addAssessment(new DesignViva(cid), 0.30);

        } else if (type.equalsIgnoreCase("UG")) {//weights for ug students

            addAssessment(new ProgrammingTest(cid), 0.30);
            addAssessment(new AIproject(cid), 0.70);

        } else {
            throw new IllegalArgumentException(
                    "Unknown student type: " + type);
        }
    }

    public void addAssessment(Assessment assessment,
                              double weight) {
        assessments.add(assessment);
        weights.add(weight);
    }

    public String getCid() {
        return cid;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public List<Assessment> getAssessments() {
        return new ArrayList<>(assessments);
    }

    // total marks
    public double calculateOverallMark() {
        double total = 0.0;
        double totalWeight = 0.0;

        for (int i = 0; i < assessments.size(); i++) {

            total += assessments.get(i).calculateMark()//get the msrk of each assessment
                    * weights.get(i);//multiply the weights

            totalWeight += weights.get(i);
        }

        if (totalWeight == 0) {
            return 0.0;
        }

        return total / totalWeight;
    }

    // AI permitted assessments average(should be divided by the number of ai-permitted assessments)
    public double calculateAIAverage() {

        double total = 0.0;
        int count = 0;

        for (Assessment assessment : assessments) {

            if (assessment.isAiPermitted()) {
                total += assessment.calculateMark();
                count++;
            }
        }

        return count == 0 ? 0.0 : total / count;
    }


    public double calculateNonAIAverage() {

        double total = 0.0;
        int count = 0;

        for (Assessment assessment : assessments) {

            if (!assessment.isAiPermitted()) {
                total += assessment.calculateMark();
                count++;
            }
        }

        return count == 0 ? 0.0 : total / count;
    }

    // differences
    public boolean aiDifferences() {

        return calculateAIAverage()
                - calculateNonAIAverage() >= 20.0;
    }

    // find the marks according to the name of the assessment
    public String getAssessmentResult(String title) {

        for (Assessment assessment : assessments) {

            if (assessment.getTitle().equals(title)) {

                return String.format("%.2f%%",
                        assessment.calculateMark());
            }
        }

        return "N/A";
    }

    // print the report at console
    public void printReport() {

        System.out.println("Name: " + name);
        System.out.println("CID: " + cid);
        System.out.println("Student type: " + type);

        for (Assessment assessment : assessments) {

            System.out.println();

            System.out.println(assessment.getTitle());

            assessment.printDetails();

            System.out.printf("Final mark: %.2f%%%n",
                    assessment.calculateMark());
        }

        System.out.printf("%nOverall mark: %.2f%%%n",
                calculateOverallMark());

        System.out.printf("AI average: %.2f%%%n",
                calculateAIAverage());

        System.out.printf("Non-AI average: %.2f%%%n",
                calculateNonAIAverage());

        System.out.printf("AI discrepancy: %.2f percentage points%n",
                calculateAIAverage() - calculateNonAIAverage());

        System.out.println("AI discrepancy warning: "
                + aiDifferences());
    }
}

