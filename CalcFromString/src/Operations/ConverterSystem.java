package Operations;

import Data.DataStorage; 

public  class ConverterSystem {
	
		// ��� �������������� ������� ����� � ��������
 public static int romeToArabic(String strArg) {
			int result=0;
			
			for(int i=0;i<DataStorage.numRome.length;i++) {
				
				if(DataStorage.numRome[i].equalsIgnoreCase(strArg)) {
					result=DataStorage.numArabian[i];
					
					break;
				}
			
		    }
		return result;
  }

 
 // TODO: �������� �������������� � ��������� ����������� � ��������� � �������
 public static String arabicToRomeExt(int intArg) {
	 String result="";
	 String resTmp=String.valueOf(intArg);	
	 char[] charArray=resTmp.toCharArray();
	 
	 // ���������������� ��������������
	    int lengtStr=resTmp.length();
	 	for(int i=0;i<lengtStr;i++) {
	 
	 		String strVal=String.valueOf(charArray[i]);
	 		
	 		// ��������� ���������� ����� �� ���� ������ 
	 		for(int j=i+1;j<lengtStr;j++) {
	 			strVal+='0';
	 		}
	 		
	 		// ��������� � ������� � �������� � ����������
	 		int intVal=Integer.parseInt(strVal);
	 		strVal=arabicToRome(intVal);
	 		result+=strVal;
	 	}
	 		
	 		
	 return result;
 }
 
 static String arabicToRome(int intArg) {
		String result="";
		
		for(int i=0;i<DataStorage.numArabian.length;i++) {
			
			if(DataStorage.numArabian[i]==intArg) {
				result+=DataStorage.numRome[i];
			}
		
	    }
		
	return result;
}

 
}
