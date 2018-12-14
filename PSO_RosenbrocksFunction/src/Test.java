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
        PSO particalSwarmOptimisation = new PSO(20, p, 100);
        particalSwarmOptimisation.run();
    }
}
