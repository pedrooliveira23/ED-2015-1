package pilha;

/**
 * Interface do TAD Pilha: uma cole��o de objetos que s�o sempre inseridos e
 * removidos mantendo o princ�pio last-in first-out.
 * 
 * @author Auri Vincenzi. Adaptado de (Roberto Tamassia & Michael Goodrich)
 * @see StackEmptyException
 */
public interface Stack {
	/**
	 * @return o n�mero de elementos na pilha.
	 */
	public int size();

	/**
	 * @return true se a pilha est� vazia, false caso contr�rio.
	 */
	public boolean isEmpty();

	/**
	 * Consulta o topo da pila.
	 * 
	 * @return o elemento no topo da pilha.
	 * @exception StackEmptyException
	 *                se a pilha est� vazia.
	 */
	public Comparable top();

	/**
	 * Insere um elemento no topo da pilha.
	 * 
	 * @param element
	 *            o elemento a ser inserido.
	 */
	public void push(Comparable element);

	/**
	 * Remove o elemento do topo da pilha.
	 * 
	 * @return o elemento removido.
	 * @exception StackEmptyException
	 *                se a pilha est� vazia.
	 */
	public Comparable pop();

	public String toString();
}
