package capitulo3.ex2;

public class OrderedList implements LinearList {
	private int tamanho, numeroListas = 0;
	private No cabeca;
	OrderedList[] listas = new OrderedList[100];
	
	
	@Override
	public void criaListas(int numeroListas) {
		for(int i = 0; i < numeroListas; i++){
			OrderedList novaLista = new OrderedList();
			novaLista.tamanho = 0;
			novaLista.cabeca = null;
			listas[i] = novaLista;
		}
		
	}

	@Override
	public boolean isEmpty(int lista) {
		return (listas[lista].tamanho == 0);
	}

	@Override
	public int size(int lista) {
		// TODO Auto-generated method stub
		return listas[lista].tamanho;
	}

	@Override
	public Comparable get(int index, int lista) {
		checaIndice(index, lista);
		No proximo = listas[lista].cabeca;
		for (int i = 0; i < index; i++) {
			proximo = proximo.getProximo();
		}
		return proximo.getElemento();
	}

	private void checaIndice(int index, int lista) {
		if (index < 0 || index >= listas[lista].tamanho) {
			throw new IndexOutOfBoundsException("Indice = " + index
					+ " tamanho = " + listas[lista].tamanho);
		}
	}

	@Override
	public int indexOf(Comparable theElement, int lista) {
		No proximo = listas[lista].cabeca;
		for (int i = 0; i < listas[lista].tamanho; i++) {
			if (theElement.compareTo(proximo.getElemento()) == 0) {
				return i;
			}
			proximo = proximo.getProximo();
		}
		return -1;
	}

	@Override
	public Comparable remove(int index, int lista) {
		checaIndice(index, lista);
		No removido = listas[lista].cabeca;
		if (index == 0) {
			listas[lista].cabeca = listas[lista].cabeca.getProximo();
		} else {
			No anterior = getNo(index - 1, lista);
			removido = anterior.getProximo();
			anterior.setProximo(removido.getProximo());
		}

		removido.setProximo(null);
		listas[lista].tamanho--;
		ordena(lista);
		return removido.getElemento();
	}

	private No getNo(int index, int lista) {
		checaIndice(index, lista);
		No proximo = listas[lista].cabeca;
		for (int i = 0; i < index; i++) {
			proximo = proximo.getProximo();
		}
		return proximo;
	}

	@Override
	public void add(Comparable theElement, int lista) {
		if(listas[lista].tamanho == 0){
			No novo = new No(theElement, null);
			listas[lista].cabeca = novo;
			listas[lista].tamanho++;
		} else {
			No novo = new No(theElement, listas[lista].cabeca);
			listas[lista].cabeca = novo;
			listas[lista].tamanho++;
			ordena(lista);
		}
	}
	
	public void ordena(int lista){
		No aux = new No();
		No proximoA = listas[lista].cabeca;
		No proximoB = proximoA;
		for (int i = 0; i < listas[lista].tamanho; i++) {
			for(int j = 0; j < listas[lista].tamanho; j++){
				if(proximoA.getElemento().compareTo(proximoB.getElemento()) < 0){
					aux.setElemento(proximoA.getElemento());
					proximoA.setElemento(proximoB.getElemento());
					proximoB.setElemento(aux.getElemento());
				}
				proximoB = proximoB.getProximo();
			}
			proximoB = listas[lista].cabeca;
			proximoA = proximoA.getProximo();
		}
	}

	public String toString(int lista) {
		StringBuffer s = new StringBuffer("[");
		for (No n = listas[lista].cabeca; n != null; n = n.getProximo()) {
			if (n.getElemento() == null) {
				s.append("null, ");
			} else {
				s.append(n.getElemento().toString() + " ");
			}
		}

		if (listas[lista].tamanho > 0) {
			s.delete(s.length() - 1, s.length());
		}

		s.append("]");

		return new String(s);
	}

}
