package br.ufg.inf.ed1.lista;

/**
 * Essa classe testa os m�todos da classe ArrayLinearList.
 * 
 * Para executar, copie o arquivo em quest�o no mesmo diretorio da classe
 * ArrayLinearList e execute os comandos abaixo:<br>
 * 
 * <p>
 * 
 * <code>
 * 1) javac -classpath . -d . *.java<br>
 * </code>
 * 
 * <p>
 * 
 * <code>
 * 2) java -classpath . TestArrayLinearList<br>
 * </code>
 * 
 * <p>
 * 
 * Como resultado da execu��o do programa deve ser impresso na tela a seguinte
 * seq��ncia de linhas:<br>
 * <p>
 * <code>
 * Tamanho inicial 0<br>
 * Lista vazia<br>
 * Tamanho da lista 4<br>
 * Exce��o gerada corretamente...<br>
 * java.lang.IndexOutOfBoundsException: index = 5  tamanho = 4<br>
 * --&lt; at ArrayLinearList.add(ArrayLinearList.java:106)<br>
 * --&lt; at TestArrayLinearList.main(TestArrayLinearList.java:58)<br>
 * A lista � [1, 2, 4, 6]<br>
 * O �ndice de 4 � 2<br>
 * 3 n�o encontrado<br>
 * Elemento em 0 � 1<br>
 * Elemento em 3 � 6<br>
 * 2 removido<br>
 * A lista � [1, 4, 6]<br>
 * 6 removido<br>
 * A lista � [1, 4]<br>
 * Lista n�o vazia<br>
 * Tamanho da lista 2<br>
 * </code>
 * 
 * @author Auri Vincenzi
 */
public class TestArrayLinearList {
	public static void main(String[] args) {
		LinearList x = new ArrayLinearList();
		System.out.println("Tamanho inicial " + x.size());
		if (x.isEmpty())
			System.out.println("Lista vazia");
		else
			System.out.println("Lista n�o vazia");

		x.add(0, new Integer(2));
		x.add(1, new Integer(6));
		x.add(0, new Integer(1));
		x.add(2, new Integer(4));

		try {
			x.add(5, new Integer(500));
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Exce��o gerada corretamente...");
			e.printStackTrace();
		}

		System.out.println("Tamanho da lista " + x.size());
		System.out.println("A lista � " + x);
		int index = x.indexOf(new Integer(4));
		if (index < 0)
			System.out.println("4 n�o encontrado");
		else
			System.out.println("O �ndice de 4 � " + index);
		index = x.indexOf(new Integer(3));
		if (index < 0)
			System.out.println("3 n�o encontrado");
		else
			System.out.println("O �ndice de 3 � " + index);
		System.out.println("Elemento em 0 � " + x.get(0));
		System.out.println("Elemento em 3 � " + x.get(3));
		System.out.println(x.remove(1) + " removido");
		System.out.println("A lista � " + x);
		System.out.println(x.remove(2) + " removido");
		System.out.println("A lista � " + x);
		if (x.isEmpty())
			System.out.println("Lista vazia");
		else
			System.out.println("Lista n�o vazia");
		System.out.println("Tamanho da lista " + x.size());
	}
}