package uebung3;

public class BiteSequenz {
	// Anzahl Individuen
	static int[] p = new int[9];
	// Anteil der durch Crossover ersetzt wird
	static int r = p.length/2;
	// Mutationsrate
	static int m;
	
	// Erzeugt Zufalls-Hypothese
	public static void init(int[] p) {
		for(int i = 0; i < p.length; i++) {
			p[i] = (int) Math.round (Math.random());
		}
	}
	
	public static void main(String[] args) {
		// initialisiert die Population
		init(p);
		
	}
}
