package capitulo2.ex4;

public class SecoMolhadoTeste {
	public static final int SECO = 0;
	public static final int MOLHADO = 1;
	
	public static void main(String[] args) {
		SecoMolhadoImplementacao x = new SecoMolhadoImplementacao(SECO);
		
		System.out.println(x.adicao(SECO));
		System.out.println(x.subtracao(SECO));
		

	}

}
