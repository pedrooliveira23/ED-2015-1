package capitulo2.ex7;

public class CadastroDeLivros implements Interface{
	private CadastroDeLivros[] colecaoLivros = new CadastroDeLivros[100];
	private int codigo, ano, quantidadeLivros = 0;
	private String titulo, editora;
	private double preco;

	@Override
	public void incluirLivro(int codigo, String titulo, String editora,
			int anoPublicacao, double preco) {
		boolean podeCadastrar = true;
		for(int i = 0; i < quantidadeLivros; i++){
			if(colecaoLivros[i].codigo == codigo){
				System.out.println("Já existe um livro cadastrado com esse código!");
				podeCadastrar = false;
				break;
			}
		}
		
		if(podeCadastrar == true && quantidadeLivros < 100){
			CadastroDeLivros novoLivro = new CadastroDeLivros();
			novoLivro.codigo = codigo;
			novoLivro.titulo = titulo;
			novoLivro.editora = editora;
			novoLivro.ano = anoPublicacao;
			novoLivro.preco = preco;
			colecaoLivros[quantidadeLivros] = novoLivro;
			quantidadeLivros++;
			ordena();

		}
		
	}

	@Override
	public void removerLivro(int codigo) {
		for(int i = 0; i < quantidadeLivros; i++){
			if(colecaoLivros[i].codigo == codigo){
				colecaoLivros[i] = null;
				for(int j = i; j <= quantidadeLivros; j++){
					colecaoLivros[j] = colecaoLivros[j+1];
				}
				colecaoLivros[quantidadeLivros] = null;
				quantidadeLivros--;
				ordena();
			}
		}
		
	}

	@Override
	public String listarLivros(String editora) {
		String lista = "";
		for(int i = 0; i < quantidadeLivros; i++){
			if(colecaoLivros[i].editora.equals(editora) == true){
				lista += colecaoLivros[i].titulo + " - R$" + colecaoLivros[i].preco + "\n";
			}
		}
		return lista;
	}
	
	private void ordena(){
		CadastroDeLivros aux = new CadastroDeLivros();
		
		for(int i = 0; i < quantidadeLivros; i++){
			for(int j = 0; j < quantidadeLivros; j++){
				if(colecaoLivros[i].codigo < colecaoLivros[j].codigo){
					aux = colecaoLivros[i];
					colecaoLivros[i] = colecaoLivros[j];
					colecaoLivros[j] = aux;
					aux = null;
				}
			}
		}
	}

}
