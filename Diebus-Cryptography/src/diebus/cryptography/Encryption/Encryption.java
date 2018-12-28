/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diebus.cryptography.Encryption;

import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;

/**
 *
 * @author Lloyd
 */
public class Encryption {
    public static StringBuffer code = new StringBuffer();
    public static String message;
    
    public Encryption(StringBuffer code)
    {
        this.code = code;
    }
    
    public Encryption(String message)
    {
        this.message = message;
    }
    
    public static Encryption messageDigest(String msg) throws Exception
    {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(msg.getBytes());
        byte[] digest = md.digest();
        for(int i = 0;i < digest.length; i++)
            code.append(Integer.toHexString(0xFF & digest[i]));
        return new Encryption(code);
    }
    
    public static Encryption messageAuthentication(String msg) throws Exception
    {
        KeyGenerator gen = KeyGenerator.getInstance("DES");
        gen.init(new SecureRandom());
        Key key = gen.generateKey();
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(key);
        byte[] macCode = mac.doFinal(msg.getBytes());
        return new Encryption(new String(macCode));
    }
    
    public static Encryption rsa(String msg) throws Exception
    {
        KeyPairGenerator pairGen = KeyPairGenerator.getInstance("RSA");
        pairGen.initialize(2048);
        KeyPair pair = pairGen.genKeyPair();
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, pair.getPublic());
        cipher.update(msg.getBytes());
        byte[] cipherText = cipher.doFinal();
        return new Encryption(new String(cipherText, "UTF8"));
    }
    
    public static Encryption signature(String msg) throws Exception
    {
        KeyPairGenerator pairGen = KeyPairGenerator.getInstance("DSA");
        pairGen.initialize(2048);
        KeyPair pair = pairGen.generateKeyPair();
        PrivateKey key = pair.getPrivate();
        Signature signature = Signature.getInstance("SHA256withDSA");
        signature.initSign(key);
        signature.update(msg.getBytes());
        byte[] sign = signature.sign();
        return new Encryption(new String(sign, "UTF8"));
    }
}
