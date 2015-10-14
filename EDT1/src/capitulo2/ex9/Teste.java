package capitulo2.ex9;

public class Teste {

	public static void main(String[] args) {
		Conta cadastroContas = new Conta();
		
		cadastroContas.incluirCliente("Pedro", "Rua X", "0000001");
		cadastroContas.incluirCliente("Lucas", "Rua Y", "0000002");
		cadastroContas.incluirCliente("Gertom", "Rua Z", "0000003");
		
		cadastroContas.excluirCliente("Gertom");
		
		cadastroContas.verSaldo(cadastroContas.clientes[0].numero);
		cadastroContas.depositar(cadastroContas.clientes[0].numero, 1000);
		cadastroContas.sacar(cadastroContas.clientes[0].numero, 500);
		cadastroContas.verSaldo(cadastroContas.clientes[0].numero);

	}

}
