/**
 * Esta classe implementa a interface {@link Complexo}.
 * 
 * @author Jacson Rodrigues
 * @version 03-2015
 */
public class ComplexoImplementacao implements Complexo{
    double re,im;
    
    /**
     * Construtor responsável por construir o número complexo.
     * @param x
     * @param y 
     */
    public ComplexoImplementacao (double x, double y) {
        re = x;
        im = y;
    }
    
    /**
     * Realiza a adição de dois número complexos.
     * @param a
     * @return número complexo resultante da adição de dois outros números complexos.
     */
    public Complexo adicao(Complexo a) {
        ComplexoImplementacao c = new ComplexoImplementacao(0,0);
        c.re = re + ((ComplexoImplementacao)a ).re;
        c.im = im + ((ComplexoImplementacao)a ).im;
        return c;
    }

    /**
     * Verifica se dois números complexos são iguais.
     * @param a
     * @return true se são iguais, false caso contrário.
     */
    public boolean igualdade(Complexo a) {
        if ((((ComplexoImplementacao)a ).re == re) &&
            (((ComplexoImplementacao)a ).im == im))
            return true;
        return false;
    }

    /**
     * Realiza a subtração de dois número complexos.
     * @param a
     * @return número complexo resultante da subtração de dois outros números complexos.
     */
    public Complexo subtracao(Complexo a) {
        ComplexoImplementacao c = new ComplexoImplementacao(0,0);
        c.re = re - ((ComplexoImplementacao)a ).re;
        c.im = im - ((ComplexoImplementacao)a ).im;
        return c;
    }
    
}
