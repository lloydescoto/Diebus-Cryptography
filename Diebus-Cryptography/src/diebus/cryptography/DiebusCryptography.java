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
     * @function DiebusCryptography.Encrypt
     * 
     * @param message - The Inputted Message Text
     * @return  code - The Encrypted Text
     */
    public static String Encrypt(String message)
    {
        Date now = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        String code = "";
        //int start = calendar.get(Calendar.DAY_OF_WEEK);
        int start = 4;
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
        else if(start == 3)
        {
            Random random = new Random();
            for(int x = 0;x < message.length();x++)
            {
                int letter = (int)message.charAt(x) + start;
                int randNumber = random.nextInt(127);
                code += randNumber;
                code += '-';
                code += letter + randNumber;
                if(x + 1 < message.length())
                    code += '#';
                start++;
                if(start > 7)
                    start = 1;
               
            }
        }
        else if(start == 4)
        {
            Map<String, String> map = new HashMap<String, String>();
            map.put("a","??");
            map.put("b","-??");
            map.put("c","??-");
            map.put("d","//-");
            map.put("e","--?");
            map.put("f","---");
            map.put("g","?/?");
            map.put("h","///");
            map.put("i","/?");
            map.put("j","^^!");
            map.put("k","/!/");
            map.put("l","?");
            map.put("m","?``");
            map.put("n","/..");
            map.put("o","...");
            map.put("p","?.>");
            map.put("q","<><");
            map.put("r","##!");
            map.put("s","++/");
            map.put("t","^^%");
            map.put("u","%%%");
            map.put("v","/");
            map.put("w","%/");
            map.put("x","!!");
            map.put("y","_-");
            map.put("z","-/-");
            map.put("A","!");
            map.put("B","!!");
            map.put("C","!!!");
            map.put("D","!!!!");
            map.put("E","!!!!!");
            map.put("F","@");
            map.put("G","@@");
            map.put("H","@@@");
            map.put("I","@@@@");
            map.put("J","@@@@@");
            map.put("K","#");
            map.put("L","##");
            map.put("M","###");
            map.put("N","####");
            map.put("O","#####");
            map.put("P","$");
            map.put("Q","$$");
            map.put("R","$$$");
            map.put("S","$$$$");
            map.put("T","$$$$$");
            map.put("U","%");
            map.put("V","%%");
            map.put("W","%%%");
            map.put("X","%%%%");
            map.put("Y","%%%%%");
            map.put("Z","%%%%%%");
            for(int x = 0;x < message.length(); x++)
            {
                if(map.containsKey(Character.toString(message.charAt(x))))
                {
                    code += map.get(Character.toString(message.charAt(x)));
                }
                else
                {
                    code += message.charAt(x);
                }
                code += '|';
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
    /**
     * @function DiebusCryptography.Decrypt
     * @param code - Inputted Encrypted Text
     * @param key - Inputted Key Patterns
     * @return message - The Decrypted Text
     */
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
        else if(start == 3)
        {
            String[] firstCodes = code.split("#");
            for(int x = 0;x < firstCodes.length; x++)
            {
                String[] secondCodes = firstCodes[x].split("-");
                message += (char)((Integer.parseInt(secondCodes[1]) - Integer.parseInt(secondCodes[0])) - start);
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
