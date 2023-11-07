import java.util.Random;
import java.util.Scanner;

public class DiceGame {
	
	//multi-dimensional array using brackets
	private static String[][] language;
	private static int lang = -1;

	public static void main(String[] args) {
		int die1;
		int die2;
		String[] playerChoices;
		language = langInit();
		String langChoice = getInput("Select a langauge:\n[0]English\n[1]Hawaiian Pidgen");
		lang = Integer.parseInt(langChoice);//this would possibly lead to a convention error if user enters something else
		die1 = roll();
		die2 = roll();
		String choice;
		choice = getInput(language[lang][0]);
		choice = choice.toLowerCase();
		int count = 0;
		String playerCount = getInput(language[lang][1]);
		count = Integer.parseInt(playerCount);
		playerChoices = new String[count];
		while(choice.equals(language[lang][2])) {
			
			for(int c= 0; c < count; c++) {
			playerChoices[c] = getInput(language[lang][3]+(c+1)+language[lang][4]);
			
			}
			System.out.println(language[lang][5]+die1+language[lang][6]+die2);
			//Start a new loop here.
			for(int c=0; c<count;c++) {
				if(didIWin(die1,die2,playerChoices[c]))
				{
					System.out.println(language[lang][3]+(c+1)+language[lang][7]);
				}else
				{
					System.out.println(language[lang][3]+(c+1)+language[lang][8]);
				}
			}
			
			choice = getInput("Do you want to play?\nYes\nNo");
			choice = choice.toLowerCase();
			die1 = roll();
			die2 = roll();
		}
	}
	private static boolean didIWin(int die1, int die2, String choice)
	{
		if((die1 + die2)%2==0 && choice.equals(language[lang][10])) {
			return true;
		}
		if((die1 + die2)%2==1 && choice.equals(language[lang][11])) {
			return false;
		}
		return false;
	}
	
	private static String[][] langInit() {
		//array of array
		String[][] temp = new String[][] {
			//floor 0: English
			{
				"Do you want to play?\nYes\nNo","How many players are there?","yes",
				"Player ",": Even\nOdd","Die 1: ",
				"\nDie 2: "," wins!"," loses!",
				"Do you want to play?\nYes\nNo","even","odd"
			},
			//floor 1: Hawaiian Pidgen
			{
				"Like try?\nYessah\nNo need","How many guys get?","yessah",
				"Brahda ",": Even\nOdd","1 Dice: ",
				"\n2 Dice: "," winnah!"," nevah win!",
				"Like try again?\nYes\nNo","even","odd"
			}
		};
		return temp;
	}
	
	private static int roll()
	{
		return roll(6,1);
	}
	private static int roll(int sides,int start) {
		Random roller = new Random();
		return roller.nextInt(sides)+start;
	}
	private static String getInput(String text) {
		Scanner input = new Scanner(System.in);
		String choice = "";
		try 
		{
			System.out.println(text);
			choice = input.nextLine();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return choice;
	}
	
	private static boolean isInputInteger(String input) {
		boolean isAnInteger = true;
		for(int c = 0; c < input.length();c++) {
			char letter = input.charAt(c);
			//'-' is 45 '0 - 9' 48 - 57
			if(c!=0 &&!(letter >= 48 && letter<= 57))
			{
				isAnInteger = false;
			}else if(letter != 45 && !(letter >= 48 && letter <= 57))
			{
				isAnInteger = false;
			}
		}
		return isAnInteger;
	}
}
