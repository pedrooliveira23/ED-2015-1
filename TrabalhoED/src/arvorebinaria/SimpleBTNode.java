package arvorebinaria;

/** 
 * Esta classe representa um n� de uma �rvore bin�ria. O n� de uma �rvore bin�ria �
 * respons�vel por armazenar um elemento, uma refer�ncia para um n� a sua esquerda e
 * uma refer�ncia para outro n� localizado a sua direita.
 * 
 *  @author Auri Vincenzi
 */
public class SimpleBTNode implements Comparable {
	private Comparable element; // O elemento sendo armazenado no n�

	private SimpleBTNode left;  // O filho da esquerda
	private SimpleBTNode right; // O filho da direita

	/**
	 * O construtor padr�o cria um n� com todos os elementos iguais a null. 
	 */
	public SimpleBTNode() {
		this(null, null, null);
	}

	/**
	 * Construtor que cria um n� de acordo com os par�metros especificados. 
	 * @param l - refer�ncia para o filho da esquerda.
	 * @param e - refer�ncia para o elemento sendo inserido.
	 * @param r - refer�ncia para o filho da direita.
	 */
	public SimpleBTNode(SimpleBTNode l, Comparable e, SimpleBTNode r) {
		element = e;
		left = l;
		right = r;
	}

	/**
	 * Permite o acesso ao elemento desse n�.
	 * @return a refer�ncia para o elemento armazenado no n�.
	 */
	public Comparable getElement() {
		return element;
	}

	/**
	 * Permite alterar a refer�ncia do elemento armazenado no n�.
	 * @param e - refer�ncia para o novo elemento.
	 */
	public void setElement(Comparable e) {
		element = e;
	}

	/**
	 * Permite o acesso ao filho esquerdo do n�.
	 * @return a refer�ncia para o filho esquerdo.
	 */
	public SimpleBTNode getLeft() {
		return left;
	}
	
	/**
	 * Permite alterar a refer�ncia do filho esquerdo do n�.
	 * @param v - refer�ncia para o novo n� a se tornar filho esquerdo do n� atual.
	 */
	public void setLeft(SimpleBTNode v) {
		left = v;
	}

	/**
	 * Permite o acesso ao filho direito do n�.
	 * @return a refer�ncia para o filho direito.
	 */
	public SimpleBTNode getRight() {
		return right;
	}

	/**
	 * Permite alterar a refer�ncia do filho direito do n�.
	 * @param v - refer�ncia para o novo n� a se tornar filho direito do n� atual.
	 */
	public void setRight(SimpleBTNode v) {
		right = v;
	}

	/**
	 * Converte o n� atual em um String. Delega essa atividade para o m�todo toString do
	 * elemento atualmente armazenado no n�.
	 * @return um String correspondente ao elemento atualmente armazenado no n�.
	 */
	public String toString() {
		return element.toString();
	}

	public int compareTo(Object obj) {
		if (obj instanceof SimpleBTNode) {
			SimpleBTNode no = (SimpleBTNode) obj;
			if (getElement() != null) {
				return getElement().compareTo(no.getElement());
			} else {
				if (no.getElement() == null) 
					return 0;
				return 1;
			}
		}
		return 1;
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof SimpleBTNode) {
			SimpleBTNode no = (SimpleBTNode) obj;
			if (getElement() != null)
				return getElement().compareTo(no.getElement()) == 0;
		}
		return false;		
	}
}
