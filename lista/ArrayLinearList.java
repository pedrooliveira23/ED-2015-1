package br.ufg.inf.ed1.lista;

/**
 * Esta classe implementa a interface {@link LinearList} utilizando vetores para
 * armazenar os elementos da lista.
 * 
 * @author Auri Vincenzi
 * @version 08-2005
 */
public class ArrayLinearList implements LinearList {
	// Vetor para armazenar o conjunto de elementos da lista
	private Comparable[] element;

	// Contador do número de elementos ocupados
	private int size;

	/**
	 * Cria uma lista com capacidade para armazenar 50 elementos.
	 */
	public ArrayLinearList() {
		size = 0;
		element = new Comparable[50];
	}

	/**
	 * Verifica se a lista está vazia.
	 * 
	 * @return true se e somente se a lista estiver vazia, false caso contrário.
	 */
	public boolean isEmpty() {
		return (size == 0);
	}

	/**
	 * Tamanho da lista.
	 * 
	 * @return o número corrente de elementos na lista.
	 */
	public int size() {
		return size;
	}

	/**
	 * Busca elemento em determinada posição da lista.
	 * 
	 * @return o elemento localizado da posição index.
	 * 
	 * @throws IndexOutOfBoundsException
	 *             quando o índice fornecido não estiver entre 0 e size - 1.
	 */
	public Comparable get(int index) {
		checkIndex(index);
		return element[index];
	}

	/**
	 * Busca o índice de determinado elemento.
	 * 
	 * @return o índice da primeira ocorrência do elemento na lista. Retorna -1
	 *         se o elemento não for encontrado.
	 */
	public int indexOf(Comparable theElement) {
		// procura pelo elemento
		for (int i = 0; i < size; i++)
			if (element[i].compareTo(theElement) == 0)
				return i; // elemento encontrado
		return -1;
	}

	/**
	 * Remove o elemento localizado no index especificado. Todos os elementos
	 * com índice superior ao índice fornecido terão seus valores decrementado
	 * em uma unidade.
	 * 
	 * @throws IndexOutOfBoundsException
	 *             quando index não estiver entre 0 e size - 1.
	 * @return o elemento removido.
	 */
	public Comparable remove(int index) {
		checkIndex(index); // índice válido

		Comparable removedElement = element[index];
		// deslocar elementos com índice superior
		for (int i = index + 1; i < size; i++)
			element[i - 1] = element[i];
		element[--size] = null;
		return removedElement;
	}

	/**
	 * Adiciona um novo elemento a lista em uma dada posição.
	 * 
	 * Todos elementos com índice igual ou superior ao índice fornecido terão
	 * seus índices incrementados em uma unidade
	 * 
	 * @throws LinearListOverflowException
	 *             quando a lista estiver cheia.
	 * 
	 * @throws IndexOutOfBoundsException
	 *             quando index não estiver entre 0 e size.
	 */
	public void add(int index, Comparable theElement)
			throws LinearListOverflowException {
		if (size == element.length) // sem espaço
			throw new LinearListOverflowException("Lista cheia");

		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException("Índice = " + index
					+ "  tamanho = " + size);
		// shift elements right one position
		for (int i = size - 1; i >= index; i--)
			element[i + 1] = element[i];
		element[index] = theElement;
		size++;
	}

	/**
	 * Converte a lista em um String.
	 * 
	 * @return uma String representando a lista.
	 */
	public String toString() {
		StringBuffer s = new StringBuffer("[");
		// inserindo os elementos no buffer
		for (int i = 0; i < size; i++)
			if (element[i] == null)
				s.append("null, ");
			else
				s.append(element[i].toString() + ", ");
		if (size > 0)
			s.delete(s.length() - 2, s.length());
		s.append("]");
		// criando a String equivalente
		return new String(s);
	}

	/**
	 * Verifica a validade de determinado índice. Um índice válido esta entre 0
	 * e size - 1, inclusive.
	 * 
	 * @throws IndexOutOfBoundsException
	 *             quando index não estiver entre 0 e size - 1.
	 */
	private void checkIndex(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("Índice = " + index
					+ "  tamanho = " + size);
	}
}
