package uebung1u2;

import uebung1u2.Matrix;

public class HillClimberSimA {

	static int[] hillClimber(int[][] matrix, int[]startRoute){
		int[] hypo = startRoute;
		int[] hypoCopy;

		double temp = 100;
		double epsilon = 0.0001;
		int lastFitness;
		int fitness;


		while(temp > epsilon) {

			//speichert hypo
			//save hypo into saveState;
			hypoCopy = hypo.clone();
			//vertauscht 2 städte
			randomSwap(hypo);
			lastFitness =  Matrix.getDistance(matrix, hypoCopy)*(-1);
			fitness = Matrix.getDistance(matrix, hypo)*(-1);

			if( fitness > lastFitness) {
				lastFitness = fitness;
				System.out.println("Temperatur: " + temp);
				System.out.println("Aktuelle Fintess: " + lastFitness + "\n\n");
			}
			else 
			{	
				if(temp < 0.05) {
					System.out.println("Wahrscheinlichkeit vor Prüfung: " +  Math.exp((fitness - lastFitness) / temp));

				}
				if(Math.random() < Math.exp((fitness - lastFitness) / temp)) {
					System.out.println("Wahrscheinlichkeit: " +  Math.exp((fitness - lastFitness) / temp));

					lastFitness = fitness;
					System.out.println("Temperatur: " + temp);
					System.out.println("Aktuelle Fintess: " + lastFitness + "\n\n");
				}

				else {
					hypo = hypoCopy.clone();
				}
				temp = temp-epsilon;
			}
		}
		System.out.println("Temperatur: " + temp);
		return hypo;
	}
	//tasucht zwei zufällige städte in der Route
	public static void randomSwap(int[] route) {
		int random1 = (int)((Math.random()) * route.length);
		int random2;
		do {
			random2 = (int)((Math.random()) * route.length);
		} while (random1==random2);
		
			int temp = route[random1];
			route[random1] = route[random2];
			route[random2] = temp;
		
		
	}
}