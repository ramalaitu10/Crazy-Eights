import java.util.Random;
import java.util.Arrays;
public class Deck{

   private Card[] deck;
   
   //constructors
   public Deck(){
	   //make 52 new cards, all 13 ranks for each suite
		this.deck = new Card[52];
	  
		int index = 52;
		String[] s = {"Hearts","Spades","Clubs","Diamonds"};
		String[] r = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		int i = 0;
		Card c = new Card();
		for (String st : s){
			//assign suite
			c.setSuite(st);
			for(String rnk : r){
			//assign rank
				c.setRank(rnk);
				this.deck[i] =  new Card(c.getSuite(), c.getRank());
				System.out.println(this.deck[i].toString());
				i++;
		 }
		 
	  }
      
   }
   //methods
   public void Shuffle(){
      //shuffle this deck
       
		Random random = new Random();
		int x = 20 + random.nextInt(10);
		int y = 52 - x;
		Card[] first = new Card[x];
		Card[] second = new Card[y];
		
		//making the two arrays for shuffling
		for(int j = 0;j < x;j++){
			first[j] = this.deck[j];
		}
		
		for(int k = 0;k < y;k++){
			second[k] = this.deck[k+x];
		}
		
		int i = 0,m = 0,n = 0;
		
		//shuffling starts here
		while(i <52){
			
			int p = random.nextInt(2)+1;
			
			if(p == 1 && m<first.length){
				this.deck[i] = first[m];
				//System.out.println(this.deck[i].toString());
				i++;
				m++;
			}
			
			else if(p==2 && n< second.length){
				this.deck[i] = second[n];
				//System.out.println(this.deck[i].toString());
				i++;
				n++;
			}
		}

	}
   
   public String ShannonEntropy(){
      //return the Shannon entropy of the deck

      return "";
    
   }
   
   public Card topCard(){
      //returns the topmost card in the deck
      return new Card();
   }
   
    /* public String[] toString(){
       //return a string form of the deck, i.e. a string telling what is contained in the deck
       String[] d = new String[deck.length];
       int i = 0;
       
       for(Card c : deck){
          //return card string
          d[i] = c.toString();
          i++;
       }
      
       return d;
    } */
   
   public boolean equals(){
      //checks if two decks are equal
      return false;
    
   }
   
}