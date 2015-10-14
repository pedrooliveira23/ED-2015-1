package capitulo3.ex3;

/**
 * Classe que representa uma exce��o gerada quando a lista esta cheia.
 * 
 * @author Auri Vincenzi
 * @version 08-2005
 */
public class LinearListOverflowException extends RuntimeException {
	private static final long serialVersionUID = -2290489317773080071L;

	public LinearListOverflowException(String msg) {
		super(msg);
	}
}
