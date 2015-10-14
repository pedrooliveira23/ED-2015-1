package arvorebinaria;

/** 
 * Esta classe representa um n� de uma �rvore bin�ria sendo que cada n�
 * tamb�m faz refer�ncia para o seu pai. Essa extens�o � importante para
 * viabilizar o desenvolvimento de m�todos de percurso n�o recursivos.
 * 
 *  @author Auri Vincenzi
 */
public class BTNode extends SimpleBTNode {
	private SimpleBTNode parent;

	/** construtor default */
	public BTNode() {
		this(null, null, null, null);
	}

	/** construtor com par�metros */
	public BTNode(Comparable e, SimpleBTNode p, SimpleBTNode l, SimpleBTNode r) {
		super(l,e,r);
		parent = p;
	}

	public SimpleBTNode getParent() {
		return parent;
	}

	public void setParent(SimpleBTNode v) {
		parent = v;
	}

	public boolean isExternal() {
		return (getLeft() == null && getRight() == null);
	}

	public boolean isInternal() {
		return (getLeft() != null || getRight() != null);
	}
}
