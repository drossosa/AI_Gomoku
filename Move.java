/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gomokutest;
public class Move
{
  public int row;
  public int col;
  
  public Move(int paramInt1, int paramInt2)
  {
    this.row = paramInt1;
    this.col = paramInt2;
  }
  
  public String toString()
  {
    return "(" + this.row + "," + this.col + ")";
  }
}