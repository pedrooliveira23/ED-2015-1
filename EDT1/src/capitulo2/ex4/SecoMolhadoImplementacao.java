package capitulo2.ex4;

public class SecoMolhadoImplementacao implements SecoMolhado{
	public static final int SECO = 0;
	public static final int MOLHADO = 1;
	int resultado;
	
	public SecoMolhadoImplementacao(int x){
		resultado = x;
	}
	
	@Override
	public String adicao(int y) {	
		SecoMolhadoImplementacao sm = new SecoMolhadoImplementacao(resultado);
		sm.resultado += y;
		if(sm.resultado == SECO){
			return "Seco";
		}
		return "Molhado";
	}

	@Override
	public String subtracao(int y) {
		SecoMolhadoImplementacao sm = new SecoMolhadoImplementacao(resultado);
		sm.resultado -= y;
		if(sm.resultado == MOLHADO && sm.resultado > 0){
			return "Molhado";
		}
		return "seco";
	}

}
