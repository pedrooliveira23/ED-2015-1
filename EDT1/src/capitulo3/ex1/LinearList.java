package capitulo3.ex1;

/**
 * Esta interface representa o conjunto de operações que devem estar presentes
 * no tipo abstrato de dados Lista Linear.
 * 
 * @author Auri Vincenzi
 * @version 08-2005
 */

public interface LinearList {
	public boolean isEmpty();

	public int size();

	public Comparable get(int index);

	public int indexOf(Comparable theElement);

	public Comparable remove(int index);

	public void add(Comparable theElement);

	public String toString();
}