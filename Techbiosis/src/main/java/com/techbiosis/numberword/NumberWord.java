package com.techbiosis.numberword;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NumberWord {
	
	public static Map<Integer,String> numberWordMap = new HashMap<>();
	
	public static final String HUNDRED = " HUNDRED ";
	public static final String EMPTY = "";
	
	static {
		numberWordMap.put(1, "ONE");
		numberWordMap.put(2, "TWO");
		numberWordMap.put(3, "THREE");
		numberWordMap.put(4, "FOUR");
		numberWordMap.put(5, "FIVE");
		numberWordMap.put(6, "SIX");
		numberWordMap.put(7, "SEVEN");
		numberWordMap.put(8, "EIGHT");
		numberWordMap.put(9, "NINE");
		numberWordMap.put(10, "TEN");
		numberWordMap.put(11, "ELEVEN");
		numberWordMap.put(12, "TWELVE");
		numberWordMap.put(13, "THIRTEEN");
		numberWordMap.put(14, "FOURTEEN");
		numberWordMap.put(15, "FIFTEEN");
		numberWordMap.put(16, "SIXTEEN");
		numberWordMap.put(17, "SEVENTEEN");
		numberWordMap.put(18, "EIGHTTEEN");
		numberWordMap.put(19, "NINETEEN");
		numberWordMap.put(20, "TWENTY");
		//21-29 TWENTY <number at the unit's place>
		numberWordMap.put(30, "THIRTY");
		//31-39 THIRTY <number at the unit's place>
		numberWordMap.put(40, "FORTY");
		//41-49 FORTY <number at the unit's place>
		numberWordMap.put(50, "FIFTY");
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
		
		return millionConversion(input);
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
		return numberWordMap.get(input);
	}
}

