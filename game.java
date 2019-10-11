import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class game{
	private ArrayList<Card> drawPile;
	private ArrayList<Card> Discard;
	private ArrayList<Player> playerList;
	private Deck D;
	private Scanner in;
	private Player player;
	
	public game(){
		D = new Deck();
		D.Shuffle();
		//D.getCard(1);
		drawPile = new ArrayList<Card>(12);
		Discard = new ArrayList<Card>(12);
		this.drawPile.addAll(D.serve(51));
		in = new Scanner(System.in);
		playe();
		
	}
	//playing the game
	public void playe(){
		System.out.println("How many players? ");
		int x = in.nextInt();
		while (x > 4 || x < 2) {
			System.err.println("How many players");
			x = in.nextInt();
		}
		this.playerList = new ArrayList<Player>(x);

		for (int i = 0; i < x; i++) {
			givePlayers();
			
		}
		
		player = getPlayer(0);
		Discard.add(D.serve(1).get(0));
		while (!isDone()) {
			//System.out.println("It works!!!");
			Playgame(player);
			player = nextPlayer(player);
		}
		System.out.println(player +" Won!!!");
	
	}
	//checks if the game is done
	public boolean isDone(){
		for (int i = 0; i < playerList.size(); i++) {
			if (getPlayer(i).getHand().size()==0) {
				return true;
			}
		}
		return false;
	}
	//reshuffle a deck
	public void reshuffle(){
		this.drawPile.addAll(Discard);
		Deck n = new Deck(this.drawPile);
		n.Shuffle();
	}
	//create players 
	public void createPlayers(Player player){
		//System.out.println(player.getName());
		this.playerList.add(player);
	}
	//enter the player names
	public String playerName(){
		System.out.println("Enter player name: ");
		String player = in.next();
		
		while (player == "") {
			player = in.nextLine();
		}
		return player;
  
	}
	//get the player by index
	public Player getPlayer(int num){
		return playerList.get(num);
	}
	//player plays
	public void Playgame(Player player){
		
		System.out.println("\nIts " + player.getName()+"'s turn\n");
		System.out.println("Discard card is: "+this.Discard.get(this.Discard.size()-1));
		
		System.out.println("\nThis is your hand!!");
		
		for(int i =0;i<player.getHand().size();i++){
			System.out.println(i + " = " + player.getHand().get(i));
		}
		System.out.println("Select Card! or 20 if you don't have it");
		
		int x = in.nextInt();
		if(drawPile.size()==0){
				reshuffle();
				
			}
		while(x >= player.getHand().size()){
			
			player.getHand().add(drawPile.get(0));
			this.drawPile.remove(drawPile.get(0));
			
			Playgame(nextPlayer(player));
		}
		
		if(cardMatches(this.Discard.get(this.Discard.size()-1),player.getHand().get(x))){
			
			System.out.println(this.Discard.get(this.Discard.size()-1)+ " M in!!! "+ player.getHand().get(x));
			this.Discard.add(player.getHand().get(x));
			Card d = player.getHand().get(x);
			player.getHand().remove(player.getHand().get(x));
			//Suppose to skip a player
			
			if(d.getRank().equals("7") && !isDone()){
				this.player = nextPlayer(player);
			}
			//suppose to choose a suit
			else if(d.getRank().equals("8") && !isDone()){
				System.out.println("Choose suit: ");
			
			}
			//supposed to reverse
			else if(d.getRank().equals("J") && !isDone()){
				int y = playerList.indexOf(player);
				if(y >= 1){
					Playgame(playerList.get(y-1));
				}
				else{
					Playgame(playerList.get(playerList.size()-1));
				}
			
			}
		}
	
	}
	public boolean cardMatches(Card discard,Card that) 
	{
		if (discard.getSuite().equals(that.getSuite())) 
		{
			return true;
		}
		if (discard.getRank().equals(that.getRank()))
		{
			return true;
		}
		if (that.getRank().equals("8")) 
		{
			return true;
		}
		return false;
	}
	
	//get the next playing player
	public Player nextPlayer(Player currentP){
		if(playerList.indexOf(currentP)+1< playerList.size()&& (!isDone())){
			return playerList.get(playerList.indexOf(currentP)+1);
		}
		if(isDone()){
			return currentP;
			
		}
		return playerList.get(0);
	}
	
	//deals cards to the hand of the players
	public void givePlayers(){
		player = new Player(playerName(),new Hand(new ArrayList<Card>(5)));
		player.draw(D.serve(5));
		createPlayers(player);
		
	}
}