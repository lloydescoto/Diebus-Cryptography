/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diebus.cryptography.Encryption;

import java.security.MessageDigest;

/**
 *
 * @author Lloyd
 */
public class Encryption {
    public static StringBuffer code = new StringBuffer();
    
    public Encryption(StringBuffer code)
    {
        this.code = code;
    }
    
    
    public static Encryption messageDigest(String msg) throws Exception
    {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(msg.getBytes());
        byte[] digest = md.digest();
        for(int x = 0;x < digest.length; x++)
            code.append(Integer.toHexString(0xFF & digest[x]));
        return new Encryption(code);
    }
}
