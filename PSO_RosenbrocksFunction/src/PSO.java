
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Merve
 */
public class PSO {

    private final int PARTICLE_SIZE;
    public Particle[] particles;
    Particle[] personalBestParticles;
    Particle gBest;
    private int maxIteration = 0;
    private double fitness = 0;
    static public Problem problem;
    double result = 0;
    

    public PSO(int Partical_size, Problem p, int iteration) {
        PARTICLE_SIZE = Partical_size;
        problem = p;
        this.maxIteration = iteration;

    }

    public void run() {
        Swarm swarm = new Swarm(PARTICLE_SIZE);
        particles = swarm.initializeSwarm(problem.dimension);

        swarm.updateGlobalBestParticle();

        int iteration = 0;

        while (iteration < maxIteration) {

            Particle.particleCount = 1;
            for (int i = 0; i < swarm.particles.length; i++) {

                swarm.particles[i].updateVelocity(swarm.gBestParticle, swarm.particles[i].pBestParticle);
                swarm.particles[i].updatePosition();

                FitnessEvoulator fitnessEvu = new FitnessEvoulator(swarm.particles[i]);
                fitness = fitnessEvu.evulateFitness();

                swarm.particles[i].setFitness(fitness);
                swarm.particles[i].updateBestParticle();

                //   System.out.println("");
                Particle.particleCount++;
            }

            swarm.updateGlobalBestParticle();
            iteration++;
            System.out.println(iteration + ". iteration     -     Globasl Best Value: " + swarm.gBestParticle.fitness);

        }
        this.gBest = swarm.gBestParticle;
        this.result = swarm.gBestParticle.fitness;
    }

}
