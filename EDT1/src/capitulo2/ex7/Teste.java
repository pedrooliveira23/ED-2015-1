package capitulo2.ex7;

public class Teste {

	public static void main(String[] args) {
		CadastroDeLivros cadastro = new CadastroDeLivros();
		
		cadastro.incluirLivro(1, "Eu", "Teste", 2015, 15);
		cadastro.incluirLivro(2, "Dom Quixote", "Teste", 1700, 50);
		cadastro.incluirLivro(2, "O Corvo", "Teste", 1800, 80);
		cadastro.incluirLivro(3, "O Corvo", "Teste", 1800, 80);
		
		System.out.print("\n" + cadastro.listarLivros("Teste"));
		
		cadastro.removerLivro(2);
		
		System.out.print("\n" + cadastro.listarLivros("Teste"));
		
	}

}
