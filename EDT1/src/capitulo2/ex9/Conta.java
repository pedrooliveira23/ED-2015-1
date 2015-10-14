package capitulo2.ex9;

public class Conta implements InterfaceConta{
	private String nome, endereco, cpf;
	private int quantidadeClientes = 0;
	int numero;
	private double valor;
	Conta[] clientes = new Conta[100];

	@Override
	public void incluirCliente(String nome, String endereco, String cpf) {
		if(quantidadeClientes < 100){
			Conta novoCliente = new Conta();
			novoCliente.nome = nome;
			novoCliente.endereco = endereco;
			novoCliente.cpf = cpf;
			novoCliente.numero = (int) (Math.random()*10000);
			novoCliente.valor = 0;
			clientes[quantidadeClientes] = novoCliente;
			quantidadeClientes++;
			System.out.println("Cliente incluido com sucesso! Numero da conta: " + novoCliente.numero);
		}
	}

	@Override
	public void excluirCliente(String nome) {
		for (int i = 0; i < quantidadeClientes; i++) {
			if(clientes[i].nome.equals(nome) == true){
				System.out.println("Cliente " + clientes[i].nome + " removido com sucesso!");
				clientes[i] = null;
				quantidadeClientes--;
				for (int j = i; j < quantidadeClientes; j++) {
					clientes[j] = clientes[j+1];
				}
			}
		}
		
	}

	@Override
	public void sacar(int numeroConta, double valor) {
		for(int i = 0; i < quantidadeClientes; i++){
			if(clientes[i].numero == numeroConta){
				if(clientes[i].valor >= valor){
					clientes[i].valor -= valor;
					System.out.println("Saque Realizado!");
				}
				else{
					System.out.println("Valor insuficiente em conta!");
				}
			}
		}
	}

	@Override
	public void depositar(int numeroConta, double valor) {
		for(int i = 0; i < quantidadeClientes; i++){
			if(clientes[i].numero == numeroConta){
				clientes[i].valor += valor;
				System.out.println("Deposito Realizado!");
			}
		}
	}

	@Override
	public void verSaldo(int numeroConta) {
		for(int i = 0; i < quantidadeClientes; i++){
			if(clientes[i].numero == numeroConta){
				System.out.println("Saldo: " + clientes[i].valor);
			}
		}
	}

}
