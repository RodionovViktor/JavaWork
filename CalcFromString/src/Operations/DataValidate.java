package Operations;

import Data.DataCalc;
import Data.DataStorage;

public class DataValidate {
	// проверка на соответствие 
		
	String inputData;
	int posOperation;
	char[] chrArray;
	
	public DataValidate() {
		
	}
	
	// проверка на соответствие арифм оператор
	boolean validateOperation(){
		boolean result =false;
		// в выражении должно быть не более 5-ти символов
			// по условию задачи т.к. диапазон 1-10 и один оператор т.е. 'XXOXX' 
			if (inputData.length()<6) {
				
				chrArray=inputData.toCharArray();
				int countOperation=0;
				posOperation=0;		
				
				char[] chrTrue=DataStorage.strTrue.toCharArray();
				
 				// проверка выражения на соответствие арифм операции
				for(int i=0;i<chrArray.length;i++) {
					
					if (DataStorage.strTrue.indexOf(chrArray[i])>-1) {
						countOperation++;
						posOperation=i; // запоминаем положение знака арифметической операции
					}
					
						
					if (DataStorage.strFalse.indexOf(chrArray[i])>-1) {
						countOperation=100;
						break;
					}
					
				}
					
			   result= (countOperation==1 && posOperation<3 && posOperation>0);	
		     }
			
		return result;	
	}
	
	public boolean validateData(DataCalc dataCalc) {
			
		int a=0;
		int b=0;
		
		
		inputData =dataCalc.inpDatGet().replaceAll(" ", ""); 
		
	    	boolean result=false;
			
				
				
				// проверка количества знаков арифметической операции
				// и положение оператора в строке
				result = validateOperation();
			
				// проверка на числа
				// а заодно и на размер вводимых чисел
				boolean arabianMasIndex =false; // признак соответствия одному множеству 
				boolean romeMasIndex =false; // признак соответствия одному множеству 
				if (result ) {
						
						
						
						// проверка на нахождение в разных множествах 
						for(int i=0; i<chrArray.length;i++) {
							
							if(i!=posOperation)	{
								 for(int j=0;j<DataStorage.numArabian.length;j++) {
								
									 if (Character.getNumericValue(chrArray[i])==DataStorage.numArabian[j]) {
									  arabianMasIndex=true;
								      }	
								 } 
								
								 if (DataStorage.strRome.indexOf(chrArray[i])>-1) {
									  romeMasIndex=true;
								 }
					        }
							
						 }	
								
						
				       // если признаки нахождения в разных множествах не равны
						    
							if(arabianMasIndex!=romeMasIndex) {
								// обработка арабских цифр 
								
								String aStr = inputData.substring(0,posOperation);
								String bStr = inputData.substring(posOperation+1,inputData.length());
								
								
							
								if (arabianMasIndex) {
								
									a=Integer.parseInt(aStr);
									b=Integer.parseInt(bStr);
								
								}else if (romeMasIndex) { // обработка римских чисел
									
								    	a=ConverterSystem.romeToArabic(aStr);
										b=ConverterSystem.romeToArabic(bStr);
										
									}
								}
								else {
								result = false;
								}
					}
							
				
							// проверка чисел на максимум /минимум
					if (a>DataStorage.maxNum || b>DataStorage.maxNum || 
							a<DataStorage.minNum || b<DataStorage.minNum) {
								result=false;
					}
					
				if (result) {
							
					dataCalc.aSet(a);
					dataCalc.bSet(b);
					dataCalc.sumbOperSet(chrArray[posOperation]);
					dataCalc.romeFlagSet(romeMasIndex);
				}
					
			 return result;
		}		
		
}
