  
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Deck{

	private ArrayList<Card> deck = new ArrayList<Card>();
	
   //constructors
   public Deck(ArrayList<Card> p){
	   //a deck created from a pile with lesser cards
	   this.deck = p;
	   
   }
   public Deck(){
      //accept cards
	  
	  Suite[] v = Suite.values(); //this gives an array of suite values
	  System.out.println(Arrays.toString(Suite.values()));
	  for (int j = 0; j < v.length; j++){
		  //System.out.println(suite);
		  for (int i = 0; i < 13; i++){
			  deck.add(new Card(Integer.toString(i+1), v[j]));
			  //this.deck.get(i).setSuite(Suite.values()[j]);
			  //System.out.println(deck.get(i));
		  }
		  
	  }
      //create deck using arrayList
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
   
   private String ShannonEntropy(){
      //return the Shannon entropy of the deck

      return "";
    
   }
   
   public Card topCard(){
      //returns the topmost card in the deck
      return this.deck.get(0);
   }
   
    public String toString(){
       //return a string form of the deck, i.e. a string telling what is contained in the deck
       String[] d = new String[this.deck.size()];
       
       for(int i = 0; i < d.length; i++){
          //return card string
		  d[i] = deck.get(i).toString();
          //System.out.println(c.toString());
       }
      
       return Arrays.toString(d);
    }
   
   public boolean equals(){
      //checks if two decks are equal
      return false;
    
   }
   
  /*  public ArrayList<Card> serve(int n){//n depends on the function of the serve
	   //serve stipulated number of cards to the calling object
	   ArrayList<Card> s;
	   for(int i = 0; i < n; i++){
		   s.add(this.deck.get(i));
		   this.deck.remove(i);
	   }
	   return s;
   } */
   
   
   
}