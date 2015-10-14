package ed;

import java.text.DecimalFormat;
import java.util.Vector;

/**
 * Essa classe implementa uma s�rie de m�todos utilit�rios que podem 
 * ser utilizados e aplicados no contexto de �rvores bin�rias, tais como
 * os m�todos que percorrem a �rvore: pr�-ordem, in-ordem, p�s-ordem.
 * 
 * @author Auri Vincenzi
 */
public class BinaryTreeUtil {
	static void visit(SimpleBTNode n) {
		System.out.print(n.toString() + " ");
	}

	public static void preOrder(SimpleBTNode n) {
		if (n != null) {
			visit(n);
			preOrder(n.getLeft());
			preOrder(n.getRight());
		}
	}

	public static void inOrder(SimpleBTNode n) {
		if (n != null) {
			inOrder(n.getLeft());
			visit(n);
			inOrder(n.getRight());
		}
	}


	public static void posOrder(SimpleBTNode n) {
		if (n != null) {
			posOrder(n.getLeft());
			posOrder(n.getRight());
			visit(n);
		}
	}

	public static void inOrder2(SimpleBTNode no, boolean crescente) {
		if (no != null) {
			if (crescente)
				inOrder2(no.getLeft(), crescente);
			else
				inOrder2(no.getRight(), crescente);
			
			visit(no);
			
			if (crescente)
				inOrder2(no.getRight(), crescente);
			else
				inOrder2(no.getLeft(), crescente);
		}
	}

	
	/**
	 * Percurso inOrder iterativo utilizando uma pilha para simular a recurs�o.
	 * 
	 * @param n - n� raiz da �rvore a ser impressa.
	 */
	public static void iterativeInOrder1(SimpleBTNode n) {
		LinkedStack stack = new LinkedStack();
		SimpleBTNode p = n;
		while (p != null) {
			while (p != null) {
				if (p.getRight() != null)
					stack.push(p.getRight()); /*
											   * empilha filho da direita (se
											   * houver) e o pr�prio n� quando
											   * indo para a esquerda.
											   */
				stack.push(p);
				p = p.getLeft();
			}
			p = (SimpleBTNode) stack.pop(); /* extrai um n� sem filho esquerdo */
			while (!stack.isEmpty() && p.getRight() == null) {
				BinaryTreeUtil.visit(p);
				p = (SimpleBTNode) stack.pop();
			}
			BinaryTreeUtil.visit(p);
			if (!stack.isEmpty())
				p = (SimpleBTNode) stack.pop();
			else
				p = null;
		}
	}

	/**
	 * Implementa��o do Tenenbaum. N�o funciona corretamente.
	 * 
	 * @param n - n� raiz da �rvore a ser impressa.
	 */
	public static void iterativeInOrder1Old(SimpleBTNode n) {
		LinkedStack stack = new LinkedStack();
		SimpleBTNode p = n;
		do {
			/*
			 * percorre os desvios esq o m�ximo poss�vel salvando ponteiros para
			 * n�s passados
			 */
			while (p != null) {
				stack.push(p);
				p = p.getLeft();
			}
			/* verifica t�rmino */
			if (!stack.isEmpty()) {
				/* nesse ponto a sub�rvore esquerda est� vazia */
				p = (SimpleBTNode) stack.pop();
				BinaryTreeUtil.visit(p); /* visita a raiz */
				p = p.getRight(); /* percorre sub�rvore direita */
			}
		} while (!stack.isEmpty() && p != null);
	}

	/**
	 * Percurso inOrder iterativo utilizando atributo parent. Nem recurs�o nem
	 * pilha s�o necess�rios nesse caso.
	 * 
	 * @param n
	 *            n� raiz da �rvore a ser impressa.
	 */
	public static void iterativeInOrder2(BTNode n) {
		BTNode p, q;
		q = null;
		p = n;
		do {
			while (p != null) {
				q = p;
				p = (BTNode)p.getLeft();
			}
			if (q != null) {
				BinaryTreeUtil.visit(q);
				p = (BTNode)q.getRight();
			}
			while (q != null && p == null) {
				do {
					/*
					 * n� q sem filho da direita. Volta at� que um filho
					 * esquerdo ou a raiz da �rvore seja encontrado
					 */
					p = q;
					q = (BTNode)p.getParent();
				} while ((q != null) && !(q.getLeft() == p));
				if (q != null) {
					BinaryTreeUtil.visit(q);
					p = (BTNode)q.getRight();
				}
			}
		} while (q != null);
	}

	public static int depth(BTNode n) {
		if (n == null)
			return -1;
		else if (n.getParent() == null) {
			return 0;
		} else {
			return 1 + depth((BTNode)n.getParent());
		}
	}

	public static Vector tree2Vector(SimpleBTNode n) {
		if (n != null) {
			Vector v = new Vector();
			tree2Vector(v, n);
			return v;
		}
		return null;
	}

	private static void tree2Vector(Vector v, SimpleBTNode n) {
		if (n != null) {
			tree2Vector(v, n.getLeft());
			v.add(n);
			tree2Vector(v, n.getRight());
		}
	}

	public static int height1(BTNode n) {
		int h = 0;

		Vector list = new Vector();
		BinaryTreeUtil.tree2Vector(list, n);

		for (int i = 0; i < list.size(); i++) {
			BTNode no = (BTNode) list.elementAt(i);
			if (no.isExternal())
				h = Math.max(h, depth(no));
		}
		return h;
	}

	public static void printByLevel(BTNode no) {
		for (int i = 0; i <= BinaryTreeUtil.height1(no); i++) {
			BinaryTreeUtil.printByLevel(no, i);
			System.out.println();
		}
	}

	/**
	 * Imprime a �rvore bin�ria n�vel a n�vel
	 * 
	 * @param no
	 *            n� raiz da �rvore a ser impressa.
	 * @param level
	 *            n�vel a ser impresso (0 representa a raiz)
	 */
	public static void printByLevel(SimpleBTNode no, int level) {
		if (level == 0) {
			BinaryTreeUtil.visit(no);
		} else {
			if (no.getLeft() != null)
				printByLevel(no.getLeft(), level - 1);
			if (no.getRight() != null)
				printByLevel(no.getRight(), level - 1);
		}
	}

	/**
	 * A fun��o lg recebe um inteiro n > 0 e devolve o ch�o de log_2(n), ou
	 * seja, devolve o �nico inteiro i tal que 2^i <= n < 2^(i+1).
	 */
	public static int lg(int n) {
		int i;
		i = 0;
		while (n > 1) {
			n = n / 2;
			i += 1;
		}
		return i;
	}

	public static void main(String args[]) {
		if (args.length != 1) {
			System.out.println("Uso: BinaryTreeUtil <n>");
			System.exit(1);
		}
		int n = Integer.parseInt(args[0]);

		DecimalFormat format = new DecimalFormat("########");
		System.out.println("n\tlg(n)");
		System.out.println(format.format(n) + "\t"
				+ format.format(BinaryTreeUtil.lg(n)));
	}
}