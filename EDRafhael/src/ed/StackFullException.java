package ed;

/**
 * Exce��o gerada para representar o estado de pilha cheia.
 * 
 * @author Auri Vincenzi
 */
public class StackFullException extends RuntimeException {
	private static final long serialVersionUID = 4661171679812367426L;

	public StackFullException(String msg) {
		super(msg);
	}
}