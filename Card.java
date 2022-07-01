/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

public class Card {

   final private int rank;
   final private int value;
   final private int suit;
   
   
    public Card( int s,int r, int v) {
        
        this.rank = r;
        this.value = v;
        this.suit = s;
    }
        
    // Card copy constructor 
   Card(Card card){
   this.rank=card.rank;
   this.value=card.value;
   this.suit=card.suit;
   }
    
   // getters
    public int getRank() {
        return rank;
    }

    public int getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }
    
   
}
