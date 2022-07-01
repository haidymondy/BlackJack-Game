/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blackjack;
import java.util.*; 
import java.util.Random; 
public class Game 
{
    public Player[] player=new Player[4];
    Card []cards=new Card[52];
    
   // intialization of players  
    public void players()
    {
      Scanner scn= new Scanner(System.in); 
        // score
        int intial_score =0;
        for(int i =0; i<3; i++)
        {
            // name 
            System.out.print("Enter player "+(i+1)+" name ");  
            String n= scn.nextLine();           
            player[i]=new Player(n,intial_score);                 
        }                
    } 
    
public void Generate_card()
    {
            //suit
            for(int j =0; j<4; j++)
            {  
                //rank , value 
                for(int k =0; k<=12; k++)
                {
                    if(k>=9)
                    {
                        cards[j*13 + k]=new Card(j,k,10);
                    }
                    else{
                    cards[j*13 + k]=new Card(j,k,k+1);
                    }
                }
            }
    }
       

// delete it S
 public int update_high_score()
 {
     int newscore=0;
     int score=0;
     int player_num=0;
      for(int i =0; i<3; i++)
        {
           score = player[i].getScore();
           
           if(score<=21){
               if(score>newscore){
                   newscore=score;
                   player_num=i;
               }
                
           }
              else
                    {
                       newscore=0;
                    }
        }
      return newscore;
    }
 
    public Card draw_random_card()
    {
        Random rand=new Random();
        Card card=null;
        int randomchoice=0;
   
      while( card ==null)
    {
       randomchoice = rand.nextInt(51); 
       card = cards[randomchoice];
       // remove the card 
       
       
       // null if condition is recomended
       cards[randomchoice] =null;
    }
       return card;
    }
    
    // draw 
    public void set_players_information ()
    {
        players();
        player[3]=new Player("dealer",0);
        for(int num=0;num<4;num++)
        {
            player[num].addcard(draw_random_card());
            player[num].addcard(draw_random_card());
        }
    }
    
        
}



