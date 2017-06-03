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
public class tic_tac_toe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {   
        char board[][]={{'\0','\0','\0'},{'\0','\0','\0'},{'\0','\0','\0'}};
        
        Scanner sc =new Scanner(System.in);
        System.out.println("Give me your name:");
        String name=sc.next();
        
        System.out.println("Give me your surname:");
        String surname=sc.next();
        
        System.out.println("Give me your sign:");
        char user_sign=sc.next().charAt(0);
        
        boolean turn,win;
        int i=0;
        
        char cpu_sign='o';
        
        do
        {
        //User set sign
        tic_tac_toe_User_class tttUSER =new tic_tac_toe_User_class(user_sign,cpu_sign,name,surname);
        tttUSER.setSign(board);

        //CPU cet sign
        tic_tac_toe_CPU_class tttCPU =new tic_tac_toe_CPU_class(user_sign,cpu_sign);
        tttCPU.setSign(board);

        
        //show board
        tic_tac_toe_Player_class tttPlayer =new tic_tac_toe_Player_class(user_sign,cpu_sign);
        tttPlayer.getBoard(board);
        

        if (i%2 == 0)
        {
        turn=true;
        //check who win
        win=tttPlayer.checkBoard(board,user_sign,turn);
        }
        else
        {
        turn=false;
        //check who win
        win=tttPlayer.checkBoard(board,cpu_sign,turn);
        }
        
        i++;
        }
        while(win!=true || i==4);
       
    }
    
}
