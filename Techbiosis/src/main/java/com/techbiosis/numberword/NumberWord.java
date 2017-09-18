package com.techbiosis.numberword;

import java.util.Scanner;

public class NumberWord {
	
	public static final String HUNDRED = " HUNDRED ";
	public static final String EMPTY = "";
	public static String[] numberNameArray = new String[51];
	
	
	static {
		
		
		numberNameArray[1] = "ONE";
		numberNameArray[2] = "TWO";
		numberNameArray[3] = "THREE";
		numberNameArray[4] = "FOUR";
		numberNameArray[5] = "FIVE";
		numberNameArray[6] = "SIX";
		numberNameArray[7] = "SEVEN";
		numberNameArray[8] = "EIGHT";
		numberNameArray[9] = "NINE";
		numberNameArray[10] = "TEN";
		numberNameArray[11] = "ELEVEN";
		numberNameArray[12] = "TWELVE";
		numberNameArray[13] = "THIRTEEN";
		numberNameArray[14] = "FOURTEEN";
		numberNameArray[15] = "FIFTEEN";
		numberNameArray[16] = "SIXTEEN";
		numberNameArray[17] = "SEVENTEEN";
		numberNameArray[18] = "EIGHTTEEN";
		numberNameArray[19] = "NINETEEN";
		numberNameArray[20] = "TWENTY";
		//21-29 TWENTY <number at the unit's place>
		numberNameArray[30] = "THIRTY";
		//31-39 THIRTY <number at the unit's place>
		numberNameArray[40] = "FORTY";
		//41-49 FORTY <number at the unit's place>
		numberNameArray[50] = "FIFTY";
		//51-59 FIFTY <number at the unit's place>
		//60-99 <NUMBER AT TEN'S PLACE> + "TY" <number at the unit's place>
		
	}
	public static void main(String[] args){
		while(true){
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter the number : ");
			int input = sc.nextInt();
			System.out.println("Converting to words");	
			
			NumberWord n = new NumberWord();
			System.out.println(n.convertNumberToWord(input));
		}
	}
	
	public String convertNumberToWord(int input){
		if(input==1000000000){
			return "ONE BILLION";
		}
		
		return millionConversion(input).trim();
	}
	
	public String millionConversion(int input){
		if(input<1000000){
			return thousandsConversion(input);
		}
		if(input>=1000000 && input<1000000000){
			int millionDigits = input/1000000;
			int thousandDigits = input%1000000;
			return thousandsConversion(millionDigits)+" MILLION "+(thousandDigits>0?thousandsConversion(thousandDigits):EMPTY);
		}
		return "";
	}
	
	public String thousandsConversion(int input){
		if(input<1000){
			return hundredConversion(input);
		}
		if(input>=1000 && input<1000000){
			int thousandDigits = input/1000;
			int hundredDigits = input%1000;
			return hundredConversion(thousandDigits)+" THOUSAND "+(hundredDigits>0?hundredConversion(hundredDigits):EMPTY);
		}
		return "";
	}
	public String hundredConversion(int input){
		if(input<100){
			return tensUnitsConversion(input);
		}
		if(input>=100 && input<1000){
			int hundredsPlace = input/100;
			int tensUnitDigits = input%100;
			return getNumberWord(hundredsPlace)+HUNDRED+" "+(tensUnitDigits>0?tensUnitsConversion(tensUnitDigits):EMPTY);
			
		}
		return "";
	}
	public String tensUnitsConversion(int input){
		if(input<20){
			return getNumberWord(input);
		}
		if(input>19 && input<100){
			int tensPlace = input/10;
			int unitsPlace = input%10;
			String tensPlaceString = (getNumberWord(tensPlace*10)==null)?getNumberWord(tensPlace)+"TY":getNumberWord(tensPlace*10);
			return tensPlaceString+" "+getNumberWord(unitsPlace);
		}
		return "";
	}
	public String getNumberWord(int input){
		//return numberWordMap.get(input);
		if(input<=50){
			return numberNameArray[input];
		}else{
			return null;
		}
		
	}
}

