package uebung1;

import uebung1.Matrix;

public class HillClimber {

	static int[] hillClimber(int[][] matrix, int[]startRoute){
		int fitness = Matrix.getDistance(matrix, startRoute)*(-1);
		int lastFitness;
		int[]lastRoute = startRoute;
		int count = 0;
		double wahrscheinlichkeit = Math.random();

		while(count <= 10000000) {
			randomSwap(startRoute);
			if( Matrix.getDistance(matrix, startRoute)*(-1) > fitness) {
				lastFitness = Matrix.getDistance(matrix, lastRoute)*(-1);
				fitness = lastFitness;
				System.out.println("Loop: " + count + " " + "Aktuelle Fintess: " + lastFitness);
				startRoute = lastRoute;
				count++;
			}
			else 
				//Hier Simulated Annealing ob die Wahrscheinlichkeit für rückschritt gegeben ist
				//Distanz und Fitness ist nicht dasselbe!
				lastRoute = startRoute;
			count++;
		}
		return lastRoute;
	}
	//tasucht zwei zufällige städte in der Route
	public static void randomSwap(int[] route) {
		int random1 = (int)((Math.random()) * route.length);
		int random2 = (int)((Math.random()) * route.length);

		if(random1 != random2) {
			int temp = route[random1];
			route[random1] = route[random2];
			route[random2] = temp;
		}
	}
}
