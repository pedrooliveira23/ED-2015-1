
public class Ex5Classe implements Ex5Interface{

	@Override
	public int operacao1(double i, double j, double k) {
		if(i*i == j*j && i*i == k*k){
			return -1;
		}
		return 0;
	}

	@Override
	public double operacao2(double i, double j, double k) {
		if(i*j == k){
			return k;
		}
		if(j*k == i){
			return i;
		}
		if(j*i == -k){
			return -k;
		}
		if(k*j == -i){
			return -i;
		}
		if(i*k == -j){
			return -j;
		}
		return 0;
	}

	@Override
	public double operacao3(double i, double j, double k, double a, double b,
			double c, double d, double p, double q, double r, double s) {
		
		return ((a+b*i+c*j+d*k)*(p+q*i+r*j+s*k));
	}

}
