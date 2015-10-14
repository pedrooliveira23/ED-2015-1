package capitulo3.ex9;

public class Estante implements InterfaceEstante {
	private LinearList[] prateleiras;
	
	Estante(int numeroPrateleiras) {
		prateleiras = new ArrayLinearList[numeroPrateleiras];
		for(int i = 0; i < prateleiras.length; i++) {
			LinearList novaPrateleira = new ArrayLinearList(10);
			prateleiras[i] = novaPrateleira;
		}
	}
	
	@Override
	public Comparable retirar(int prateleira, int posicao) {
		return prateleiras[prateleira].remove(posicao);
	}

	@Override
	public void colocar(int prateleira, Comparable livro) {
		prateleiras[prateleira].add(prateleiras[prateleira].size(), livro);
	}

}
