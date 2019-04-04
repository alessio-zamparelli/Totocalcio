package it.polito.tdp.toto;

public class Espandi {
	
	public void espandiPronostico(Pronostico p) {
		Schedina parziale = new Schedina(p.getN());
		espandi(p, parziale, 0);
	}

	// Livello della ricorsione è uguale alla singola partita
	// Livello = 0 -> schedina con 0 risultati
	// Livello = 1 -> schedina con 1 risultato

	private void espandi(Pronostico p, Schedina parziale, int livello) {

		// parziale contiene gia (livello-1) valori
		// nelle posizioni 0...livello-1
		// io devo determinare parziale[livello] (cioè la livello+1 esima riga)
		// sulla base della previsione in p[livello]

		if (livello == p.getN()) {
			System.out.println(parziale);
			return;
		}

		Previsione prev = p.get(livello);

		// prova le varie alternative
		for (Risultato r : prev.getValori()) {
			// provo ad aggiungere 'r'
			parziale.add(r);

			espandi(p, parziale, livello + 1);

			// backtrack
			parziale.removeLast();
		}

	}

}
