/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
/**
 *
 * @author Minio
 */

public class tic_tac_toe_User_class extends tic_tac_toe_Player_class
{   
    private String name;
    private String surname;
    
    tic_tac_toe_User_class(char user_char,char cpu_char,String name, String surname) 
    {
        super(user_char,cpu_char); //wywołanie konstruktora z klasy nadrzędnej
        
        this.name=name;
        this.surname=surname;

    }
    
    private boolean checkIfNegativeChar(int field,char board[][]) //check if sign is negative
    {
       char buffer=this.scanField(field, board);
       
       if (buffer == this.cpu_char) //check if value of field is the same as cpu_char
       {
           return true; //is negative
       }
       return false;
    }
    
    private boolean checkIfPositiveChar(int field,char board[][])
    {
        char buffer=this.scanField(field, board);
       
       if (buffer == this.user_char) //check if value of field is the same as user_char
       {
           return true; //is positive
       }
       return false;
    }
    
    public void setSign(char board[][])
    {
        Scanner sc =new Scanner(System.in);
        System.out.println("Give me number of field:");
        int field=sc.nextInt();
        char buffer=this.scanField(field, board); //scan value of field
        if (this.checkIfPositiveChar(field,board) || this.checkIfNegativeChar(field,board))
        {
            System.out.println("Error");
        }
        else if (this.checkIfNull(field, board))
        {
            this.setField(board, field, this.user_char);
        }
    }
              
}


