package trabalho;

import arvorebinaria.BTNode;
import arvorebinaria.BinaryTreeCormen;
import arvorebinaria.BinaryTreeUtil;
import arvorebinaria.SimpleBTNode;

public class ArvoreBinaria {
	private BinaryTreeCormen arvore;
	private int nos = 0;

	public void inserirElemento(Comparable elemento) {
		if (arvore == null) {
			arvore = new BinaryTreeCormen(elemento);
			nos++;
		} else {
			arvore.insert(elemento);
			nos++;
		}
	}

	public Comparable removerElemento(Comparable chave) {
		Comparable removido = arvore.remove(chave);
		if (removido.equals(null)) {
			return removido;
		}
		nos--;
		return removido;
	}

	public Comparable maiorElemento() {
		return arvore.maximum(arvore.getRoot()).getElement();
	}

	public Comparable menorElemento() {
		return arvore.minimum(arvore.getRoot()).getElement();
	}

	public int getAltura() {
		return BinaryTreeUtil.height1((BTNode) arvore.getRoot());
	}

	public boolean isCompleta() {
		if (getAltura() == BinaryTreeUtil.lg(nos)) {
			return true;
		}
		return false;
	}

	public boolean isEstritamenteBinaria() {
		return calculaEstritamenteBinaria(arvore.getRoot());
	}

	private boolean calculaEstritamenteBinaria(SimpleBTNode no) {
		/*
		 * Algoritmo sugerido pelo usúado learningToCode em
		 * :http://cboard.cprogramming
		 * .com/cplusplus-programming/116064-determine
		 * -if-tree-strictly-binary-bst.html
		 */
		
		if (no.getLeft() == null && no.getRight() == null)
			return true;
		else if ((no.getLeft() == null && no.getRight() != null)
				|| (no.getRight() == null && no.getLeft() != null))
			return false;
		else
			return ((calculaEstritamenteBinaria(no.getLeft())) ? calculaEstritamenteBinaria(no
					.getRight()) : false);
	}
}
