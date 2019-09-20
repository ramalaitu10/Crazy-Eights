import java.util.Random;
import java.util.Scanner;

public class Deck{
	private String [] deck = new String[52];
	public Deck(){

	String[] suits = {"S","H","C","D"};

	String[] ranks = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
	this.deck = MakeDeck(suits,ranks);
	}
	public String[] MakeDeck(String[] suits,String[] ranks){
		int position = 0;
		String[] NewDeck = new String[52];
		for(String suit:suits){
			for(String rank:ranks){
				NewDeck[position]= rank + suit;
				position++;
			}
			
		}
		return NewDeck;
	}
	public static int menu(){
		Scanner input = new Scanner(System.in);
		int user = input.nextInt();
		if(user == 1){
			deal();
		}
		else if(user == 2){
			shuffle();
		}
		return 1;
	}
	public void players(){
		
	}
	public void display(){
	}
	public static void shuffle(){
	}
	public static void deal(){

	}
	public static void main(String args[]){

	}
}