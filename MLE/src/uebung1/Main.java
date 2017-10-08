package uebung1;

import uebung1.Matrix;
import uebung1.HillClimber;

public class Main {
	static int amount = 100;
	static int[][] cities = new int[amount][amount];
	static int[] route = new int[amount];
	
	static void hillClimber(int[][] matrix, int[]startRoute){
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
	}
	
	public static void randomSwap(int[] route) {
		int random1 = (int)((Math.random()) * 100);
		int random2 = (int)((Math.random()) * 100);
		
		if(random1 != random2) {
			int temp = route[random1];
			route[random1] = route[random2];
			route[random2] = temp;
		}
	}

	public static void main(String[] args) {
		//Matrix mit Werten füllen
		Matrix.initMatrix(cities);
		Matrix.initRoute(route);

		//zum testen ob Matrix richtig erzeugt wurde
		for(int i=0; i < cities.length; i++) {
			for(int k=0; k < cities[i].length; k++) {
				System.out.println(i + "," + k +" = "+  cities[i][k]);
			}
		}
		System.out.println("Startdistanz: " + (Matrix.getDistance(cities, route)));
		
		hillClimber(cities, route);
	}
}
