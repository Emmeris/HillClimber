package uebung1;

public class Matrix {

	
	static void initMatrix(int[][] matrix) {
		for(int i=0; i < matrix.length; i++) {
			for(int k=0; k < matrix.length; k++) {
				//sorgt dafür, dass diagonale achse 0 ist
				if(i==k) {
					matrix[i][k] = 0; 
				}
				//füllt die Matrix mit random werten
				else matrix[i][k] = (int) Math.round (Math.random() * 100 +1);
				//sorgt dafür, dass z.B. in 3,1 das selbe steht wie in 1,3
				matrix[k][i] = matrix[i][k];
			}
		}
	}

	static void initRoute(int[] route) {
		//füllt das routen array
		for(int i=0; i < route.length; i++) {
			route[i] = i;
		}
	}

	static int getDistance(int[][] matrix, int[] route) {
		int distance = 0;
		//füllt das routen array
		for(int i=0; i < route.length-1; i++) {
			//nimmt 2er paare aus route und schaut in matrix welcher Distanz dort steht
			//und addiert die Entfernungen auf
			distance += matrix[route[i]][route[i+1]];
		}
		//addiert die Distanz vom Ende zum Startpunkt zur gesamtlänge dazu
		distance = distance + matrix[route[0]][route.length-1];
		return distance;
	}
}
