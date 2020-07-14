package Data;


public class DataStorage {
	// максимум и минимум вводимых значений
	public static String AppnameStr="SuperCalc";
	public static 	int maxNum=10;
	public static	int minNum =1;
		
		// матрица соответствия
	public static	int[] numArabian =  {1,2,3,4,5,6,7,8,9,10,20,30,40,50,60,70,80,90,100};
	public static	String[] numRome = {"I","II","III","IV","V","VI","VII","VIII","IX","X","XX","XXX","XL","L","LX","LXX","LXXX","XC","C"};
		
	public static	String strTrue="*+-/"; // арифметические операции
	public static	String strFalse=""; // запрещенные символы
	public static	String strRome="IVX"; // для анализа строки на предмет римских цифр
	 
}
