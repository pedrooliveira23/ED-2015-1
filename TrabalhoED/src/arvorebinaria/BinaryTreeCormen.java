package arvorebinaria;

public class BinaryTreeCormen {
	private BTNode root;

	private int size;

	public BinaryTreeCormen(Comparable o) {
		root = new BTNode(o, null, null, null);
		size = 1;
	}

	/**
	 * Busca recursiva.
	 * 
	 * @param no
	 *            n� a partir do qual a busca deve come�ar. Em geral a raiz da
	 *            �rvore.
	 * @param key
	 *            valor da chave sendo procurada.
	 * @return
	 */
	public SimpleBTNode search(SimpleBTNode no, Comparable key) {
		if (key == null)
			return null;

		if ((no == null) || (no.getElement().compareTo(key) == 0))
			return no;

		if (key.compareTo(no.getElement()) < 0)
			return search(no.getLeft(), key);
		else
			return search(no.getRight(), key);
	}

	/**
	 * Busca n�o recursiva ou Busca iterativa. Em geral, essa ver�o � mais
	 * eficiente.
	 * 
	 * @param no
	 *            n� a partir do qual a busca deve come�ar. Em geral a raiz da
	 *            �rvore.
	 * @param key
	 *            valor da chave sendo procurada.
	 * @return
	 */
	public SimpleBTNode iterativeSearch(SimpleBTNode no, Comparable key) {
		if (key == null)
			return null;

		while ((no != null) && (no.getElement().compareTo(key) != 0))
			if (key.compareTo(no.getElement()) < 0)
				no = no.getLeft();
			else
				no = no.getRight();
		return no;
	}

	/**
	 * Encontra o menor elemento a partir de dado n�.
	 * 
	 * @param noX
	 *            n� a partir do qual a busca deve come�ar. Em geral a raiz da
	 *            �rvore.
	 * @return o n� contendo o menor elemento da �rvore.
	 */
	public SimpleBTNode minimum(SimpleBTNode noX) {
		while (noX.getLeft() != null)
			noX = noX.getLeft();
		return noX;
	}

	/**
	 * Encontra o maior elemento a partir de dado n�.
	 * 
	 * @param noX
	 *            n� a partir do qual a busca deve come�ar. Em geral a raiz da
	 *            �rvore.
	 * @return o n� contendo o menor elemento da �rvore.
	 */
	public SimpleBTNode maximum(SimpleBTNode noX) {
		while (noX.getRight() != null)
			noX = noX.getRight();
		return noX;
	}

	/**
	 * Se todas os elementos na �rvore s�o distintos, o sucessor de um n� x � o
	 * n� com o menor elemento maior do x.
	 * 
	 * A busca � dividida em dois casos:
	 * 
	 * <UL>
	 * <LI>1) se a sub�rvore direita de x n�o � vazia, ent�o seu sucessor � o
	 * filho mais a esquerda da sub�rvore direita;</LI>
	 * <LI>2) se a sub�rvore direita � vazia e x tem um sucessor y, ent�o y � o
	 * menor ancestral de x cujo filho esquerdo tamb�m � ancestral de x</LI>
	 * </UL>
	 * 
	 * @param noX
	 *            n� cujo elemento deseja-se encontrar o sucessor.
	 * @return o sucessor do n� x caso ele exista ou null, caso x j� seja o
	 *         maior elemento na �rvore.
	 */
	public SimpleBTNode successor(SimpleBTNode noX) {
		SimpleBTNode noY = null;

		if (noX.getRight() != null) // caso 1
			return minimum(noX.getRight());

		noY = ((BTNode)noX).getParent();
		while ((noY != null) && (noX == noY.getRight())) {
			noX = noY;
			noY = ((BTNode)noY).getParent();
		}
		return noY;
	}

	/**
	 * Se todas os elementos na �rvore s�o distintos, o predecessor de um n� x �
	 * o n� com o maior elemento menor do x.
	 * 
	 * A busca � dividida em dois casos:
	 * 
	 * <UL>
	 * <LI>1) se a sub�rvore esquerda de x n�o � vazia, ent�o seu predecessor �
	 * o filho mais a direita da sub�rvore esquerda;</LI>
	 * <LI>2) se a sub�rvore esquerda � vazia e x tem um predecessor y, ent�o y
	 * � o maior ancestral de x cujo filho direito tamb�m � ancestral de x</LI>
	 * </UL>
	 * 
	 * @param noX
	 *            n� cujo elemento deseja-se encontrar o predecessor.
	 * @return o predecessor do n� x caso ele exista ou null, caso x j� seja o
	 *         menor elemento na �rvore.
	 */
	public SimpleBTNode predecessor(SimpleBTNode noX) {
		SimpleBTNode noY = null;

		if (noX.getLeft() != null) // caso 1
			return maximum(noX.getLeft());

		noY = ((BTNode)noX).getParent();
		while ((noY != null) && (noX == noY.getLeft())) {
			noX = noY;
			noY = ((BTNode)noY).getParent();
		}
		return noY;
	}

	/**
	 * Faz a inser��o de um novo elemento na �rvore.
	 * 
	 * @param o
	 *            elemento a ser inserido. Elementos repetidos e nulos s�o
	 *            ignorados e n�o s�o inseridos na �rvore.
	 */
	public void insert(Comparable o) {
		SimpleBTNode noY, noX;

		if (o == null)
			return;

		noY = null;
		noX = getRoot();

		while (noX != null) {
			noY = noX;

			if (o.compareTo(noX.getElement()) == 0)
				return; // se igual n�o insere

			if (o.compareTo(noX.getElement()) < 0)
				noX = noX.getLeft();
			else
				noX = noX.getRight();
		}

		SimpleBTNode novo = new BTNode(o, noY, null, null);

		if (noY == null)
			root = (BTNode)novo;
		else if (o.compareTo(noY.getElement()) < 0)
			noY.setLeft(novo);
		else
			noY.setRight(novo);
		size++;
	}

	/**
	 * Remove um elemento da �rvore
	 * 
	 * @param elem
	 *            elemento a ser removido
	 * @return o elemento removido ou null caso o mesmo n�o seja encontrado na
	 *         �rvore.
	 */
	public Comparable remove(Comparable key) {
		SimpleBTNode noY = null, // no a ser desligado
		noX = null; // filho de no a ser desligado
		Comparable removed = null;
		
		// Buscando no a ser removido
		SimpleBTNode noChave = search(getRoot(), key);

		if (noChave == null)
			return null; //nao existe elemento na arvore

		removed = noChave.getElement();
		
		// Procurando no a ser desligado da arvore (noY)
		if ((noChave.getLeft() == null) || (noChave.getRight() == null))
			noY = noChave; //caso noChave possua no maximo um filho
		else
			noY = successor(noChave); //caso noChave possua dois filhos

		// Verificando se o no a ser desligado (noY) possui filhos
		if (noY.getLeft() != null)
			noX = noY.getLeft();
		else
			noX = noY.getRight();

		// Desligando noY
		if (noX != null) //caso especial: no a ser desligado possui filho
			((BTNode)noX).setParent(((BTNode)noY).getParent());
		if (((BTNode)noY).getParent() == null) //caso especial: a ser desligado e a raiz
			root = (BTNode)noX;
		else if (noY == (((BTNode)noY).getParent()).getLeft()) // Se noY for filho esquerdo do pai
			(((BTNode)noY).getParent()).setLeft(noX);
		else // noY � filho direito de seu pai
			(((BTNode)noY).getParent()).setRight(noX);

		// Verificando se o sucessor de noChave foi o no desligado
		if (noY != noChave)
			noChave.setElement(noY.getElement());
		((BTNode)noY).setParent(null);
		noY.setLeft(null);
		noY.setRight(null);
		return removed;
	}

	public String toString() {
		StringBuffer buffer = new StringBuffer();
		addString(buffer, root);
		return buffer.toString();
	}

	private void addString(StringBuffer buffer, SimpleBTNode node) {
		if (node != null) {
			addString(buffer, node.getLeft());
			buffer.append(" " + node.getElement() + " ");
			addString(buffer, node.getRight());
		}
	}

	public SimpleBTNode getRoot() {
		return root;
	}

	/*public static void main(String[] args) {
		BinaryTreeCormen tree = new BinaryTreeCormen(new Integer(args[0]));

		for (int i = 1; i < args.length; i++) {
			tree.insert(new Integer(args[i]));
		}
		System.out.println();
		BinaryTreeUtil.printByLevel((BTNode)tree.getRoot());
		System.out.println();

		System.out.println("\nPercurso Pr�-Ordem");
		BinaryTreeUtil.preOrder(tree.getRoot());

/*		System.out.println();
		BinaryTreeUtil.printByLevel(tree.getRoot());
		
		System.out.println("\nPercurso In-Ordem Crescente");
		BinaryTreeUtil.inOrder2(tree.getRoot(), true);
		
		System.out.println("\nPercurso In-Ordem Decrescente");
		BinaryTreeUtil.inOrder2(tree.getRoot(), false);

	/*	System.out.println("\nPercurso In-Ordem Iterativo 1");
		BinaryTreeUtil.iterativeInOrder1(tree.getRoot());

		System.out.println("\nPercurso In-Ordem Iterativo 2");
		BinaryTreeUtil.iterativeInOrder2(tree.getRoot());
		
		System.out.println("\nPercurso P�s-Ordem");
		BinaryTreeUtil.posOrder(tree.getRoot());
/*
		System.out.println("\nRemovendo " + args[3]);
		tree.remove(new Integer(args[3]));

		System.out.println("\nPercurso In-Ordem");
		BinaryTreeUtil.inOrder(tree.getRoot());

	}*/
}
