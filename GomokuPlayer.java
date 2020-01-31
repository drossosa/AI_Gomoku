/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gomokutest;
import java.awt.Color;

abstract class GomokuPlayer
{
  public abstract Move chooseMove(Color[][] paramArrayOfColor, Color paramColor);
}
