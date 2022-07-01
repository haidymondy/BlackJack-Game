

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;
import java.util.*; 
public class BlackJack 
{
    
      static Game game= new Game();
   
        public static void main(String[] args)
        {
            GUI gui = new GUI();

            game.Generate_card();
            int ind=0;
            /*while(ind<52)
            {
                System.out.println("card "+ind+" "+ game.cards[ind].getValue() );
                ind++;
            }*/
          //  game.players();
            game.set_players_information();
            
            gui.runGUI( game.cards, 
               game.player[0].cards, 
               game.player[1].cards,
               game.player[2].cards,
               game.player[3].cards);
            
            player_option(gui);
            
            // do a valid update
            //game.update_high_score();
            
            dealer(gui);
            //game.update_high_score();
            
            chk();
          
        }
         
        public static void  player_option(GUI gui)
        {
            Scanner sc=new Scanner(System.in);
         
           for(int i=0;i<3;i++)
            {
                String input="";
                boolean outage=true;
                
                while(!(input.toLowerCase().equals("stand"))) 
                {
                    System.out.println("player "+game.player[i].getName()+" hit or stand");
                    input= sc.next();
                    Card card=game.draw_random_card();
                    // added card and updated player score
                    if(input.toLowerCase().equals("hit")){
                        System.out.println("draw player "+game.player[i].getName()+ " score "+game.player[i].getScore());
                        game.player[i].addcard(card);
                        //game.player[i].setScore();
                        // don;t do anything
                        //game.update_high_score();
                        gui.updatePlayerHand(card,i);
                        System.out.println("draw player after "+game.player[i].getName()+ " score "+game.player[i].getScore());
                    }
                }
                //}
            }
        }
        
         public static void dealer(GUI gui)
        {
           
          //game.update_high_score();
          String dealer="win";
          int dealer_score=-5;         
          for(int i=0;i<3;i++)
            {
                int player_valid_score = game.player[i].getScore();
                if (player_valid_score>21)
                    player_valid_score=0;

                if(player_valid_score >=game.player[3].getScore())
                     dealer="lose";
                
                 if(player_valid_score>dealer_score)

                    dealer_score=player_valid_score ;
                 
            }
            if(dealer!="win")
            {
                Card card=new Card(1,2,3);
                while(dealer_score > game.player[3].getScore())
                {
                    card=game.draw_random_card();
                    game.player[3].addcard(card);
                    //game.player[3].setScore(dealer_score);
                    //game.update_high_score();
                    //gui.updatePlayerHand(card,3);
                    gui.updateDealerHand(card,game.cards);
                }
                //gui.updateDealerHand(card,game.cards);
            }else
                return;
        }

        public static void chk()
        {
            int highscore = -5;
            int player_id = -5;

            int[] ids =new int[4] ;
            int[] valid_scores_arr= new int[4];
            int high = -5;
            int winners=0;
            for(int i=0;i<4;i++)
            {
                ids[i]=0 ; valid_scores_arr[i]=0;

               int player_valid_score = game.player[i].getScore();
               if (player_valid_score>21)
                       player_valid_score=0;

                if(player_valid_score > high)
                   high=player_valid_score;

               valid_scores_arr[i]=player_valid_score; 
            }
            for(int i=0;i<4;i++)
            {
               if( valid_scores_arr[i] == high)
               {
                   winners+=1;
                   ids[i]=1;
               }
            }
            
         
         

            for(int i=0;i<4;i++)
            {
               int player_valid_score = game.player[i].getScore();
               System.out.println("player "+game.player[i].getName()+ " score "+player_valid_score);
               if (player_valid_score>21)
                       player_valid_score=0;

               // update_high_score -> player.setscore
               if(player_valid_score > highscore)
               {
                 highscore=player_valid_score;
                  player_id=i;
               }        
            }

            if((player_id>=0))
            {

                System.out.println("the winner is player "+game.player[player_id].getName()+ " score "+highscore);
                if(player_id!=3){
                    System.out.println("DEALER BUSTED");
                }
            }

            
         
         
         
        }
         
         
         
         
         
         
         
         
         
         }
        
        
        
        
        
        
        
        
        
        
        
        
        
        

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
//      Card[] deck = new Card[52];
//    
//    for(int i =0; i<4; i++){
//    
//        for(int j =0; j<; j++){
//            
//            for(int k =0; k<4; k++){
//                
//            }
//        }
//    }

    
    
    
    
    
    
    
    
