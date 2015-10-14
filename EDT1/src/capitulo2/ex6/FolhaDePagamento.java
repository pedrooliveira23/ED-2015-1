package capitulo2.ex6;

public class FolhaDePagamento implements InterfaceFolhaDePagamento {
	private String nome;
	private double salario, horasExtrasDiurnas, horasExtrasNoturnas, horasFaltas;
	private int numeroDependentes, totalValesMes, numeroFuncionarios = 0;
	private FolhaDePagamento[] funcionarios = new FolhaDePagamento[50];
	
	@Override
	public void inserirFuncionario(int indice, String nome, double salario,
			double horasExtrasDiurnas, double horasExtrasNoturnas,
			double horasFaltas, int numeroDependentes, int totalValesMes) {
		
		if(indice == numeroFuncionarios){
			FolhaDePagamento novoFuncionario = new FolhaDePagamento();
			novoFuncionario.nome = nome;
			novoFuncionario.salario = salario;
			novoFuncionario.horasExtrasDiurnas = horasExtrasDiurnas;
			novoFuncionario.horasExtrasNoturnas = horasExtrasNoturnas;
			novoFuncionario.horasFaltas = horasFaltas;
			novoFuncionario.numeroDependentes = numeroDependentes;
			novoFuncionario.totalValesMes = totalValesMes;
			funcionarios[indice] = novoFuncionario;
			numeroFuncionarios++;
			System.out.println("Funcionario Inserido!");
		}else{
			System.out.println("Indice inválido!");
		}		
	}	
	
	@Override
	public void excluirFuncionario(int indice) {
		if(indice < numeroFuncionarios){
			funcionarios[indice] = null;
			for(int i = indice; i <= numeroFuncionarios; i++){
				funcionarios[i] = funcionarios[i+1];
			}
			funcionarios[numeroFuncionarios] = null;
			numeroFuncionarios--;
			System.out.println("Funcionario Excluido!");
		}else{
			System.out.println("Indice Invalido!");
		}
	}
	@Override
	public void alterarNome(int indice, String nome) {
		if(indice < numeroFuncionarios){
			funcionarios[indice].nome = nome;
			System.out.println("Alteração realizada!");
		}else{
			System.out.println("Indice Invalido!");
		}
	}
	@Override
	public void alterarSalario(int indice, double salario) {
		if(indice < numeroFuncionarios){
			funcionarios[indice].salario = salario;
			System.out.println("Alteração realizada!");
		}else{
			System.out.println("Indice Invalido!");
		}
	}
	@Override
	public void alterarHEDiurnas(int indice, double quantidadeHora) {
		if(indice < numeroFuncionarios){
			funcionarios[indice].horasExtrasDiurnas = quantidadeHora;
			System.out.println("Alteração realizada!");
		}else{
			System.out.println("Indice Invalido!");
		}
	}
	@Override
	public void alterarHENoturnas(int indice, double quantidadeHora) {
		if(indice < numeroFuncionarios){
			funcionarios[indice].horasExtrasNoturnas = quantidadeHora;
			System.out.println("Alteração realizada!");
		}else{
			System.out.println("Indice Invalido!");
		}
	}
	@Override
	public void alterarNumeroDependentes(int indice, int numeroDepedentes) {
		if(indice < numeroFuncionarios){
			funcionarios[indice].numeroDependentes = numeroDepedentes;
			System.out.println("Alteração realizada!");
		}else{
			System.out.println("Indice Invalido!");
		}
	}
	@Override
	public void alterarFaltas(int indice, double quantidadeHoras) {
		if(indice < numeroFuncionarios){
			funcionarios[indice].horasFaltas = quantidadeHoras;
			System.out.println("Alteração realizada!");
		}else{
			System.out.println("Indice Invalido!");
		}
	}
	@Override
	public void alterarTotalVales(int indice, int numeroVales) {
		if(indice < numeroFuncionarios){
			funcionarios[indice].totalValesMes = numeroVales;
			System.out.println("Alteração realizada!");
		}else{
			System.out.println("Indice Invalido!");
		}
	}
		
}