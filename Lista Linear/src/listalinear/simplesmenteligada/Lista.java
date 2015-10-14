package listalinear.simplesmenteligada;

import listalinear.ListaLinear;

public class Lista implements ListaLinear{
	No cabeca;
	private int size;

	public Lista() {
		cabeca = null;
		size = 0;
	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public int indexOf(Comparable elemento) {
		No aux = cabeca;
		
		for(int i = 0; i < size; i++) {
			if(aux.getElemento().equals(elemento)) {
				return i;
			}
			aux = aux.getProximo();
		}
		
		return -1;
	}

	@Override
	public boolean add(int index, Comparable elemento) {
		if(index < size || index > -1) {
			if(index == 0) {
				No novo = new No(elemento, cabeca);
				cabeca = novo;
				size++;
				return true;
			} 
			else {
				No aux = cabeca;
			
				No anterior = new No();
				
				No novo = new No(elemento, null);
				
				for(int i = 0; i <= index - 1; i++) {
					aux = aux.getProximo();
					anterior = aux;
				}
			
				aux = anterior.getProximo();
				
				novo.setProximo(aux);
				anterior.setProximo(novo);
				size++;
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean add(Comparable elemento) {
		if(!isEmpty()) {
			No aux = cabeca;
			
			No novo = new No(elemento, null);
			
			for(int i = 0; i < size - 1; i++) {
				aux = aux.getProximo();
			}
			aux.setProximo(novo);
		}
		else {
			No novo = new No(elemento, cabeca);
			cabeca = novo;
		}
		size++;
		return true;
	}

	@Override
	public boolean remove(int index) {
		if(index < size || index > -1) {
			if(index == 0) {
				cabeca = cabeca.getProximo();
				size--;
				return true;
			}
			else {
			No aux = cabeca;
				
			No anterior = new No();
		
				
			for(int i = 0; i <= index - 1; i++) {
				aux = aux.getProximo();
				anterior = aux;
			}
			
			aux = anterior.getProximo();
			
			anterior.setProximo(aux.getProximo());
			size--;
				
			return true;
			}
			
		}
		
		return false;
	}

	@Override
	public boolean isEmpty() {
		return (size == 0);
	}

	@Override
	public Comparable get(int index) {
		Comparable elemento = null;
		No aux = cabeca;
		
		for(int i = 0; i < size; i++) {
			if(i == index) {
				elemento = aux.getElemento();
			}
			aux = aux.getProximo();
		}
		return elemento;
	}
	
	public String toString() {
		No aux = cabeca;
		String string = "[";
		
		for(int i = 0; i < size; i++) {
			string += aux.getElemento() + ", ";
			aux = aux.getProximo();
		}
		
		string = string.substring(0, string.length() - 2);
		string +="]";
		
		return string;
	}

}
