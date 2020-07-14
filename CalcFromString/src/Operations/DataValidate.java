package Operations;

import Data.DataCalc;
import Data.DataStorage;

public class DataValidate {
	// �������� �� ������������ 
		
	String inputData;
	int posOperation;
	char[] chrArray;
	
	public DataValidate() {
		
	}
	
	// �������� �� ������������ ����� ��������
	boolean validateOperation(){
		boolean result =false;
		// � ��������� ������ ���� �� ����� 5-�� ��������
			// �� ������� ������ �.�. �������� 1-10 � ���� �������� �.�. 'XXOXX' 
			if (inputData.length()<6) {
				
				chrArray=inputData.toCharArray();
				int countOperation=0;
				posOperation=0;		
				
				char[] chrTrue=DataStorage.strTrue.toCharArray();
				
 				// �������� ��������� �� ������������ ����� ��������
				for(int i=0;i<chrArray.length;i++) {
					
					if (DataStorage.strTrue.indexOf(chrArray[i])>-1) {
						countOperation++;
						posOperation=i; // ���������� ��������� ����� �������������� ��������
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
			
				
				
				// �������� ���������� ������ �������������� ��������
				// � ��������� ��������� � ������
				result = validateOperation();
			
				// �������� �� �����
				// � ������ � �� ������ �������� �����
				boolean arabianMasIndex =false; // ������� ������������ ������ ��������� 
				boolean romeMasIndex =false; // ������� ������������ ������ ��������� 
				if (result ) {
						
						
						
						// �������� �� ���������� � ������ ���������� 
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
								
						
				       // ���� �������� ���������� � ������ ���������� �� �����
						    
							if(arabianMasIndex!=romeMasIndex) {
								// ��������� �������� ���� 
								
								String aStr = inputData.substring(0,posOperation);
								String bStr = inputData.substring(posOperation+1,inputData.length());
								
								
							
								if (arabianMasIndex) {
								
									a=Integer.parseInt(aStr);
									b=Integer.parseInt(bStr);
								
								}else if (romeMasIndex) { // ��������� ������� �����
									
								    	a=ConverterSystem.romeToArabic(aStr);
										b=ConverterSystem.romeToArabic(bStr);
										
									}
								}
								else {
								result = false;
								}
					}
							
				
							// �������� ����� �� �������� /�������
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
