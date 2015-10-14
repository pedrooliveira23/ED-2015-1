package capitulo3.ex2;

public interface LinearList {
	public boolean isEmpty(int lista);

	public int size(int lista);

	public Comparable get(int index, int lista);

	public int indexOf(Comparable theElement, int lista);

	public Comparable remove(int index, int lista);

	public void add(Comparable theElement, int lista);

	public String toString(int lista);
	
	public void criaListas(int numeroListas); // método para criar n listas;
}