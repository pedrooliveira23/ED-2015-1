package capitulo2.ex8;

public class Campeonato implements Interface{
	private Campeonato[] times = new Campeonato[32];
	private String nome;
	private int numeroPontos, 
				numeroGolsMarcados, 
				numeroGolsSofridos, 
				numeroVitorias, 
				quantidadeTimes = 0;
	boolean iniciado = false;

	@Override
	public void incluirtime(String nome, int numeroPontos,
			int numeroGolsMarcados, int numeroGolsSofridos, int numeroVitorias) {
		if(iniciado == false && quantidadeTimes < times.length){
			Campeonato novoTime = new Campeonato();
			novoTime.nome = nome;
			novoTime.numeroPontos = numeroPontos;
			novoTime.numeroGolsMarcados = numeroGolsMarcados;
			novoTime.numeroGolsSofridos = numeroGolsSofridos;
			novoTime.numeroVitorias = numeroVitorias;
			times[quantidadeTimes] = novoTime;
			quantidadeTimes++;
		}else{
			System.out.println("\nO campeonato já foi iniciado!");
		}
		
	}

	@Override
	public void removerTime(String nome) {
		if(iniciado == false){
			for(int i = 0; i < quantidadeTimes; i++){
				if(times[i].nome.equals(nome) == true){
					times[i] = null;
					quantidadeTimes--;
					for(int j = i; j < quantidadeTimes; j++){
						times[j] = times[j+1];
					}
				}
			}
		}else{
			System.out.println("\nO campeonato já foi iniciado!");
		}
	}

	@Override
	public String listarPontos() {
		String lista = "\n";
		Campeonato aux = new Campeonato();
		for(int i = 0; i < quantidadeTimes; i++){
			for(int j = 0; j < quantidadeTimes; j++){
				if(times[i].numeroPontos > times[j].numeroPontos){
					aux = times[i];
					times[i] = times[j];
					times[j] = aux;
					aux = null;
				}
			}
		}
		
		for(int i = 0; i < quantidadeTimes; i++){
			lista += times[i].nome + " - " + times[i].numeroPontos + " pontos\n";
		}
		return lista;
	}

	@Override
	public String listarVitorias() {
		String lista = "\n";
		Campeonato aux = new Campeonato();
		for(int i = 0; i < quantidadeTimes; i++){
			for(int j = 0; j < quantidadeTimes; j++){
				if(times[i].numeroVitorias > times[j].numeroVitorias){
					aux = times[i];
					times[i] = times[j];
					times[j] = aux;
					aux = null;
				}
			}
		}
		for(int i = 0; i < quantidadeTimes; i++){
			lista += times[i].nome + " - " + times[i].numeroVitorias + " vitorias\n";
		}
		return lista;
	}

	@Override
	public String listarGolsMarcados() {
		String lista = "\n";
		Campeonato aux = new Campeonato();
		for(int i = 0; i < quantidadeTimes; i++){
			for(int j = 0; j < quantidadeTimes; j++){
				if(times[i].numeroGolsMarcados > times[j].numeroGolsMarcados){
					aux = times[i];
					times[i] = times[j];
					times[j] = aux;
					aux = null;
				}
			}
		}
		for(int i = 0; i < quantidadeTimes; i++){
			lista += times[i].nome + " - " + times[i].numeroGolsMarcados + " gols marcados\n";
		}
		return lista;
	}

	@Override
	public String listarGolsSofridos() {
		String lista = "\n";
		Campeonato aux = new Campeonato();
		for(int i = 0; i < quantidadeTimes; i++){
			for(int j = 0; j < quantidadeTimes; j++){
				if(times[i].numeroGolsSofridos < times[j].numeroGolsSofridos){
					aux = times[i];
					times[i] = times[j];
					times[j] = aux;
					aux = null;
				}
			}
		}
		for(int i = 0; i < quantidadeTimes; i++){
			lista += times[i].nome + " - " + times[i].numeroGolsSofridos + " gols sofridos\n";
		}
		return lista;
	}
	
	public boolean iniciarCampeonato(){
		return iniciado = true;
	}

}
