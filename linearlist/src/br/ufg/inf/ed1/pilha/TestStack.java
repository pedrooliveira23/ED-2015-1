package br.ufg.inf.ed1.pilha;

/**
 * Essa classe testa os m�todos da classe Stack.
 * 
 * Para executar, copie o arquivo em quest�o no mesmo diretorio da classe Stack
 * e execute os comandos abaixo:<br>
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
 * 2) java -classpath . TestStack<br>
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
public class TestStack {
	public static void main(String[] args) {
		Stack x = new LinkedStack();
		
		System.out.println("Tamanho inicial " + x.size());
		if (x.isEmpty())
			System.out.println("Pilha vazia");
		else
			System.out.println("Pilha n�o vazia");

		x.push(new Integer(2));
		x.push(new Integer(6));
		x.push(new Integer(1));
		x.push(new Integer(4));

		try {
			x.push(new Integer(500));
		} catch (StackFullException e) {
			System.out.println("Exce��o gerada corretamente...");
		}

		System.out.println("Tamanho da pilha " + x.size());
		System.out.println("A pilha � " + x);
		Comparable index = x.top();
		System.out.println("O elemento do topo �: " + index);

		System.out.println("Elemento desempilhado: " + x.pop());
		System.out.println("Elemento desempilhado: " + x.pop());
		System.out.println("Elemento desempilhado: " + x.pop());
		System.out.println("Elemento desempilhado: " + x.pop());

		System.out.println("A pilha � " + x);
		if (x.isEmpty())
			System.out.println("Pilha vazia");
		else
			System.out.println("Pilha n�o vazia");
		System.out.println("Tamanho da pilha " + x.size());

		try {
			x.pop();
		} catch (StackEmptyException e) {
			System.out.println("Exce��o gerada corretamente...");
		}
	}
}