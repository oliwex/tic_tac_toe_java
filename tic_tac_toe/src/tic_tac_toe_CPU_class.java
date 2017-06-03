
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Minio
 */
public class tic_tac_toe_CPU_class extends tic_tac_toe_Player_class
{
    private int random_field;
    private int[] field_buffer = new int[10]; 

    tic_tac_toe_CPU_class(char user_char,char cpu_char) 
    {
        super(user_char,cpu_char);
    }
    
    public void setSign(char board[][])
    {

        for (int i=1;i<this.field_buffer.length;i++) //set an array an integers
        {
            if (this.scanField(i, board) == '\0') //if null then 0,else full value
            {
                this.field_buffer[i]=0;
            }
            else
            {
                this.field_buffer[i]=1;
            }
        }
        
        Random generator = new Random(); //losuje pole do wstawienia elementu
        
        do
        {   
            this.random_field = generator.nextInt(9)+1;
        }
        while(this.field_buffer[this.random_field] != 0); //do until field is null
        
        this.setField(board,this.random_field,this.cpu_char);//set field as computer sign
        
    }
   
}
