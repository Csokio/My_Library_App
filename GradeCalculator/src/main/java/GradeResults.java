import java.util.List;

public class GradeResults {

    private int minGrade;
    private int maxGrade;
    private double averageGrade;


    public int getMinGrade() {
        return minGrade;
    }

    public void setMinGrade(int minGrade) {
        this.minGrade = minGrade;
    }

    public int getMaxGrade() {
        return maxGrade;
    }

    public void setMaxGrade(int maxGrade) {
        this.maxGrade = maxGrade;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

    public int calculateMinimum(List<Integer> grades)
    {
        int minimumValue = grades.get(0);
        for(int i = 1; i < grades.size(); i++){
            if(grades.get(i) < minimumValue){
                minimumValue = grades.get(i);
            }
        }
        return minimumValue;
    }
    public int calculateMaximum(List<Integer> grades)
    {
        int maximumValue = grades.get(0);
        for(int i = 1; i < grades.size(); i++){
            if(grades.get(i) > maximumValue){
                maximumValue = grades.get(i);
            }
        }
        return maximumValue;
    }
    public double calculateAverage(List<Integer> grades)
    {
        double sum = 0;
        for(int i = 0; i < grades.size(); i++){
            sum += grades.get(i);
        }
        return sum / grades.size();
    }

}
