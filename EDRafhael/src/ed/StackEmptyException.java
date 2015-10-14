package ed;

/**
 * Exce��o gerada para representar o estado de pilha vazia.
 * 
 * @author Auri Vincenzi
 */
public class StackEmptyException extends RuntimeException {
	private static final long serialVersionUID = 6407819151690539530L;

	public StackEmptyException(String msg) {
		super(msg);
	}
}
