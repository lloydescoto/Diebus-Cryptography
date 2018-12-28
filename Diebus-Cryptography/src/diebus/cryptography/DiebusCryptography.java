/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diebus.cryptography;

import diebus.cryptography.Encryption.Encryption;
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
    public static String Encrypt(String message) throws Exception
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int start = calendar.get(Calendar.DAY_OF_WEEK);
        switch (start) {
            case 1:
                return Encryption.ceasarCipher(message, start).code.toString();
            case 2:
                return Encryption.md5(message).code.toString();
            case 3:
                return Encryption.secretKey(message).message;
            case 4:
                return Encryption.rsa(message).message;
            case 5:
                return Encryption.sha256(message).code.toString();
            case 6:
                return Encryption.messageAuthentication(message).message;
            case 7:
                return Encryption.signature(message).message;
            default:
                break;
        }
        return "Error Occur";
    }
}
