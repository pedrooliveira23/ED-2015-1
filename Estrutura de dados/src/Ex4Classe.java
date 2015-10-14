
public class Ex4Classe implements Ex4Interface{

	@Override
	public String soma(String x, String y) {
		if(x.equals("seco") && y.equals("molhado")){
			return ("seco");
		}
		return ("molhado");
	}

	@Override
	public String subtracao(String x, String y) {
		if(y.equals("seco")){
			return ("molhado");
		}
		return ("seco");
	}

	

}
