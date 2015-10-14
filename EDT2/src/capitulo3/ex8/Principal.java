package capitulo3.ex8;

public class Principal {
	public static void main(String[] args) {
		LinkedLinearList polinomioA = new LinkedLinearList();
		LinkedLinearList polinomioB = new LinkedLinearList();
		LinkedLinearList polinomioC = new LinkedLinearList();
		LinkedLinearList polinomioD = new LinkedLinearList();
		Polinomios polinomio = new Polinomios();
		
		polinomioA.add(0, -2, 2);
		polinomioA.add(1, 5, 1);
		polinomioA.add(2, -2, 0);
		
		polinomioB.add(0, -3, 3);
		polinomioB.add(1, 2, 1);
		polinomioB.add(2, -1, 0);
		
		System.out.println("PolinomioA = " + polinomioA.toString());
		System.out.println("PolinomioB = " + polinomioB.toString());
		
		
		System.out.println("Soma = " + polinomio.soma(polinomioA, polinomioB).toString());
		
		
		polinomioC.add(0, 1, 1);
		polinomioC.add(1, -1, 0);
		polinomioD.add(0, 1, 2);
		polinomioD.add(1, 2, 1);
		polinomioD.add(2, -6, 0);
		
		System.out.println("\nPolinomioC = " + polinomioC.toString());
		System.out.println("PolinomioD = " + polinomioD.toString());
		
		System.out.println("Multiplicacao = " + polinomio.multiplicacao(polinomioC, polinomioD).toString());
	}

}
