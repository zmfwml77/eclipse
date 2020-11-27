package test.main;

import test.mypac.Calculator;

//여기는 이해 안 해도 됨!
//람다
public class MainClass06 {
	public static void main(String[] args) {
		Calculator add=(double a, double b)->{
			return a+b;
		};
		//위 코드는 간략히 표현하면 아래와 같다.
		Calculator add2=(a,b)->a+b;	
		Calculator sub=(a,b)->a-b;
		Calculator multi=(a,b)->a*b;
		Calculator divide=(a,b)->a/b;
		
		useCalculator(add);
		useCalculator(sub);
		useCalculator(multi);
		useCalculator(divide);
		useCalculator((a,b)->a/b);
	}
	public static void useCalculator(Calculator cal) {
		double result=cal.exec(10, 20);
		System.out.println("result :" + result);
	}
}
