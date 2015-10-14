package capitulo2.ex9;

public interface InterfaceConta {
	public void sacar(int numeroConta, double valor);
	public void depositar(int numeroConta, double valor);
	public void verSaldo(int numeroConta);
	public void incluirCliente(String nome, String endereco, String cpf);
	public void excluirCliente(String nome);
}
