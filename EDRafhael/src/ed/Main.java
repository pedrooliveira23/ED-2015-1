package ed;

public class Main {

	public static void main(String[] args) {
		Arvore arvore = new Arvore(3);
		
		arvore.inserir(2);
		arvore.inserir(4);
		arvore.inserir(6);
		
		
		System.out.println("Profundidade: " + arvore.getAltura());
		System.out.println("Maior: " + arvore.maior(arvore.getRoot()));
		System.out.println("Menor: " + arvore.menor(arvore.getRoot()));
		System.out.println("Estritamente Binaria: " + arvore.isEstritamenteBinaria());
		System.out.println("Completa: " + arvore.isCompleta());

	}

}
