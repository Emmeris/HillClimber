package uebung1;

import uebung1.Matrix;
import uebung1.HillClimber;

public class Main {
	static int amount = 100;
	static int[][] cities = new int[amount][amount];
	static int[] route = new int[amount];
	
	

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
		
		HillClimber.hillClimber(cities, route);
		
		System.out.println("Beste Route: ");
		for(int i=0; i < route.length; i++) {
			System.out.println(route[i]);
	
		}
	}
}
