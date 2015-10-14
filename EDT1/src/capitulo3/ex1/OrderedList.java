package capitulo3.ex1;

public class OrderedList implements LinearList {
	private int tamanho;
	private No cabeca;

	public OrderedList() {
		tamanho = 0;
		cabeca = null;
	}

	@Override
	public boolean isEmpty() {
		return (tamanho == 0);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return tamanho;
	}

	@Override
	public Comparable get(int index) {
		checaIndice(index);
		No proximo = cabeca;
		for (int i = 0; i < index; i++) {
			proximo = proximo.getProximo();
		}
		return proximo.getElemento();
	}

	private void checaIndice(int index) {
		if (index < 0 || index >= tamanho) {
			throw new IndexOutOfBoundsException("Indice = " + index
					+ " tamanho = " + tamanho);
		}
	}

	@Override
	public int indexOf(Comparable theElement) {
		No proximo = cabeca;
		for (int i = 0; i < tamanho; i++) {
			if (theElement.compareTo(proximo.getElemento()) == 0) {
				return i;
			}
			proximo = proximo.getProximo();
		}
		return -1;
	}

	@Override
	public Comparable remove(int index) {
		checaIndice(index);
		No removido = cabeca;
		if (index == 0) {
			cabeca = cabeca.getProximo();
		} else {
			No anterior = getNo(index - 1);
			removido = anterior.getProximo();
			anterior.setProximo(removido.getProximo());
		}

		removido.setProximo(null);
		tamanho--;
		ordena();
		return removido.getElemento();
	}

	private No getNo(int index) {
		checaIndice(index);
		No proximo = cabeca;
		for (int i = 0; i < index; i++) {
			proximo = proximo.getProximo();
		}
		return proximo;
	}

	@Override
	public void add(Comparable theElement) {
		if(tamanho == 0){
			No novo = new No(theElement, null);
			cabeca = novo;
			tamanho++;
		} else {
			No novo = new No(theElement, cabeca);
			cabeca = novo;
			tamanho++;
			ordena();
		}
	}
	
	public void ordena(){
		No aux = new No();
		No proximoA = cabeca;
		No proximoB = proximoA;
		for (int i = 0; i < tamanho; i++) {
			for(int j = 0; j < tamanho; j++){
				if(proximoA.getElemento().compareTo(proximoB.getElemento()) < 0){
					aux.setElemento(proximoA.getElemento());
					proximoA.setElemento(proximoB.getElemento());
					proximoB.setElemento(aux.getElemento());
				}
				proximoB = proximoB.getProximo();
			}
			proximoB = cabeca;
			proximoA = proximoA.getProximo();
		}
	}

	public String toString() {
		StringBuffer s = new StringBuffer("[");
		for (No n = cabeca; n != null; n = n.getProximo()) {
			if (n.getElemento() == null) {
				s.append("null, ");
			} else {
				s.append(n.getElemento().toString() + " ");
			}
		}

		if (tamanho > 0) {
			s.delete(s.length() - 1, s.length());
		}

		s.append("]");

		return new String(s);
	}

}
