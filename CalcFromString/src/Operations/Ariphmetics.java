package Operations;

import Data.DataCalc;

public class Ariphmetics {
	// для вычислений на основе передаваемого оператора
	
	public static int resGet(DataCalc dataCalc) {
		int a = dataCalc.aGet();
		int b = dataCalc.bGet();
		char sOper = dataCalc.sumbOperGet();
		int result=0;
		
		switch (sOper) {
		case '*':
			result = a*b;
			
			break;
		case '+':
			result = a+b;
			break;
		case '-':
			result = a-b;
			break;
		case '/':
			result = a/b;
			break;

		default:
			break;
		}
		
		return result;
	}

}
