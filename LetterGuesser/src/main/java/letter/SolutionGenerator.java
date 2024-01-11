package letter;

import letter.PIN;

import java.util.Random;

public class SolutionGenerator {

    public PIN generateSolution(){
        Random random = new Random();
        int solution = random.nextInt(10_000);
        return new PIN(solution);
    }
}
