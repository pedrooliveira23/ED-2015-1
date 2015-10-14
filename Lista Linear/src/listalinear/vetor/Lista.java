package listalinear.vetor;

import listalinear.ListaLinear;

public class Lista implements ListaLinear{
	Comparable[] vetor;
	private int size;
	
	public Lista(int tamanho) {
		vetor = new Comparable[tamanho];
		size = 0;
	}
	

	@Override
	public int size() {
		return size;
	}
	
	private void deslocadorEsquerda(int index) {
		for(int i = size - 1; i >= index; i--) {
			vetor[i+1] = vetor[i];
		}
	}
	
	@Override
	public int indexOf(Comparable Elemento) {
		for(int i = 0; i < size; i++) {
			if(vetor[i].equals(Elemento)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public boolean add(int index, Comparable elemento) {
		if (index > size || index < 0 || size >= 10) {
			return false;
		}
		
		if(vetor[index] != null) {
			deslocadorEsquerda(index);
		}
		
		vetor[index] = elemento;
		size++;
		
		return true;
	}
	

	@Override
	public boolean add(Comparable elemento) {
		if (size >= 10) {
			return false;
		}
		vetor[size++] = elemento;
		return true;
	}

	@Override
	public boolean remove(int index) {
		if (index > size || index < 0) {
			return false;
		}
		
		for(int i = index; i < size - 1; i++) {
			vetor[i] = vetor[i+1];
		}
		
		vetor[size-1] = null;
		size--;
		
		return true;
	}

	@Override
	public boolean isEmpty() {
		return (size == 0);
	}

	@Override
	public Comparable get(int index) {
		for(int i = 0; i < size; i++) {
			if(i == index) {
				return vetor[i];
			}
		}
		return null;
	}
	
	public String toString() {
		String string = "[";
		
		for(int i = 0; i < size; i++) {
			string += vetor[i] + ", ";
		}
		
		string = string.substring(0, string.length() - 2);
		string +="]";
		
		return string;
	}

}
