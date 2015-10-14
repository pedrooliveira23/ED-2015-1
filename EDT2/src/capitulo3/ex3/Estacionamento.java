package capitulo3.ex3;

public class Estacionamento implements Interface{
	private LinkedLinearList estacionamento = new LinkedLinearList();

	@Override
	public String chegada(String placa) {
		if(estacionamento.size() < 10){
			estacionamento.add(estacionamento.size(), placa);
			return "Há vaga. Carro estacionado com sucesso!";
		}
		return "Não há vaga. Aguarde uma vaga.";
	}

	@Override
	public String saida(String placa) {
		Node aux;
		if(estacionamento.indexOf(placa) > -1) {
			aux = estacionamento.getNode(estacionamento.indexOf(placa));
			estacionamento.remove(estacionamento.indexOf(placa));
			return "O carro foi deslocado " + aux.contMovimentos;
		}
		return "A placa não existe!";
	}
	
	
}
