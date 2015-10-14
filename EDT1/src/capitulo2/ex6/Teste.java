package capitulo2.ex6;

public class Teste {

	public static void main(String[] args) {
		FolhaDePagamento folhadepagamento = new FolhaDePagamento();
		
		folhadepagamento.inserirFuncionario(0, "Pedro", 30000, 0, 0, 0, 3, 0);
		folhadepagamento.inserirFuncionario(1, "Lucas", 25000, 0, 0, 0, 3, 0);
		folhadepagamento.inserirFuncionario(2, "Gertom", 35000, 0, 0, 0, 3, 0);
		folhadepagamento.inserirFuncionario(2, "Fulano", 35000, 0, 0, 0, 3, 0);
		
		folhadepagamento.excluirFuncionario(2);
		folhadepagamento.excluirFuncionario(2);
		
		folhadepagamento.alterarNome(3, "Teste");
		folhadepagamento.alterarSalario(1, 30000);
		

	}

}
