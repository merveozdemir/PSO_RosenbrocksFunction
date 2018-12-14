/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Merve
 */
public class FitnessEvoulator {

    double fitnessResult;
    Particle x;

    public FitnessEvoulator(Particle x) {
        this.x = x;
    }

    double evulateFitness() { // calculate 
        fitnessResult = PSO.problem.getResult(x);
        return fitnessResult;
    }

}
