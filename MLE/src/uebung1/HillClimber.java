package uebung1;

import uebung1.Matrix;

public class HillClimber {

	static int[] hillClimber(int[][] matrix, int[]startRoute){
		int[] hypo = startRoute;
		int[] hypoCopy;
		int lastFitness = Matrix.getDistance(matrix, hypo)*(-1);
		int loop = 0;
		double temp = 100000;
		double epsilon = 0.2;


		while(temp > epsilon) {
			hypoCopy = hypo;
			randomSwap(hypo);
			
			if( Matrix.getDistance(matrix, hypo)*(-1) > lastFitness) {
				lastFitness = Matrix.getDistance(matrix, hypo)*(-1);
				System.out.println("Loop: " + loop + " " + "Aktuelle Fintess: " + lastFitness);
				loop++;
			}
			
			else if(Math.random() < (Matrix.getDistance(matrix, hypo)*(-1) - lastFitness) / temp ) {
				lastFitness = Matrix.getDistance(matrix, hypo)*(-1);
				System.out.println("Temperatur: " + temp);
				System.out.println("Loop: " + loop + " " + "Aktuelle Fintess: " + lastFitness);
				loop++;
				
			}
			
			else {
				hypo = hypoCopy;
				loop++;
			}
			temp = temp-epsilon;
		}
		return hypo;
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