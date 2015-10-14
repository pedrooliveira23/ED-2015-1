package capitulo3.ex8;

/**
 * Esta interface representa o conjunto de opera��es que devem estar presentes
 * no tipo abstrato de dados Lista Linear.
 * 
 * @author Auri Vincenzi
 * @version 08-2005
 */
public interface LinearList {
	public boolean isEmpty();

	public int size();

	public Comparable getCoeficienteLista(int index);

	public Comparable getExpoenteLista(int index);
	
	public int indexOfCoeficiente(Comparable theElement);

	public int indexOfExpoente(Comparable theElement);
	
	public Comparable remove(int index);

	public void add(int index, Comparable Coeficiente, Comparable Expoente);

	public String toString();
}