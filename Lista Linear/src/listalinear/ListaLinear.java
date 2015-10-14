package listalinear;

public interface ListaLinear {
	public int size();
	public int indexOf(Comparable elemento);
	public boolean add(int index, Comparable elemento);
	public boolean add(Comparable elemento);
	public boolean remove(int index);
	public boolean isEmpty();
	public Comparable get(int index);
	public String toString();
}
