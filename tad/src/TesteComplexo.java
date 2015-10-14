/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jacson
 */
public class TesteComplexo {
   public static void main(String[] args) {
        ComplexoImplementacao c= new ComplexoImplementacao(1 ,2);
        ComplexoImplementacao d= new ComplexoImplementacao(3, 4);
        ComplexoImplementacao e = (ComplexoImplementacao) c.adicao(d);
        System.out.println("Resultado da adicao = " + e.re +" + "+ e.im+"i");
        boolean verificaIgualdade = c.igualdade(d);
        System.out.println("Resultado da verificacao igualdade = " + verificaIgualdade);
        ComplexoImplementacao f = (ComplexoImplementacao) c.subtracao(d);
        System.out.println("Resultado da adicao = " + f.re +" + "+ f.im+"i");
   } 
}
