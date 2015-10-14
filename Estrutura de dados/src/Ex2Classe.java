
public class Ex2Classe implements Ex2Interface{
	
	int tamanhoSacola;
	int[] sacola = new int[tamanhoSacola];
	int i=0;
	
	@Override
	public void inserir(int numero) {
		sacola[i]=numero;
		i++;
	}

	@Override
	public int buscar(int indice) {
		for(int x = 0; x < sacola.length; x++){
			if(x == indice){
				return sacola[x];
			}
		}
		return 0;
	}

	@Override
	public boolean excluir(int indice) {
		for(int x = 0; x < sacola.length; x++){
			if(x == indice){
				sacola[x]=0;
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean estaCheia() {
		if(i==tamanhoSacola){
			return true;
		}
		return false;
	}

	@Override
	public void tamanho(int tamanho) {
		tamanhoSacola = tamanho;
	}

}
