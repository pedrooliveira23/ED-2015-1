package capitulo2.ex8;

public class Teste {

	public static void main(String[] args) {
		Campeonato campeonato = new Campeonato();
		
		campeonato.incluirtime("Goias", 25, 10, 3, 9);
		campeonato.incluirtime("Vila Nova", 0, 2, 15, 1);
		campeonato.incluirtime("Atletico Goiano", 10, 5, 5, 3);
		campeonato.incluirtime("Anapolina", 2, 4, 3, 2);
		
		campeonato.removerTime("Anapolina");
		
		campeonato.iniciarCampeonato();
		
		campeonato.removerTime("Atletico Goiano");
		
		System.out.println(campeonato.listarPontos());
		System.out.println(campeonato.listarVitorias());
		System.out.println(campeonato.listarGolsMarcados());
		System.out.println(campeonato.listarGolsSofridos());
		

	}

}
