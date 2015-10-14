package capitulo3.ex2;

public class TestLinkedLinearList {
	public static void main(String[] args) {
		LinearList x = new OrderedList();
		x.criaListas(2);
		System.out.println("Tamanho inicial Lista0 " + x.size(0));
		System.out.println("Tamanho inicial Lista1 " + x.size(0));
		if (x.isEmpty(0))
			System.out.println("Lista0 vazia");
		else
			System.out.println("Lista0 nao vazia");
		
		if (x.isEmpty(1))
			System.out.println("Lista1 vazia");
		else
			System.out.println("Lista1 nao vazia");

		x.add(new Integer(2), 0);
		x.add(new Integer(6), 1);
		x.add(new Integer(1), 0);
		x.add(new Integer(4), 1);
		
		try {
			x.add(new Integer(500), 0);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Excecao gerada corretamente...");
			e.printStackTrace();
		}

		System.out.println("Tamanho da lista0 " + x.size(0));
		System.out.println("Tamanho da lista1 " + x.size(1));
		System.out.println("A lista0 e " + x.toString(0));
		System.out.println("A lista1 e " + x.toString(1));
		int index = x.indexOf(new Integer(4), 1);
		if (index < 0)
			System.out.println("4 nao encontrado");
		else
			System.out.println("O indice de 4 na lista1 e " + index);
		index = x.indexOf(new Integer(3), 0);
		if (index < 0)
			System.out.println("3 nao encontrado");
		else
			System.out.println("O indice de 3 na lista0 e " + index);
		System.out.println("Elemento em 0 da lista0 e " + x.get(0, 0));
		System.out.println("Elemento em 1 da lista1 e" + x.get(1,1));
		System.out.println(x.remove(1,0) + " removido");
		System.out.println("A lista0 e " + x.toString(0));
		System.out.println(x.remove(1,1) + " removido");
		System.out.println("A lista1 e " + x.toString(1));
		if (x.isEmpty(0))
			System.out.println("Lista0 vazia");
		else
			System.out.println("Lista0 nao vazia");
		
		if (x.isEmpty(1))
			System.out.println("Lista1 vazia");
		else
			System.out.println("Lista1 nao vazia");
		System.out.println("Tamanho da lista0 " + x.size(0));
		System.out.println("Tamanho da lista1 " + x.size(1));
	}
}