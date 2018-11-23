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
    
    public static String Encrypt(String message)
    {
        Date now = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        String code = "";
        //int start = calendar.get(Calendar.DAY_OF_WEEK);
        int start = 1;
        if(start == 1)
        {
            Random random = new Random();
            for(int x = 0;x < message.length();x++)
            {
                int letter = (int)message.charAt(x) + start;
                code += (char)letter;
                code += (char)random.nextInt(127);
                start++;
                if(start > 7)
                    start = 1;
            }
        }
        else
        {
            for(int x = 0; x < message.length(); x++)
            {
                int letter = (int)message.charAt(x) + start;
                code += (char)letter;
                start++;
                if(start > 7)
                    start = 1;
            }
        }
        return code;
    }
    
    public static String Decrypt(String code, int key)
    {
        String message = "";
        int start = key;
        if(start == 1)
        {
            for(int x = 0;x < code.length(); x++)
            {
                if(x % 2 == 0)
                {
                    int letter = (int)code.charAt(x) - start;
                    message += (char)letter;
                    start++;
                    if(start > 7)
                        start = 1;
                }
                else
                {
                }
            }
        }
        else
        {
            for(int x = 0; x < code.length(); x++)
            {

                int letter = (int)code.charAt(x) - start;
                message += (char)letter;
                start++;
                if(start > 7)
                    start = 1;

            }
        }
        return message;
    }
    
}
