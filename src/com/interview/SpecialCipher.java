package com.interview;

import java.util.Scanner;


/*Write a special cipher that is a combination of Caesar’s cipher followed by a simple RLE.
The function should receive a string and the rotation number as parameters. Input: special
Cipher(“AABCCC”, 3) Output: D2EF3*/

public class SpecialCipher {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println(" Input the plaintext message : ");
		String plaintext = sc.nextLine();
		System.out.println(" Enter the value by which  each character in the  message gets shifted : ");
		int shift = sc.nextInt();
		String encryptedText = encrypt(plaintext, shift);
		System.out.println("After Encryption: " + encryptedText);
		String compressWithRLE = compressWithRLE(encryptedText);
		System.out.println("RLE Compressed String: "+ compressWithRLE);

		String decryptedText = decrypt(encryptedText, shift);
		System.out.println("After Decryption: " + decryptedText);

		
	}

	private static String compressWithRLE(String decryptedText) {
		String outputString = "";

		int count = 1;
		for (int i = 0; i < decryptedText.length(); i++) {

			// resetting to 1 for every new character (counting current character).
			count = 1;
			while (i < decryptedText.length() - 1 && decryptedText.charAt(i) == decryptedText.charAt(i + 1)) {
				count++;
				i++;
			}
			outputString = outputString + decryptedText.charAt(i) + count;
		}
		System.out.println("Input data string : " + decryptedText);
		System.out.println("Output data string after applying data compression technique : " + outputString);
		return outputString;
	}

	private static String encrypt(String plaintext, int shift) {
		String ciphertext = "";
		char alphabet;
		for (int i = 0; i < plaintext.length(); i++) {
			// Shift one character at a time
			alphabet = plaintext.charAt(i);

			// if alphabet lies between a and z
			if (alphabet >= 'a' && alphabet <= 'z') {
				// shift alphabet
				alphabet = (char) (alphabet + shift);
				// if shift alphabet greater than 'z'
				if (alphabet > 'z') {
					// reshift to starting position
					alphabet = (char) (alphabet + 'a' - 'z' - 1);
				}
				ciphertext = ciphertext + alphabet;
			}

			// if alphabet lies between 'A'and 'Z'
			else if (alphabet >= 'A' && alphabet <= 'Z') {
				// shift alphabet
				alphabet = (char) (alphabet + shift);

				// if shift alphabet greater than 'Z'
				if (alphabet > 'Z') {
					// reshift to starting position
					alphabet = (char) (alphabet + 'A' - 'Z' - 1);
				}
				ciphertext = ciphertext + alphabet;
			} else {
				ciphertext = ciphertext + alphabet;
			}

		}
		return ciphertext;
	}

	private static String decrypt(String ciphertext, int shift) {

		String decryptMessage = "";
		for (int i = 0; i < ciphertext.length(); i++) {
			// Shift one character at a time
			char alphabet = ciphertext.charAt(i);
			// if alphabet lies between a and z
			if (alphabet >= 'a' && alphabet <= 'z') {
				// shift alphabet
				alphabet = (char) (alphabet - shift);

				// shift alphabet lesser than 'a'
				if (alphabet < 'a') {
					// reshift to starting position
					alphabet = (char) (alphabet - 'a' + 'z' + 1);
				}
				decryptMessage = decryptMessage + alphabet;
			}
			// if alphabet lies between A and Z
			else if (alphabet >= 'A' && alphabet <= 'Z') {
				// shift alphabet
				alphabet = (char) (alphabet - shift);

				// shift alphabet lesser than 'A'
				if (alphabet < 'A') {
					// reshift to starting position
					alphabet = (char) (alphabet - 'A' + 'Z' + 1);
				}
				decryptMessage = decryptMessage + alphabet;
			} else {
				decryptMessage = decryptMessage + alphabet;
			}
		}
		return decryptMessage;

	}

}
