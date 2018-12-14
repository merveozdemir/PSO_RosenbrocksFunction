


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Merve
 */
public class Problem {

    String name;
    double result = 0;
    int dimension;

    public Problem(int dimension) {
        this.dimension = dimension;
    }

    double getResult(Particle p) {
        return calculate(p);
    }

    double calculate(Particle particle) {
        double fitnessResult = 0;
        double x[] = particle.position;
        for (int i = 0; i < dimension - 1; i++) {
            // System.out.println("--- "+ Math.pow((x[particleCount+1]- Math.pow(x[particleCount], 2)),2));
            //   System.out.println("------"+ Math.pow(x[particleCount]-1, 2));
            fitnessResult += 100 * Math.pow((x[i + 1] - Math.pow(x[i], 2)), 2) + Math.pow((x[i] - 1), 2);
          //  fitnessResult +=  Math.pow(x[i], 2);
        }

        return fitnessResult;
    }
}
