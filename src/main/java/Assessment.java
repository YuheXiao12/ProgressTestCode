public abstract class Assessment {
    private String title;
    private double maximumMark = 100.0;
    private boolean aiPermitted;
    public Assessment(String title, boolean aiPermitted) {
        this.title = title;
        this.aiPermitted = aiPermitted;
    }

    public String getTitle() {
        return title;
    }

    public double getMaximumMark() {
        return maximumMark;
    }

    public boolean isAiPermitted() {
        return aiPermitted;
    }

    public abstract double calculateMark();

    public abstract void printDetails();
}






