
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class AIPlayer extends GomokuPlayer {
    //set the color of your enemy to white, unless you are white
        Color enemy = (me == Color.white) ? Color.black : Color.white;
    //needs to OVERRIDE the chooseMove method below 
    public Move chooseMove(Color[][] board, Color me) 
    {
    }

    public int evalFunct2 (Color[][] board, Color me){
       //create counter variables for the different patterns
       int score = 0;
       Color enemy = (me == Color.white) ? Color.black : Color.white;
       int nopen3 = 0;
       int ncap3 = 0;
       int ncons5 = 0;
       /* 6 moves
       int nopen4 = 0;
       int ncap4 = 0;
       */
       int ngap3 = 0;
       int ngap4 = 0;
       int ngap22 = 0;
       ArrayList <Color> horSets = new ArrayList<>();
       ArrayList <Color> vertSets = new ArrayList<>();
       ArrayList <Color> diag1Sets = new ArrayList<>();
       ArrayList <Color> diag2Sets = new ArrayList<>();
       //start search by horizontal sets of 5
       for (int row = 0; row < 8; row++){
           for (int col = 0; col < 4; col++){
               for (int coldiff = 0; coldiff < 5; coldiff++){   //adding the elements in backwards
                   horSets.add(board[row][col+coldiff]);  
               }
                   if(horSets.get(0)==null && horSets.get(1)==me && horSets.get(2)==me && horSets.get(3)==me && horSets.get(4)==null){
                        nopen3++;
                    }
                   else if(horSets.get(0)==null && horSets.get(1)==me && horSets.get(2)==me && horSets.get(3)==me && horSets.get(4)==enemy){
                       ncap3++;
                   }
                   else if(horSets.get(0)==enemy && horSets.get(1)==me && horSets.get(2)==me && horSets.get(3)==me && horSets.get(4)==null){
                       ncap3++;
                   }
                   else if(horSets.get(0)==me && horSets.get(1)==me && horSets.get(2)==me && horSets.get(3)==me && horSets.get(4)==me){
                       ncons5++;
                   }
                   else if(horSets.get(0)==null && horSets.get(1)==me && horSets.get(2)==me && horSets.get(3)==null && horSets.get(4)==me){
                       ngap3++;
                   }
                   else if(horSets.get(0)==me && horSets.get(1)==null && horSets.get(2)==me && horSets.get(3)==me && horSets.get(4)==null){
                       ngap3++;
                   }
                   else if(horSets.get(0)==me && horSets.get(1)==me && horSets.get(2)==me && horSets.get(3)==null && horSets.get(4)==me){
                       ngap4++;
                   }
                   else if(horSets.get(0)==me && horSets.get(1)==null && horSets.get(2)==me && horSets.get(3)==me && horSets.get(4)==me){
                       ngap4++;
                   }
                   else if(horSets.get(0)==me && horSets.get(1)==me && horSets.get(2)==null && horSets.get(3)==me && horSets.get(4)==me){
                       ngap22++;
                   }
               }
           }
       //Search for vertical sets
       for(int col = 0; col < 8; col++){
           for(int row = 0; row < 4; row++){
               for(int rowdiff = 0; rowdiff < 5; rowdiff++){
                   vertSets.add(board[row+rowdiff][col]); 
               }
                   if(vertSets.get(0)==null && vertSets.get(1)==me && vertSets.get(2)==me && vertSets.get(3)==me && vertSets.get(4)==null){
                        nopen3++;
                    }
                   else if(vertSets.get(0)==null && vertSets.get(1)==me && vertSets.get(2)==me && vertSets.get(3)==me && vertSets.get(4)==enemy){
                       ncap3++;
                   }
                   else if(vertSets.get(0)==enemy && vertSets.get(1)==me && vertSets.get(2)==me && vertSets.get(3)==me && vertSets.get(4)==null){
                       ncap3++;
                   }
                   else if(vertSets.get(0)==me && vertSets.get(1)==me && vertSets.get(2)==me && vertSets.get(3)==me && vertSets.get(4)==me){
                       ncons5++;
                   }
                   else if(vertSets.get(0)==null && vertSets.get(1)==me && vertSets.get(2)==me && vertSets.get(3)==null && vertSets.get(4)==me){
                       ngap3++;
                   }
                   else if(vertSets.get(0)==me && vertSets.get(1)==null && vertSets.get(2)==me && vertSets.get(3)==me && vertSets.get(4)==null){
                       ngap3++;
                   }
                   else if(vertSets.get(0)==me && vertSets.get(1)==me && vertSets.get(2)==me && vertSets.get(3)==null && vertSets.get(4)==me){
                       ngap4++;
                   }
                   else if(vertSets.get(0)==me && vertSets.get(1)==null && vertSets.get(2)==me && vertSets.get(3)==me && vertSets.get(4)==me){
                       ngap4++;
                   }
                   else if(vertSets.get(0)==me && vertSets.get(1)==me && vertSets.get(2)==null && vertSets.get(3)==me && vertSets.get(4)==me){
                       ngap22++;
                   }
           }
       }
     //Search for diagonal left to right 
     for (int col = 0; col < 4; col++){
         for (int row = 0; row < 4; row++){
             for (int didiff = 0; didiff < 5; didiff++){
                 diag1Sets.add(board[row+didiff][col+didiff]);
             }
                   if(diag1Sets.get(0)==null && diag1Sets.get(1)==me && diag1Sets.get(2)==me && diag1Sets.get(3)==me && diag1Sets.get(4)==null){
                        nopen3++;
                    }
                   else if(diag1Sets.get(0)==null && diag1Sets.get(1)==me && diag1Sets.get(2)==me && diag1Sets.get(3)==me && diag1Sets.get(4)==enemy){
                       ncap3++;
                   }
                   else if(diag1Sets.get(0)==enemy && diag1Sets.get(1)==me && diag1Sets.get(2)==me && diag1Sets.get(3)==me && diag1Sets.get(4)==null){
                       ncap3++;
                   }
                   else if(diag1Sets.get(0)==me && diag1Sets.get(1)==me && diag1Sets.get(2)==me && diag1Sets.get(3)==me && diag1Sets.get(4)==me){
                       ncons5++;
                   }
                   else if(diag1Sets.get(0)==null && diag1Sets.get(1)==me && diag1Sets.get(2)==me && diag1Sets.get(3)==null && diag1Sets.get(4)==me){
                       ngap3++;
                   }
                   else if(diag1Sets.get(0)==me && diag1Sets.get(1)==null && diag1Sets.get(2)==me && diag1Sets.get(3)==me && diag1Sets.get(4)==null){
                       ngap3++;
                   }
                   else if(diag1Sets.get(0)==me && diag1Sets.get(1)==me && diag1Sets.get(2)==me && diag1Sets.get(3)==null && diag1Sets.get(4)==me){
                       ngap4++;
                   }
                   else if(diag1Sets.get(0)==me && diag1Sets.get(1)==null && diag1Sets.get(2)==me && diag1Sets.get(3)==me && diag1Sets.get(4)==me){
                       ngap4++;
                   }
                   else if(diag1Sets.get(0)==me && diag1Sets.get(1)==me && diag1Sets.get(2)==null && diag1Sets.get(3)==me && diag1Sets.get(4)==me){
                       ngap22++;
                   }
         }
     }
     //Search for right to left diagonals
     for (int col = 4; col < 8; col++){
         for (int row = 0; row < 4; row++){
             for (int diff = 0; diff < 5; diff++){
                 diag2Sets.add(board[row+diff][col-diff]);
             }
                   if(diag2Sets.get(0)==null && diag2Sets.get(1)==me && diag2Sets.get(2)==me && diag2Sets.get(3)==me && diag2Sets.get(4)==null){
                        nopen3++;
                    }
                   else if(diag2Sets.get(0)==null && diag2Sets.get(1)==me && diag2Sets.get(2)==me && diag2Sets.get(3)==me && diag2Sets.get(4)==enemy){
                       ncap3++;
                   }
                   else if(diag2Sets.get(0)==enemy && diag2Sets.get(1)==me && diag2Sets.get(2)==me && diag2Sets.get(3)==me && diag2Sets.get(4)==null){
                       ncap3++;
                   }
                   else if(diag2Sets.get(0)==me && diag2Sets.get(1)==me && diag2Sets.get(2)==me && diag2Sets.get(3)==me && diag2Sets.get(4)==me){
                       ncons5++;
                   }
                   else if(diag2Sets.get(0)==null && diag2Sets.get(1)==me && diag2Sets.get(2)==me && diag2Sets.get(3)==null && diag2Sets.get(4)==me){
                       ngap3++;
                   }
                   else if(diag2Sets.get(0)==me && diag2Sets.get(1)==null && diag2Sets.get(2)==me && diag2Sets.get(3)==me && diag2Sets.get(4)==null){
                       ngap3++;
                   }
                   else if(diag2Sets.get(0)==me && diag2Sets.get(1)==me && diag2Sets.get(2)==me && diag2Sets.get(3)==null && diag2Sets.get(4)==me){
                       ngap4++;
                   }
                   else if(diag2Sets.get(0)==me && diag2Sets.get(1)==null && diag2Sets.get(2)==me && diag2Sets.get(3)==me && diag2Sets.get(4)==me){
                       ngap4++;
                   }
                   else if(diag2Sets.get(0)==me && diag2Sets.get(1)==me && diag2Sets.get(2)==null && diag2Sets.get(3)==me && diag2Sets.get(4)==me){
                       ngap22++;
                   }
         }
     }
     
    int op3score = 100000;
    int cap3score = 10000;
    int cons5score = 1000000000; //Double positive infinity?
       /* 6 moves
       int nopen4 = 0;
       int ncap4 = 0;
       */
    int gap3score = 100000;
    int gap4score = 100050;
    int gap22score = 100050; 
    
    score = (nopen3*op3score) + (ncap3*cap3score) + (ncons5*cons5score) + (ngap3 * gap3score) + (ngap4 * gap4score) + (ngap22 * gap22score);
       
    return score;
    }
    

    
//    public ArrayList <String> getEnemyPieces(){
//        String EnemyPos = null;
//        ArrayList <String> AllEnemyPos = new ArrayList<>();
//        for (int row = 0; row < 8; row++)
//            for (int col = 0; col < 8; col++){
//		if (board[row][col] == enemy){
//			EnemyPos = row + "," + col;
//                        AllEnemyPos.add(EnemyPos);
//                }
//            }
//        return AllEnemyPos;
//    }
    
}  
    
 // class RandomPlayer
