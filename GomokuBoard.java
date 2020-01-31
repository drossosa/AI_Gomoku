/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gomokutest;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

class GomokuBoard
  extends Canvas
{
  public static final int ROWS = 8;
  public static final int COLS = 8;
  static final int SIZE = 80;
  private static final int[][] allRuns = { { 0, 32, 64, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, { 0, 1, 36, 65, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, { 0, 1, 2, 40, 66, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, { 0, 1, 2, 3, 44, 67, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, { 0, 1, 2, 3, 48, 80, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, { 1, 2, 3, 52, 81, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, { 2, 3, 56, 82, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, { 3, 60, 83, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, { 4, 32, 33, 68, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, { 4, 5, 36, 37, 64, 69, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, { 4, 5, 6, 40, 41, 65, 70, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, { 4, 5, 6, 7, 44, 45, 66, 71, 80, -1, -1, -1, -1, -1, -1, -1 }, { 4, 5, 6, 7, 48, 49, 67, 81, 84, -1, -1, -1, -1, -1, -1, -1 }, { 5, 6, 7, 52, 53, 82, 85, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, { 6, 7, 56, 57, 83, 86, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, { 7, 60, 61, 87, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, { 8, 32, 33, 34, 72, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, { 8, 9, 36, 37, 38, 68, 73, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, { 8, 9, 10, 40, 41, 42, 64, 69, 74, 80, -1, -1, -1, -1, -1, -1 }, { 8, 9, 10, 11, 44, 45, 46, 65, 70, 75, 81, 84, -1, -1, -1, -1 }, { 8, 9, 10, 11, 48, 49, 50, 66, 71, 82, 85, 88, -1, -1, -1, -1 }, { 9, 10, 11, 52, 53, 54, 67, 83, 86, 89, -1, -1, -1, -1, -1, -1 }, { 10, 11, 56, 57, 58, 87, 90, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, { 11, 60, 61, 62, 91, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, { 12, 32, 33, 34, 35, 76, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, { 12, 13, 36, 37, 38, 39, 72, 77, 80, -1, -1, -1, -1, -1, -1, -1 }, { 12, 13, 14, 40, 41, 42, 43, 68, 73, 78, 81, 84, -1, -1, -1, -1 }, { 12, 13, 14, 15, 44, 45, 46, 47, 64, 69, 74, 79, 82, 85, 88, -1 }, { 12, 13, 14, 15, 48, 49, 50, 51, 65, 70, 75, 83, 86, 89, 92, -1 }, { 13, 14, 15, 52, 53, 54, 55, 66, 71, 87, 90, 93, -1, -1, -1, -1 }, { 14, 15, 56, 57, 58, 59, 67, 91, 94, -1, -1, -1, -1, -1, -1, -1 }, { 15, 60, 61, 62, 63, 95, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, { 16, 32, 33, 34, 35, 80, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, { 16, 17, 36, 37, 38, 39, 76, 81, 84, -1, -1, -1, -1, -1, -1, -1 }, { 16, 17, 18, 40, 41, 42, 43, 72, 77, 82, 85, 88, -1, -1, -1, -1 }, { 16, 17, 18, 19, 44, 45, 46, 47, 68, 73, 78, 83, 86, 89, 92, -1 }, { 16, 17, 18, 19, 48, 49, 50, 51, 64, 69, 74, 79, 87, 90, 93, -1 }, { 17, 18, 19, 52, 53, 54, 55, 65, 70, 75, 91, 94, -1, -1, -1, -1 }, { 18, 19, 56, 57, 58, 59, 66, 71, 95, -1, -1, -1, -1, -1, -1, -1 }, { 19, 60, 61, 62, 63, 67, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, { 20, 33, 34, 35, 84, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, { 20, 21, 37, 38, 39, 85, 88, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, { 20, 21, 22, 41, 42, 43, 76, 86, 89, 92, -1, -1, -1, -1, -1, -1 }, { 20, 21, 22, 23, 45, 46, 47, 72, 77, 87, 90, 93, -1, -1, -1, -1 }, { 20, 21, 22, 23, 49, 50, 51, 68, 73, 78, 91, 94, -1, -1, -1, -1 }, { 21, 22, 23, 53, 54, 55, 69, 74, 79, 95, -1, -1, -1, -1, -1, -1 }, { 22, 23, 57, 58, 59, 70, 75, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, { 23, 61, 62, 63, 71, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, { 24, 34, 35, 88, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, { 24, 25, 38, 39, 89, 92, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, { 24, 25, 26, 42, 43, 90, 93, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, { 24, 25, 26, 27, 46, 47, 76, 91, 94, -1, -1, -1, -1, -1, -1, -1 }, { 24, 25, 26, 27, 50, 51, 72, 77, 95, -1, -1, -1, -1, -1, -1, -1 }, { 25, 26, 27, 54, 55, 73, 78, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, { 26, 27, 58, 59, 74, 79, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, { 27, 62, 63, 75, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, { 28, 35, 92, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, { 28, 29, 39, 93, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, { 28, 29, 30, 43, 94, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, { 28, 29, 30, 31, 47, 95, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, { 28, 29, 30, 31, 51, 76, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, { 29, 30, 31, 55, 77, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, { 30, 31, 59, 78, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, { 31, 63, 79, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 } };
  private Color[][] board;
  private Color[][] publicBoard;
  private int[] whiteRuns;
  private int[] blackRuns;
  private Color turn;
  private Color winner;
  private int count;
  
  public GomokuBoard()
  {
    this.board = new Color[8][8];
    this.publicBoard = new Color[8][8];
    this.whiteRuns = new int[96];
    this.blackRuns = new int[96];
    init();
  }
  
  public void init()
  {
    this.turn = Color.white;
    this.winner = null;
    this.count = 0;
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        this.board[i][j] = null;
      }
    }
    for (i = 0; i < 96; i++) {
      this.whiteRuns[i] = (this.blackRuns[i] = 0);
    }
  }
  
  public String makeMove(Move paramMove, Color paramColor)
  {
    Color localColor = this.turn == Color.white ? Color.black : Color.white;
    if (this.winner != null) {
      return "ERROR: Game is already over";
    }
    if (this.turn != paramColor) {
      return "ERROR: It is not your turn";
    }
    if (paramMove == null)
    {
      this.winner = localColor;
      return "Exception or null Move";
    }
    int j = paramMove.row;
    int k = paramMove.col;
    if ((k < 0) || (k >= 8) || (j < 0) || (j >= 8))
    {
      this.winner = localColor;
      return "Move out of range";
    }
    if (this.board[j][k] != null)
    {
      this.winner = localColor;
      return "Move in occupied cell";
    }
    this.board[j][k] = this.turn;
    
    this.turn = localColor;
    this.count += 1;
    if (this.turn == Color.black) {
      for (i = 0; allRuns[(j * 8 + k)][i] != -1; i++) {
        if (this.whiteRuns[allRuns[(j * 8 + k)][i]] += 1 == 5)
        {
          this.winner = Color.white;
          return "White wins";
        }
      }
    }
    for (int i = 0; allRuns[(j * 8 + k)][i] != -1; i++) {
      if (this.blackRuns[allRuns[(j * 8 + k)][i]] += 1 == 5)
      {
        this.winner = Color.black;
        return "Black wins";
      }
    }
    for (i = 0; i < 96; i++) {
      if ((this.whiteRuns[i] == 0) || (this.blackRuns[i] == 0)) {
        break;
      }
    }
    if ((this.count == 64) || (i == 96))
    {
      this.winner = Color.blue;
      return "Game drawn";
    }
    if (this.turn == Color.white) {
      return "White to play";
    }
    return "Black to play";
  }
  
  public Color getWinner()
  {
    return this.winner;
  }
  
  public Color getTurn()
  {
    return this.turn;
  }
  
  public int getMoveCount()
  {
    return this.count;
  }
  
  public Color[][] getPublicBoard()
  {
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        this.publicBoard[i][j] = this.board[i][j];
      }
    }
    return this.publicBoard;
  }
  
  public void paint(Graphics paramGraphics)
  {
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++)
      {
        if ((j + i) % 2 == 0) {
          paramGraphics.setColor(new Color(200, 50, 100));
        } else {
          paramGraphics.setColor(new Color(50, 200, 100));
        }
        paramGraphics.fillRect(j * 80, i * 80, 80, 80);
        if (this.board[i][j] != null)
        {
          paramGraphics.setColor(this.board[i][j]);
          paramGraphics.fillOval(j * 80 + 10, i * 80 + 10, 60, 60);
        }
      }
    }
  }
  
  public void update(Graphics paramGraphics)
  {
    paint(paramGraphics);
  }
}
