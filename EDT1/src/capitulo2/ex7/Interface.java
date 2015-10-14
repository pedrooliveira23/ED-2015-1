package capitulo2.ex7;

public interface Interface {
	public void incluirLivro(int codigo, 
			String titulo, 
			String editora, 
			int anoPublicacao, 
			double preco);
	public void removerLivro(int codigo);
	public String listarLivros(String editora);
}
