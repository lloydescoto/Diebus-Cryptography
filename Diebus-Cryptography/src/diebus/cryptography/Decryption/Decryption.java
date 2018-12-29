/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diebus.cryptography.Decryption;

/**
 *
 * @author Lloyd
 */
public class Decryption {
    
    public static StringBuffer code = new StringBuffer();
    
    public Decryption(StringBuffer code)
    {
        this.code = code;
    }
    public static Decryption ceasarCipher(String msg, int key)
    {
        for(int i = 0; i < msg.length(); i++)
        {
            if(Character.isUpperCase(msg.charAt(i)))
                code.append((char)(((int)msg.charAt(i) - key - 65) % 26 + 65));
            else
                code.append((char)(((int)msg.charAt(i) - key - 97) % 26 + 97));
        }
        return new Decryption(code);
    }
}
