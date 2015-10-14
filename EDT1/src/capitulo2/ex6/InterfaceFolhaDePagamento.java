package capitulo2.ex6;

public interface InterfaceFolhaDePagamento {
	public void inserirFuncionario(int indice, 
			String nome,
			double salario,
			double horasExtrasDiurnas,
			double horasExtrasNoturnas,
			double horasFaltas,
			int numeroDependentes,
			int totalValesMes);
	public void excluirFuncionario(int indice);
	public void alterarNome(int indice, String nome);
	public void alterarSalario(int indice, double salario);
	public void alterarHEDiurnas(int indice, double quantidadeHora);
	public void alterarHENoturnas(int indice, double quantidadeHora);
	public void alterarNumeroDependentes(int indice, int numeroDepedentes);
	public void alterarFaltas(int indice, double quantidadeHoras);
	public void alterarTotalVales(int indice, int numeroVales);
}
