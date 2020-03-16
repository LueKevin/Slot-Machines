//********************************************************************************
//                                           **
// Date Written: 01/18/19                                                       **
// Purpose: Determine how many plays Aunt Vicky will get before she             **
// depletes her quarters.                                                       **
//********************************************************************************

import java.text.DecimalFormat;

public class QuarterSlots {
		
	public static void main(String args[]) {
		
		int quarterJar = 100; 
		int slotCounter = playSlots(quarterJar);

		System.out.println("Your total plays are " + slotCounter + ".");
	
	}
	
//Method 1
	public static int playSlots(int quarterJar){
		
		int slotMachine[] = {0, 0, 0};
		
		double totalMoney = quarterJar * 0.25;
		
		int slotCounter = -1;
		int onePayment = 25;
		int twoPayment = 75;
		int threePayment = 5;
		
		int onePlay = 35;
		int twoPlay = 100;
		int threePlay = 8;
		
		DecimalFormat newFormat = new DecimalFormat("0.00");
	
		while (quarterJar != 0) {
			quarterJar--;
			slotCounter++;
			
			switch(slotCounter % 3) {
			case 0: 
			slotMachine[slotCounter % 3]++;
			quarterJar += oneWin(slotMachine[0], onePlay, slotCounter, onePayment, quarterJar, totalMoney, newFormat);
			break;
			case 1: 
			slotMachine[slotCounter % 3]++;
			quarterJar += twoWin(slotMachine[1], twoPlay, slotCounter, twoPayment, quarterJar, totalMoney, newFormat);
			break;
			case 2: 
			slotMachine[slotCounter % 3]++;
			quarterJar += threeWin(slotMachine[2], threePlay, slotCounter, threePayment, quarterJar, totalMoney, newFormat);
			break; 
			} 
		} return slotCounter;
	} // End playSlots (Method 1)

//Method 2
	public static int oneWin(int slotMachine,int onePlay,int slotCounter,int onePayment,int quarterJar,double totalMoney,DecimalFormat newFormat) {
		if (slotMachine % onePlay == 0) {
			quarterJar += onePayment;
			totalMoney = quarterJar * 0.25;
			
			System.out.println("Congratulations! Machine 1 says you're a winner.");
			System.out.println("You win $" + onePayment * .25 + ".");
			System.out.println("You have " + quarterJar + " quarters.");
			System.out.println("In total, your money is equal to $" + newFormat.format(totalMoney) + ".\n");
			
			return onePayment;
		} else {
			return 0;
		}
		}// End oneWin (Method 2)
	
//Method 3
	public static int twoWin(int slotMachine,int twoPlay,int slotCounter,int twoPayment,int quarterJar,double totalMoney, DecimalFormat newFormat) {
		if (slotMachine % twoPlay == 0) {
			quarterJar += twoPayment;
			totalMoney = quarterJar * 0.25;
			
			System.out.println("Congratulations! Machine 2 says you're a winner.");
			System.out.println("You win $" + twoPayment * .25 + ".");
			System.out.println("You have " + quarterJar + " quarters.");
			System.out.println("In total, your money is equal to $" + newFormat.format(totalMoney) + ".\n");
			
			return twoPayment;
			} else {
				return 0;
			}
		} // End twoWin (Method 3)
	
//Method 4
	public static int threeWin(int slotMachine,int threePlay,int slotCounter,int threePayment,int quarterJar,double totalMoney, DecimalFormat newFormat) {
		if (slotMachine % threePlay == 0) {
			quarterJar += threePayment;
			totalMoney = quarterJar * 0.25;
			
			System.out.println("Congratulations! Machine 3 says you're a winner.");
			System.out.println("You win $" + threePayment * .25 + ".");
			System.out.println("You have " + quarterJar + " quarters.");
			System.out.println("In total, your money is equal to $" + newFormat.format(totalMoney) + ".\n");
			return threePayment;
			} else {
				return 0;
			}
				
	} // End threeWin (Method 4)


}
