package Data;
import java.lang.System;
import java.util.Arrays;

import Operations.ConverterSystem;
import Operations.*;

// ����������:
// ������� �������� ������
// ��������� ������

public class DataCalc {

	// ���������
	int A;
	int B;
	char sumbolOperation; // �������
	String inputData; //�������� ������
	boolean RomeFlag;// ������� ����, ��� ���� �������
	
	public void aSet(int iArg) {
		A=iArg;
	}
	
	public int aGet() {
		return A;
	}
	
	public void bSet(int iArg) {
		B=iArg;
	}
	
	public int bGet() {
		return B;
	}
	

	public void sumbOperSet(char cArg) {
		sumbolOperation=cArg;
	}
	
	public char sumbOperGet() {
		return sumbolOperation;
	}
	
	public void inpDatSet(String sArg) {
		inputData=sArg;
	}
	
	public String inpDatGet() {
		return inputData;
	}
	
	public void romeFlagSet(boolean bArg) {
		RomeFlag=bArg;
	} 
	
	public boolean romeFlagGet() {
		return RomeFlag;
	}
}
