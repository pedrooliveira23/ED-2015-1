package trabalho;

import arvorebinaria.BTNode;
import arvorebinaria.BinaryTreeCormen;
import arvorebinaria.BinaryTreeUtil;

public interface Interface {
	public void inserirElemento(Comparable elemento);

	public Comparable removerElemento(Comparable chave);

	public Comparable maiorElemento();

	public Comparable menorElemento();

	public int getAltura();

	public boolean isCompleta();

	public boolean isEstritamenteBinaria();
}
