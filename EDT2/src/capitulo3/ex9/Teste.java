package capitulo3.ex9;

public class Teste {

	public static void main(String[] args) {
		Estante estante = new Estante(5);
		Comparable livro1 = "O enterro dos que não morreram";
		Comparable livro2 = "Poeira em alto mar";
		
		estante.colocar(0, livro1);
		estante.colocar(0, livro2);
		
		System.out.println("Livro removido: " + estante.retirar(0, 0));

	}

}
