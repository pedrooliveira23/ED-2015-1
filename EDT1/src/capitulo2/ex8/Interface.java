package capitulo2.ex8;

public interface Interface {
	public void incluirtime(String nome, 
			int numeroPontos, 
			int numeroGolsMarcados, 
			int numeroGolsSofridos, 
			int numeroVitorias);
	public void removerTime(String nome);
	public String listarPontos();
	public String listarVitorias();
	public String listarGolsMarcados();
	public String listarGolsSofridos();
}
