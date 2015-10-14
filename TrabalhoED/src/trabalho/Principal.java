package trabalho;

public class Principal {

	public static void main(String[] args) {
		ArvoreBinaria arvore = new ArvoreBinaria();
		
		arvore.inserirElemento(2);
		arvore.inserirElemento(1);
		arvore.inserirElemento(3);
		
		
		System.out.println("Altura: " + arvore.getAltura());
		System.out.println("Maior elemento: " + arvore.maiorElemento());
		System.out.println("Menor elemento: " + arvore.menorElemento());
		System.out.println("É estritamente binaria: " + arvore.isEstritamenteBinaria());
		System.out.println("É completa: " + arvore.isCompleta());

	}

}
