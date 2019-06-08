
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Merve
 */
public class Particle {

    private double maxValue = 0;
    private double minValue = 0;
    private final double maxV = 20;
    private final double minV = -20;
    double velocity[];
    double position[];
    int dimension;
    double fitness;
    static int particleCount = 1;
    Particle pBestParticle;

    public Particle(double min, double max, int dimension) {
        minValue = min;
        maxValue = max;
        this.dimension = dimension;

        position = new double[dimension];
        velocity = new double[dimension];
   
        pBestParticle = new Particle(fitness, dimension);
        for (int i = 0; i < dimension; i++) {
            Random rand = new Random();
            position[i] = minValue + rand.nextDouble() * (maxValue - minValue);
            velocity[i] = minV + Math.random() * (maxV - minV);
        }

      System.arraycopy(this.position, 0, pBestParticle.position, 0, dimension);
      System.arraycopy(this.velocity, 0, pBestParticle.velocity, 0, dimension);
      
        FitnessEvoulator fitnessEvu = new FitnessEvoulator(this);
        fitness = fitnessEvu.evulateFitness();
        pBestParticle.fitness = this.fitness;
        particleCount++;
    }

    public Particle(double fitness, int dimension) {
        this.dimension = dimension;
        this.fitness = fitness;
        position = new double[dimension];
        velocity = new double[dimension];
    }

    void updateVelocity(Particle gBest, Particle pBest) {
        
        double w = 0.8;
        double c1 = 2.0, c2 = 2.0;

        for (int i = 0; i < position.length; i++) {
            double rand1 = Math.random();
            double rand2 = Math.random();
            velocity[i] = w * velocity[i] + c1 * rand1 * (pBest.position[i] - position[i]) + c2 * rand2 * (gBest.position[i] - position[i]);

            if (velocity[i] > maxV) {
                velocity[i] = maxV;
            }
            if (velocity[i] < minV) {
                velocity[i] = minV;
            }
        }

    }

    void updatePosition() {

        for (int i = 0; i < position.length; i++) {
            position[i] += velocity[i];
       

            if (position[i] > maxValue || position[i] < minValue) {
                while (position[i] > maxValue || position[i] < minValue) {
                    if (position[i] > maxValue) {
                        position[i] = maxValue - (this.position[i] - maxValue);
                    } else if (position[i] < minValue) {
                        position[i] = minValue + (minValue - this.position[i]);
                    }
                }
           
            }
        }

    }
    
    void updateBestParticle(){
        
        if (this.getFitness() < pBestParticle.getFitness()) {
            pBestParticle.fitness = this.fitness;
            System.arraycopy(this.position, 0, pBestParticle.position, 0, dimension);
            System.arraycopy(this.velocity, 0, pBestParticle.velocity, 0, dimension);
          }
      
    }

    void setFitness(double f) {
        fitness = f;
    }

    double getFitness() {
        return fitness;
    }

}
