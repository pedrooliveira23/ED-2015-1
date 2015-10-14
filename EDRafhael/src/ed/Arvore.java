package ed;

public class Arvore {
	private BTNode root;

	private int size;

	public Arvore(Comparable o) {
		root = new BTNode(o, null, null, null);
		size = 1;
	}

	public void inserir(Comparable o) {
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
			root = (BTNode) novo;
		else if (o.compareTo(noY.getElement()) < 0)
			noY.setLeft(novo);
		else
			noY.setRight(novo);
		size++;
	}

	private SimpleBTNode search(SimpleBTNode no, Comparable key) {
		if (key == null)
			return null;

		if ((no == null) || (no.getElement().compareTo(key) == 0))
			return no;

		if (key.compareTo(no.getElement()) < 0)
			return search(no.getLeft(), key);
		else
			return search(no.getRight(), key);
	}

	private SimpleBTNode successor(SimpleBTNode noX) {
		SimpleBTNode noY = null;

		if (noX.getRight() != null) // caso 1
			return menor(noX.getRight());

		noY = ((BTNode) noX).getParent();
		while ((noY != null) && (noX == noY.getRight())) {
			noX = noY;
			noY = ((BTNode) noY).getParent();
		}
		return noY;
	}

	public SimpleBTNode menor(SimpleBTNode noX) {
		while (noX.getLeft() != null)
			noX = noX.getLeft();
		return noX;
	}

	public Comparable remover(Comparable key) {
		SimpleBTNode noY = null, noX = null;
		Comparable removed = null;

		SimpleBTNode noChave = search(getRoot(), key);

		if (noChave == null)
			return null;

		removed = noChave.getElement();

		if ((noChave.getLeft() == null) || (noChave.getRight() == null))
			noY = noChave;
		else
			noY = successor(noChave);

		if (noY.getLeft() != null)
			noX = noY.getLeft();
		else
			noX = noY.getRight();

		if (noX != null)
			((BTNode) noX).setParent(((BTNode) noY).getParent());
		if (((BTNode) noY).getParent() == null)
			root = (BTNode) noX;
		else if (noY == (((BTNode) noY).getParent()).getLeft())
			(((BTNode) noY).getParent()).setLeft(noX);
		(((BTNode) noY).getParent()).setRight(noX);

		if (noY != noChave)
			noChave.setElement(noY.getElement());
		((BTNode) noY).setParent(null);
		noY.setLeft(null);
		noY.setRight(null);
		return removed;
	}

	public Comparable maior(SimpleBTNode noX) {
		while (noX.getRight() != null)
			noX = noX.getRight();
		return noX;
	}

	public int getAltura() {
		return BinaryTreeUtil.height1((BTNode) root);
	}

	public boolean isCompleta() {
		if (getAltura() == BinaryTreeUtil.lg(size)) {
			return true;
		}
		return false;
	}

	public boolean isEstritamenteBinaria() {
		return calculaEstritamenteBinaria(root);
	}

	private boolean calculaEstritamenteBinaria(SimpleBTNode no) {
		if (no.getLeft() == null && no.getRight() == null)
			return true;
		else if ((no.getLeft() == null && no.getRight() != null)
				|| (no.getRight() == null && no.getLeft() != null))
			return false;
		else
			return ((calculaEstritamenteBinaria(no.getLeft())) ? calculaEstritamenteBinaria(no
					.getRight()) : false);
	}

	public SimpleBTNode getRoot() {
		return root;
	}
}
