package uebung1;

import uebung1.Matrix;

public class HillClimber {

	static int[] hillClimber(int[][] matrix, int[]startRoute){
		int Fitness = Matrix.getDistance(matrix, startRoute);
		int lastFitness;
		int[]lastRoute = startRoute;
		int count = 1000000;

		while(count >= 0) {
			randomSwap(startRoute);
			if( Matrix.getDistance(matrix, startRoute) < Fitness) {
				lastFitness = Matrix.getDistance(matrix, lastRoute);
				Fitness = lastFitness;
				System.out.println("Aktuelle Fintess: " + lastFitness);
				startRoute = lastRoute;
				count--;
			}
			else 
				lastRoute = startRoute;
			count--;
		}
		return lastRoute;
	}
	//tasucht zwei zufällige städte in der Route
	public static void randomSwap(int[] route) {
		int random1 = (int)((Math.random()) * 100);
		int random2 = (int)((Math.random()) * 100);

		if(random1 != random2) {
			int temp = route[random1];
			route[random1] = route[random2];
			route[random2] = temp;
		}
	}
}
