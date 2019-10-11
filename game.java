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
		Discard = new ArrayList<Card>(12);
		//this.drawPile.addAll(D);
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
		Discard.add(this.drawPile.get(0));
		while (!isDone()) {
			//System.out.println("It works!!!");
			Playgame(player);
			player = nextPlayer(player);
		}
	
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
		System.out.println("Its " + player.getName()+"'s turn");
		System.out.println("Select Card!");
		int x = in.nextInt();
		for(int i = 0;i< player.getHand().size();i++){
			System.out.println("M in!!! " + Discard.get(0));
		}
	}
	
	//get the next playing player
	public Player nextPlayer(Player currentP){
		if(playerList.indexOf(currentP)+1< playerList.size()){
			return playerList.get(playerList.indexOf(currentP)+1);
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
