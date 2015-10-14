package testes;

import listalinear.vetor.Lista;

public class TesteListaLinearVetor {

	public static void main(String[] args) {
		Lista lista = new Lista(10);
		
		System.out.println(lista.isEmpty());
		
		lista.add(0);
		lista.add(1);
		lista.add(2);
		lista.add(0);
		lista.add(1);
		lista.add(2);
		lista.add(0);
		lista.add(1);
		lista.add(1);
		lista.add(0, 3);
		
		System.out.println(lista.toString());
		
		lista.remove(0);
		
		System.out.println(lista.toString());
		
		System.out.println(lista.indexOf(2));
		
		System.out.println(lista.get(2));
		
		System.out.println(lista.get(10));
		
		System.out.println(lista.isEmpty());

	}

}
