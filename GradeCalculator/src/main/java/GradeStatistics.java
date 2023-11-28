import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GradeStatistics {

    private final Scanner scanner;
    private final List<Integer> gradesList = new ArrayList<>();

    public GradeStatistics(Scanner scanner){
        this.scanner = scanner;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            new GradeStatistics(scanner).run();
        }

    }

    private void run()
    {
        System.out.println("Welcome to the Grade Calculator!");
        int grade;
        do {
            grade = readGrade();
            if(grade != 0){
                gradesList.add(grade);
            }
        }   while (grade != 0);
        if(gradesList.size() > 0){
            double[] resultGrades = calculate();
            System.out.printf("The worst grade is %.0f, while the best grade %.0f and the average of grades is: %.2f :)", resultGrades[0], resultGrades[1],resultGrades[2]);
        }   else {
            System.out.println("There aren't any grades added yet.");
        }

        System.out.println(" - Thanks for using the calculator!");
    }

    private int readGrade()
    {
        while (true){
            System.out.println("Please give the " + gradesList.size() + ". grade :)");
            int grade = scanner.nextInt();
            if(isValidNumber(grade)){
                return grade;
            } else {
                System.out.println("The grade must be between 1 and 5 !!");
            }
        }
    }

    private double[] calculate()
    {
        GradeResults gradeResults = new GradeResults();
        gradeResults.setMinGrade(gradeResults.calculateMinimum(gradesList));
        gradeResults.setMaxGrade(gradeResults.calculateMaximum(gradesList));
        gradeResults.setAverageGrade(gradeResults.calculateAverage(gradesList));
        double[] statistics = new double[3];
        statistics[0] = (double) gradeResults.getMinGrade();
        statistics[1] = (double) gradeResults.getMaxGrade();
        statistics[2] = gradeResults.getAverageGrade();
        return statistics;
    }

    private boolean isValidNumber(int grade)
    {
        return grade >= 0 && grade < 6;
    }
}
