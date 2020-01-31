import java.util.ArrayList; 
import java.util.HashSet; 
import java.util.List; 
import java.util.Set; 

public class player171033065 extends GomokuPlayer {
private GameState gameState
private int currentDepth; 
private boolean endSearch = false; //is true when exceeds 10s 
private String lastBestMove; 
//private static int maxDepth = 4; 
private static boolean DEBUG = false; //????***??? 

@Override 
public void run(){ 

//if (DEBUG) System.out.println("MOVE SEARCH THREAD STARTED"_); 

GameState currentState = gameState; 
lastBestMove = null; 
String move = miniMax(currentState.getBoard(), currentState.getPlayer()); 
lastBestMove = move; 
//if(DEBUG)System.out.println("Best Move:" +theMove); 
//System.out.println("Max Depth Reached: "+currentDepth);

}

//minimax algorithm 
public String mmab(char[][] board, char player){ 
	currentDepth = 0; 
	
	String bestMove = null; 
	double bestMoveUtility = Double.NEGATIVE_INFINITY, moveUtility;  
	String[] possibleMoves = generateMoves(board); 
	for (int depth = 1; depth <= 4; depth++){ //deepen the search to 4 
		
		for(int i=0; i<possibleMoves.length; i++){ //for each of the possible moves 
		char[][] gomokuBoard = applyMove(board,player,possibleMoves[i]); 
		//start the search 
		moveUtility = minMove(gomokuBoard, GameState.getEnemy(player), depth, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY); 
		
		if (moveUtility > bestMoveUtility){ //if score > best move score 
		this.lastBestMove = possibleMoves[i]; 
		bestMove = possibleMoves[i]; 
		bestMoveUtility = moveUtility; 
		}
		}
		currentDepth = depth; 
		}
		return bestMove; 
		}
		
//maximize expected outcomes 
public double getMAX(char[][] board, char player, int depthLeft, double alpha, double beta){

	double currentUtility = GameState.getStateUtility(board,player); 
	if (currentUtility == GameState.FIVE_IN_A_ROW || depthLeft == 0 || stopSearch){ //if board is terminal 
	return currentUtility; //return evaluateState(board) 
	}else
	{
	double bestMoveUtility = Double.NEGATIVE_INFINITY, moveUtility; 
	String[] moves = generateAdjacentMoves(board); 
	List<char[][]> boards = generateBoards(board, player, moves); 
	
	for(char[][] b: boards){
	moveUtility = minMove(b, GameState.getEnemy(player), depthLeft-1, alpha, beta); 
	if (moveUtility > bestMoveUtility) bestMoveUtility = moveUtility; 
	if (moveUtility >= beta) return moveUtility; //Alpha-Beta pruning 
	if(moveUtility > alpha) alpha = moveUtility; 
	}
	
	return bestMoveUtility; 
	
	//utility = score?????
	
	}
	
//minimize expected outcomes 
public double minMove(char[][] board, char player, int depthLeft, double alpha, double beta){
	
	double currentUtility = GameState.getStateUtility(board, player); 
	
	if(currentUtility == GameState.FIVE_IN_A_ROW || depthLeft == 0 || stopSearch){ //if board is terminal 
	return currentUtility; 
	}
	else{
	double bestMoveUtility = Double.POSITIVE_INFINITY, moveUtility; 
	String[] moves = generateAdjacentMoves(board): 
	
	List<char[][]> boards = generateBoards(board, GameState.getEnemy(player), moves); 
	
	for(char[][] b: boards){
		moveUtility = maxMove(b, GameState.getEnemy(player), depthLeft-1, alpha, beta); 
		if(moveUtility < bestMoveUtility) bestMoveUtility = moveUtility; 
		if(moveUtility <= alpha) return moveUtility; 
		if(moveUtility < beta) beta = moveUtility; 
		
		}
		
		return bestMoveUtility; //"utility value for the specified move and player" 
		
		}
		}
		
/*	
//make a move ***???????
public char[][] makeMove(char[][] board, char player, string move){ //applyMove
char[][] newBoard = new char[board.length][board.length]; 
for(int i=0; i<board.length; i++){
newBoard[i] = board[i].clone(); 
}

string[] moves = move.split(" "); 
int x = Integer.parseInt(moves[0]); 
int y = Integer.parseInt(moves[1]); 

newBoard[x][y] = player; 
return newBoard; //a new game board with the specified move executed 
}
*/

//generateMoves: generates possible moves(empty spaces) based on game board 
publics String[] generateMoves(char[][] board) { 
	List<String> moves = new ArrayList<>(); 
	for (int i = 0 i< board.length; i++){ 
		for (int j = 0; j< board.length; j++) {
			if (board[i][j] == ' ') { //found empty space
			moves.add( i + " " + j); 
			}
			}
			}
			return moves.toArray(new String[moves.size()]); //returns a string array of possible moves 
			}









		

} 