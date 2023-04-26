import java.util.Scanner;

public class CaesarCipher {
    // Field -- establishing shift factor
    private int cipherShift;

    // Constructor -- establishing shift factor
    public CaesarCipher(int cipherKey) {
        this.cipherShift = cipherKey;
    }

    // Method - encryption
    // Assigns characters to a character array, shifts characters based on shift factor to encrypt
    // Returns encrypted message as a string
    public String encrypt(String message) {
        StringBuilder encryptedMessage = new StringBuilder();
        for (char characters:message.toCharArray()) {
            if (Character.isLetter(characters)) {
                int baseAlphabet = Character.isUpperCase(characters)?'A':'a';
                characters = (char) ((characters - baseAlphabet + cipherShift) % 26 + baseAlphabet);
            }
            encryptedMessage.append(characters);
        }
        return encryptedMessage.toString();
    }

    // Method - decryption
    // Takes an encrypted message, shifts alphabet back based on shift factor, returns decrypted message as a string
    public String decrypt(String message) {
        CaesarCipher decryptedMessage = new CaesarCipher(26 - cipherShift);
        return decryptedMessage.encrypt(message);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the Caesar Cipher!");
        System.out.println("This program is designed to encrypt or decrypt messages based on a cipher system, where");
        System.out.println("messages are encyrpted or decrypted based on a user defined shift of the alphabet.");
        System.out.println("Please enter the message you wish to encrypt or decrypt:");
        String message = input.nextLine();

        System.out.println("Choose the action you wish to perform: ");
        System.out.println("A: Encryption");
        System.out.println("B: Decryption");
        char choice = input.nextLine().charAt(0);
        String result;

        System.out.println("Please enter an integer shift factor with which to encrypt or decrypt:");
        int shiftFactor = input.nextInt();
        input.nextLine();

        CaesarCipher cipher = new CaesarCipher(shiftFactor);

        if (choice == 'A' || choice == 'a') {
            result = cipher.encrypt(message);
            System.out.println("Your encrypted message: " + result);
        } else if (choice == 'B' || choice == 'b') {
            result = cipher.decrypt(message);
            System.out.println("Your decrypted message: " + result);
        } else {
            System.out.println("Choice not valid, please try again.");
        }
    }
}
