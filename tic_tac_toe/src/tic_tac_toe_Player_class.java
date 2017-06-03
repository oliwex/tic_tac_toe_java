/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.lang.System;
/**
 *
 * @author Minio
 */
public class tic_tac_toe_Player_class 
{   
    protected char user_char;
    protected char cpu_char;
    private static boolean win;
    
    tic_tac_toe_Player_class(char user_char,char cpu_char)
    {
        this.user_char=user_char;
        this.cpu_char=cpu_char;

    }
    
     
    
    protected char scanField(int field,char board[][])//translate field from 1-3,4-6,7-9 to 1-9,return value of field
    {
        char buffer = '\0';
        
        switch(field)
        {
            case 1:
            {
                buffer=board[0][0];
                break;
            }
            case 2:
            {
               buffer=board[0][1];
                break;
            }
            case 3:
            {
                buffer=board[0][2];
                break;
            }
            case 4:
            {
                buffer=board[1][0];
                break;
            }
            case 5:
            {
                buffer=board[1][1];
                break;
            }
            case 6:
            {
                buffer=board[1][2];
                break;
            }
            case 7:
            {
                buffer=board[2][0];
                break;
            }
            case 8:
            {
                buffer=board[2][1];
                break;
            }
            case 9:
            {
                buffer=board[2][2];
                break;
            }
        }
        return buffer;//return value of the field
    }
        
    protected void setField(char board[][],int field,char sign) //sign is parameter because of user and cpu char
    {
        switch(field)
        {
            case 1:
            {
                board[0][0]=sign;
                break;
            }
            case 2:
            {
               board[0][1]=sign;
                break;
            }
            case 3:
            {
                board[0][2]=sign;
                break;
            }
            case 4:
            {
                board[1][0]=sign;
                break;
            }
            case 5:
            {
                board[1][1]=sign;
                break;
            }
            case 6:
            {
                board[1][2]=sign;
                break;
            }
            case 7:
            {
                board[2][0]=sign;
                break;
            }
            case 8:
            {
                board[2][1]=sign;
                break;
            }
            case 9:
            {
                board[2][2]=sign;
                break;
            }
        }
    }
       
    protected boolean checkIfNull(int field,char board[][]) //check if field is null
    {
        char buffer=this.scanField(field, board);

        if (buffer == '\0')
        {
            return true; 
        }
        return false;
    }
    
    public void getBoard(char board[][]) //show Board to a user
    {

        
        int i,j;
        for (i=0;i<3;i++)
        {
            for(j=0;j<3;j++)
            {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
    
    private void checkVertical(char board[][],char sign) //check board vertically pionowo            
    {
       //first column
       char c1= this.scanField(1, board); //return char
       char c2= this.scanField(4, board); //return char
       char c3= this.scanField(7, board); //return char
       if ((c1 == c2) && (c2 == c3)&& (c1 == sign))//sprawdz wszystkie znaki i znak podany
       {
           this.win=true;
       }
       
       //second column
       char c4= this.scanField(2, board); //return char
       char c5= this.scanField(5, board); //return char
       char c6= this.scanField(8, board); //return char
       if ((c4 == c5) && (c5 == c6)&& (c4 == sign))//sprawdz wszystkie znaki i znak podany
       {
           this.win=true;
       }
       
       //third column
       char c7= this.scanField(3, board); //return char
       char c8= this.scanField(6, board); //return char
       char c9= this.scanField(9, board); //return char
       if ((c7 == c8) && (c8 == c9)&& (c7 == sign))//sprawdz wszystkie znaki i znak podany
       {
           this.win=true;
       }
        
    }
    
    private void checkHorizontal(char board[][],char sign) //check board vertically pionowo            
    {
       //first column
       char c1= this.scanField(1, board); //return char
       char c2= this.scanField(2, board); //return char
       char c3= this.scanField(3, board); //return char
       if ((c1 == c2) && (c2 == c3)&& (c1 == sign))//sprawdz wszystkie znaki i znak podany
       {
           this.win=true;
       }
       
       //second column
       char c4= this.scanField(4, board); //return char
       char c5= this.scanField(5, board); //return char
       char c6= this.scanField(6, board); //return char
       if ((c4 == c5) && (c5 == c6)&& (c4 == sign))//sprawdz wszystkie znaki i znak podany
       {
           this.win=true;
       }
       
       //third column
       char c7= this.scanField(7, board); //return char
       char c8= this.scanField(8, board); //return char
       char c9= this.scanField(9, board); //return char
       if ((c7 == c8) && (c8 == c9)&& (c7 == sign))//sprawdz wszystkie znaki i znak podany
       {
           this.win=true;
       }
       
    }
    
    private void checkCross(char board[][],char sign) //check board vertically pionowo            
    {
       //first column
       char c1= this.scanField(3, board); //return char
       char c2= this.scanField(5, board); //return char
       char c3= this.scanField(7, board); //return char
       if ((c1 == c2) && (c2 == c3) && (c1 == sign))//sprawdz wszystkie znaki i znak podany
       {
           this.win=true;
       }
       
       //second column
       char c4= this.scanField(1, board); //return char
       char c5= this.scanField(5, board); //return char
       char c6= this.scanField(9, board); //return char
       if ((c4 == c5) && (c5 == c6)&& (c4 == sign))//sprawdz wszystkie znaki i znak podany
       {
           this.win=true;
       }
       
    }
    
    public boolean checkBoard(char board[][],char sign, boolean turn)
    {//turn 1=player, 0=cpu
        if (turn)
        {
            this.checkCross(board,sign);
            this.checkHorizontal(board, sign);
            this.checkVertical(board, sign);    
        }
        else
        {
            this.checkCross(board,sign);
            this.checkHorizontal(board, sign);
            this.checkVertical(board, sign);
        }
        return this.win;
    }
    
    
}
