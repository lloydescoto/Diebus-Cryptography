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
        int start = 2;
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
        else if(start == 2)
        {
            for(int x = 0;x < message.length();x++)
            {
                int letter = (int)message.charAt(x) + start;
                code += letter;
                if(x + 1 < message.length())
                    code += '-';
                start++;
                if(start > 7)
                    start = 1;
            }
        }
        else if(start == 7)
        {
            Random random = new Random();
            for(int x = 0;x < message.length();x++)
            {
                code += (char)random.nextInt(127);
                int letter = (int)message.charAt(x) + start;
                code += (char)letter;
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
        else if(start == 2)
        {
            String[] codes = code.split("-");
            for(int x = 0;x < codes.length; x++)
            {
                int letter = Integer.parseInt(codes[x]) - start;
                message += (char)letter;
                start++;
                if(start > 7)
                    start = 1;
            }
        }
        else if(start == 7)
        {
            for(int x = 0;x < code.length(); x++)
            {
                if(x % 2 == 0)
                {
                }
                else
                {
                    int letter = (int)code.charAt(x) - start;
                    message += (char)letter;
                    start++;
                    if(start > 7)
                        start = 1;
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
