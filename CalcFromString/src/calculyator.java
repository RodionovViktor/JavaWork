import java.lang.System;
import java.util.Scanner;

import Data.DataCalc;
import Data.DataStorage;
import Operations.Ariphmetics;
import Operations.ConverterSystem;
import Operations.DataValidate;




public class calculyator {

	

	public static void main(String[] args) {
			
		System.out.println(DataStorage.AppnameStr);
		
		Scanner scanStr = new Scanner(System.in);
		
		String inStr = scanStr.nextLine();
		
		DataCalc dataCalc=new DataCalc();
		dataCalc.inpDatSet(inStr);
				
		DataValidate dataValidate= new DataValidate();
		boolean result=dataValidate.validateData(dataCalc);
	
		if (result) { // Если преобразование прошло успешно то находим результат
		
			String strRes =dataCalc.inpDatGet()+"=";
			int intRes=Ariphmetics.resGet(dataCalc);
			
			if (dataCalc.romeFlagGet()) {
				strRes+=ConverterSystem.arabicToRomeExt(intRes);
			}else {
				strRes+=intRes;
			}
			
			System.out.println(strRes);
		}else {
			System.out.println("Неправильные данные для рассчетов");
		}
		
		
		
	}

	
}
