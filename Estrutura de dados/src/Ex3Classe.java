
public class Ex3Classe implements Ex3Interface{

	@Override
	public boolean igualdade(double a, double b, double c, double d) {
		if(a==c && b==d){
			return true;
		}
		return false;
	}

	@Override
	public double[] adicao(double a, double b, double c, double d) {
		double[] complexo = new double[2];
		complexo[0] = a+c;
		complexo[1] = b+d;
		return (complexo);
	}

	@Override
	public double[] multiplicacao(double a, double b, double c, double d) {
		double[] complexo = new double[2];
		complexo[0] = a*c-b*d;
		complexo[1] = a*d+b*c;
		return (complexo);
	}


}
