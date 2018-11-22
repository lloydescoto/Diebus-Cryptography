/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diebus.cryptography;

import static diebus.cryptography.DiebusCryptography.Decrypt;
import static diebus.cryptography.DiebusCryptography.Encrypt;
import java.util.Scanner;

/**
 *
 * @author Lloyd
 */
public class DiebusTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Message : ");
        String text = input.nextLine();
        System.out.println("Encrypt : " + Encrypt(text));
        System.out.println("Decrypt : " + Decrypt(Encrypt(text),5));
    }
}
