package listalinear.duplamenteligada;

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
				No novo = new No(elemento, cabeca, null);
				cabeca = novo;
				size++;
				return true;
			} 
			else {
				No aux = cabeca;
			
				No anterior = new No();
				
				No novo = new No(elemento, null, null);
				
				for(int i = 0; i < index; i++) {
					anterior = aux;
					aux = aux.getProximo();
				}
			
				aux = anterior.getProximo();
				
				novo.setProximo(aux);
				novo.setAnterior(anterior);
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
			No anterior = new No();
			No novo = new No(elemento, null, null);
			
			for(int i = 0; i < size; i++) {
				anterior = aux;
				aux = aux.getProximo();
			}
			aux.setProximo(novo);
			novo.setAnterior(anterior);
		}
		else {
			No novo = new No(elemento, cabeca, null);
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
				cabeca.setAnterior(null);
				size--;
				return true;
			}
			else {
			No aux = cabeca;
				
			No anterior = new No();
		
				
			for(int i = 0; i < index; i++) {
				anterior = aux;
				aux = aux.getProximo();
			}
			
			
			anterior.setProximo(aux.getProximo());
			aux.setAnterior(null);
			aux = aux.getProximo();
			aux.setAnterior(anterior);
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
