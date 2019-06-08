/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates 
 * and open the template in the editor.  
 */

/**
 *
 * @author Merve
 */
public class Test {

    public static void main(String[] args) {
        Problem p = new Problem(10);

        PSO particalSwarmOptimisation = new PSO(10, p, 500);
        particalSwarmOptimisation.run();
        
        System.out.println("Minimum fitness value: "+ particalSwarmOptimisation.result+ "\nAnd coordinate of the minimum fitness value in 10-dimensional space:");
        for (double d : particalSwarmOptimisation.gBest.position) {
             System.out.print(d+"  ");
        }
       
    }

}
