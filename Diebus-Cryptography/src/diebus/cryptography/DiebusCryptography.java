/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diebus.cryptography;

import java.util.*;
/**
 *
 * @author Lloyd
 */
public class DiebusCryptography {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Message : ");
        String text = input.nextLine();
        System.out.println("Encrypt : " + Encrypt(text));
        System.out.println("Decrypt : " + Decrypt(Encrypt(text),5));
    }
    
    public static String Encrypt(String message)
    {
        Date now = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        String code = "";
        int start = calendar.get(Calendar.DAY_OF_WEEK);
        for(int x = 0; x < message.length(); x++)
        {
            int letter = (int)message.charAt(x) + start;
            code += (char)letter;
            start++;
            if(start > 7)
                start = 1;
        }
        return code;
    }
    
    public static String Decrypt(String code, int key)
    {
        String message = "";
        int start = key;
        for(int x = 0; x < code.length(); x++)
        {
            
            int letter = (int)code.charAt(x) - start;
            message += (char)letter;
            start++;
            if(start > 7)
                start = 1;
        
        }
        return message;
    }
    
}
