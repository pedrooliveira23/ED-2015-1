package capitulo3.ex10;

import java.util.Scanner;

public class Editor implements InterfaceEditor {
	private LinearList texto = new DLinkedLinearList();
	private Scanner scn = new Scanner(System.in);

	@Override
	public void I(int n) {
		texto.add(n, scn.nextLine());
	}

	@Override
	public void I() {
		texto.add(texto.size(), scn.nextLine());
	}

	@Override
	public void E(int i, int f) {
		for(int n = i; n <= f; n++) {
			texto.remove(n);
		}
	}

	@Override
	public void E() {
		texto.remove(texto.size()-1);
	}

	@Override
	public void D(int i, int f, int p) {
		LinearList aux = new DLinkedLinearList();
		for(int n = f; n >= i; n--) {
			aux.add(aux.size(), texto.get(n));
		}
		
		for(int n = i; n <= f; n++) {
			texto.add(p+1, aux.get(n));
		}
	}

	@Override
	public String L(int i, int f) {
		String textoListado = "";
		for(int n = i; n <= f; n++) {
			textoListado += texto.get(n) + "\n";
		}
		return textoListado;
	}

	@Override
	public String L() {
		String textoListado = "";
		for(int n = 0; n < texto.size(); n++) {
			textoListado += texto.get(n) + "\n";
		}
		return textoListado;
	}

	@Override
	public void C(Editor arq, int n) {
		for(int i = arq.getLista().size(); i >= 0; i--) {
			texto.add(n, arq.getLista().get(i));			
		}	
	}

	@Override
	public void C(Editor arq) {
		int index = texto.size();
		for(int i = arq.getLista().size(); i >= 0; i--) {
			texto.add(index, arq.getLista().get(i));			
		}	
	}

	@Override
	public void S(Editor arq, int i, int f) {
		int index = arq.getLista().size();
		for(int n = f; n >= i; n--) {
			arq.getLista().add(index, texto.get(n));		
		}
	}

	@Override
	public void S(Editor arq) {
		int index = arq.getLista().size();
		for(int n = texto.size()-1; n >= 0; n--) {
			arq.getLista().add(index, texto.get(n));		
		}
	}

	@Override
	public void A(int n) {
		Comparable novaLinha = scn.nextLine();
		texto.remove(n);
		texto.add(n, novaLinha);
	}

	@Override
	public boolean F() {
		return false;
	}
	
	public LinearList getLista() {
		return texto;
	}

}
