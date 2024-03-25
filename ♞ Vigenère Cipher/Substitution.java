import java.util.ArrayList;

public abstract class Substitution implements Cipher {
    public abstract char encrypt(char c);

    public abstract char decrypt(char c);

    // 1. can't dynamically change an array, so using an arraylist to do it
    // in first
    ArrayList<Character> cipherText = new ArrayList<Character>();

    // doing subtitution cipher by callig encrypt abstract method (for each char of
    // str plaintext)
    public String encrypt(String plaintext) {
        // 1. convert str to array containing chars in that str
        // this is a local variable so cant be amended anywhere outisde this method
        char[] plaintextArray = plaintext.toCharArray();

        cipherText.clear(); // clears the arraylist before adding new chars

        // 2. now do substituion cipher on each elem of that array
        for (int i = 0; i < plaintextArray.length; i++) {
            cipherText.add(encrypt(plaintextArray[i]));
        }
        // 3. returning new cipher text by converting arraylist to string
        return (cipherText.toString());
    }

    // 1. edclaring arraylist for method below
    ArrayList<Character> decipherText = new ArrayList<Character>();

    // performing same process as above, but now or deciphering text
    public String decrypt(String cryptotext) {
        // 1. convert str to array containing chars in that str
        char[] cryptotextArray = cryptotext.toCharArray();
        decipherText.clear(); // clears the arraylist before adding new chars

        // 2. now do substituion cipher on each elem of that array
        for (int i = 0; i < cryptotextArray.length; i++) {
            decipherText.add(decrypt(cryptotextArray[i]));
        }
        // 3. returning new cipher text by converting arraylist to string
        return (decipherText.toString());
    }
}