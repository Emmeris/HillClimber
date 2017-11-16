package uebung3;

public class ByteSequenz {
	// Anzahl Individuen(Hypothesen) in Population
	static int p = 9;
	// Population
	static int[] population = new int[p];
	// Anteil der durch Crossover ersetzt wird
	static int r = population.length/2;
	// Mutationsrate
	static int m;
	
	// Erzeugt Zufalls-Hypothese
	public static void init(int[] p) {
		for(int i = 0; i < p.length; i++) {
			p[i] = (int) Math.round (Math.random());
		}
	}
	
	public static int getFitness(int[] p) {
		int fitness = 0;
		return fitness;
	}
	
	public static void main(String[] args) {
		// initialisiert die Population
		init(population);
		
	}
}
