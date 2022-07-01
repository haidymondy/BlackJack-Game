/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

public class Player {
 
    private String name;
    private int score;
    // player hand
    public Card cards [] =new Card[11];
    // hand iterator
    protected int card_sum=0;
    
    public void addcard (Card card) 
    {
        if(card_sum < 11)
        {
            cards[card_sum] = card;
            card_sum+=1;
            score = score+ card.getValue();
        }
    
    }
    
    
    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setScore(int score){
        this.score=score;
    }
    public int getScore() {
        return score;
    }
    public void update_my_hand()
    {
        
    }
    
    //    if(score="21"){
// blackjack ;   } 
//    
//  boolean win = true;  

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
    
    
    
}
