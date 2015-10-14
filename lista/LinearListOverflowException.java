package br.ufg.inf.ed1.lista;

/**
 * Classe que representa uma exceção gerada quando a lista esta cheia.
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
