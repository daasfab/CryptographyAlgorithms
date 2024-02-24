import java.util.Arrays;

public class Caesar {

    public static void main(String[] args) {

        // 1. Checking if the inputed array of str in args has too many elements
        if (args.length > 2) {
            System.out.println("Too many parameters!");
            System.out.println("Usage: java Caesar n \"cipher text\"");
        }

        // 2. Now checking if there are too few parameters inputted, the same way
        if (args.length < 2) {
            System.out.println("Too few parameters!");
            System.out.println("Usage: java Caesar n \"cipher text\"");
        }

        // 3. Lastly, if the prior 2 conditions weren't met, means enough inputs
        else {
            int integerShift = Integer.parseInt(args[0]); // need to explicitely convert the 1st input into int
            String inputString = args[1];
            System.out.println(rotate(integerShift, inputString));
        }
    }

    // First method ONLY rotates a single char (will be used in rotateSting)
    public static char rotate(int iShift, char inpChar) {
        char shiftedChar = inpChar;
        int shiftedIndex = 0;

        // 1. Seeing if the input char is LOWER CASE
        if (Character.isLowerCase(inpChar)) {
            shiftedIndex = (inpChar - 'a' + iShift + 26) % 26; // rotating the letter by 1st fidning its index, then +
                                                               // iShift. Whats Very IMPORTANT is that by checking if
                                                               // the letter is in the range of 26 letter by checking
                                                               // the remainder in here rather than the next line, i fix
                                                               // the issue that i was facing where if integer shift
                                                               // value is negative, some of the letters would turn into
                                                               // signs lke u -> [, so this fixed it!

            shiftedChar = (char) ('a' + shiftedIndex); // assigning shifted letter to the var., making sure that
                                                       // the its in the range of the alphabet's 26 letters
        }

        // 2. Else, seeing if its UPPER Case, if so then do the same process of shifting
        if (Character.isUpperCase(inpChar)) {
            shiftedIndex = (inpChar - 'A' + iShift + 26) % 26;
            shiftedChar = (char) ('A' + shiftedIndex);
        }

        // as i explicity put 2 if statements instead of an if & "else", characters that
        // ARE NOT letters, will be left untouched! Yay
        return shiftedChar;
    }

    // Rotates the whole string (inpString) using rotateChar
    public static String rotate(int intShift, String inpString) {

        // 1. Need to split the inputted stirng into individual chars putting them
        // in an array, so that I'll be able to individually shift them using rotateChar
        // method!
        char[] charArray = inpString.toCharArray(); // this is now a local variable

        // 2. Declaring array to store shifted letters
        char[] shiftedLettersArray = new char[charArray.length];

        // 3. For each letter in the inputted string...
        for (int i = 0; i < charArray.length; i++) {

            // ...shift it by intShift times
            shiftedLettersArray[i] = rotate(intShift, charArray[i]);
        }
        // 4. Output shifted string
        return new String(shiftedLettersArray);
    }

}