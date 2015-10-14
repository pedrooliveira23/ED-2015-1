package br.ufg.inf.ed1.pilha;

import br.ufg.inf.ed1.lista.*;

/**
 * Implementa��o da interface {@link Stack} utilizando um a classe
 * LinkedLinearList.
 * 
 * @author Auri Vincenzi (Adaptado de Natasha Gelfand & Roberto Tamassia)
 */
public class LinkedStack2 implements Stack {
	/**
	 * Objeto que ir� armazenar a pilha.
	 */
	private LinearList lista;

	/**
	 * Inicializa a pilha.
	 */
	public LinkedStack2() {
		lista = new LinkedLinearList();
	}

	/**
	 * @return o n�mero de elementos na pilha.
	 */
	public int size() {
		return lista.size();
	}

	/**
	 * @return true se a pilha est� vazia, false caso contr�rio.
	 */
	public boolean isEmpty() {
		return lista.isEmpty();
	}

	/**
	 * Insere um elemento no topo da pilha.
	 * 
	 * @param obj
	 *            o elemento a ser empilhado.
	 */
	public void push(Comparable obj) {
		lista.add(0, obj);
	}

	/**
	 * Consulta o topo da pilha.
	 * 
	 * @return o elemento no topo da pilha.
	 */
	public Comparable top() {
		return lista.get(0);
	}

	/**
	 * Remove o elemento do topo da pilha.
	 * 
	 * @return o elemento removido.
	 * @exception StackEmptyException
	 *                se a pilha est� vazia.
	 */
	public Comparable pop() {
		if (isEmpty())
			throw new StackEmptyException("Pilha vazia.");

		return lista.remove(0);
	}

	/**
	 * Converte a pilha em um String. Os elementos s�o desempilhados e
	 * empilhados novamente. Portanto a ordem de impress�o � do topo para a
	 * cauda.
	 * 
	 * @return uma String representando a pilha.
	 */
	public String toString() {
		StringBuffer s = new StringBuffer("[");

		Stack aux = new LinkedStack2();
		while (!isEmpty()) {
			Comparable elem = pop();
			aux.push(elem);
			if (elem == null)
				s.append("null, ");
			else
				s.append(elem.toString() + ", ");
		}
		if (!aux.isEmpty()) {
			s.delete(s.length() - 2, s.length());
			while (!aux.isEmpty()) {
				push(aux.pop());
			}
		}
		s.append("]");
		// criando a String equivalente
		return new String(s);
	}
}
