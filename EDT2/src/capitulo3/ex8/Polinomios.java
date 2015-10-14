package capitulo3.ex8;

public class Polinomios implements Interface {

	@Override
	public LinkedLinearList soma(LinkedLinearList a, LinkedLinearList b) {
		LinkedLinearList resultado = new LinkedLinearList();
		boolean tem = false;
		
		for(int i = 0; i < a.size(); i++) {
			for(int j = 0; j < b.size(); j++) {
				if(a.getExpoenteLista(i).equals(b.getExpoenteLista(j))) {
					resultado.add(resultado.size(), 
							((int)a.getCoeficienteLista(i) + (int)b.getCoeficienteLista(j)), 
							a.getExpoenteLista(i));
					tem = true;
					b.remove(j);
				}
			}
			if(tem == false) {
				resultado.add(resultado.size(), a.getCoeficienteLista(i), a.getExpoenteLista(i));
			}
			tem = false;
		}
		for(int j = 0; j < b.size(); j++){
			for(int i = 0; i < a.size(); i++) {
				if(a.getExpoenteLista(i).equals(b.getExpoenteLista(j))) {
					resultado.add(resultado.size(), 
							((int)a.getCoeficienteLista(i) + (int)b.getCoeficienteLista(j)), 
							a.getExpoenteLista(i));
					tem = true;
				}
			}
			if(tem == false) {
				resultado.add(resultado.size(), b.getCoeficienteLista(j), b.getExpoenteLista(j));
			}
			tem = false;
		}
		
		return ordenar(resultado);
	}

	@Override
	public LinkedLinearList multiplicacao(LinkedLinearList a, LinkedLinearList b) {
		LinkedLinearList[] resultados;
		LinkedLinearList resultado = new LinkedLinearList();
		
		if(a.size() > b.size()) {
			resultados = new LinkedLinearList[a.size()];
		} else {
			resultados = new LinkedLinearList[b.size()];
		}
		
		for(int i = 0; i < a.size(); i++) {
			LinkedLinearList novoResultado = new LinkedLinearList();
			resultados[i] = novoResultado;
			for(int j = 0; j < b.size(); j++) {
				resultados[i].add(resultados[i].size(), 
						((int)a.getCoeficienteLista(i) * (int)b.getCoeficienteLista(j)), 
						((int)a.getExpoenteLista(i) + (int)b.getExpoenteLista(j)));
			}
			
			if(i == 0){
				resultado = resultados[i];
			}else{			
				resultado = soma(resultado,resultados[i]);
			}
		}
		
		return ordenar(resultado);
	}
	
	private LinkedLinearList ordenar(LinkedLinearList polinomio) {
		for(int i = 0; i < polinomio.size(); i++) {
			for(int j = i + 1; j < polinomio.size(); j++) {
				if(polinomio.getExpoenteLista(i).compareTo(polinomio.getExpoenteLista(j)) < 0) {
					Comparable auxC = polinomio.getNode(i).getCoeficiente();
					Comparable auxE = polinomio.getNode(i).getExpoente();
					polinomio.getNode(i).setCoeficiente(polinomio.getCoeficienteLista(j));
					polinomio.getNode(i).setExpoente(polinomio.getExpoenteLista(j));
					polinomio.getNode(j).setCoeficiente(auxC);
					polinomio.getNode(j).setExpoente(auxE);
				}
			}
		}
		return polinomio;
	}
	
}
