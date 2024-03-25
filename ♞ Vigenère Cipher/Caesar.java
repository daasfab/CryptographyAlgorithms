public class Caesar extends MonoAlphaSubstitution {

    public static void main(String[] args) {
        // Writing same if statements that were used in MonoAlpha... subclass
        // but this time, it'll output the action that is inputted rather than having
        // the action be hard coded in (going above & beyond)!
        // Firstly, if there are less than 3 inputs (arguments)
        if (args.length < 3) {// output same messages as shown in Canvas
            System.out.println("Too few parameters!");
            System.out.println("Usage: java Caesar " + args[0] + " n \"cipher text\"");
            return; // need this to stop executing code if this condition is met
        }
        // Secondly, if there are more than 3 inputs
        if (args.length > 3) {// also output same messages as in Canvas
            System.out.println("Too many parameters!");
            System.out.println("Usage: java Caesar " + args[0] + " n \"cipher text\"");
            return; // same as above i need this to stop execution

        }
        // Like in MonoAlpha... subclass, declaring variables to be used later in main()
        String action = args[0];
        int shiftInt = Integer.parseInt(args[1]);
        String text = args[2];

        // creating new object which will store the new shift created by the 2nd
        // constructor
        Caesar newShiftInt = new Caesar(shiftInt);

        // same as MonoAlpha.., if its encrypt then do:
        if (action.equals("encrypt")) { // again need to use .equals() instead of ==
            // doing the actual shift wth rotate() with string as a parameter:
            String readyEncryptedText = rotate(newShiftInt.newShiftInt, text); // newShiftInt.newShiftInt becase it
                                                                               // needs to use retrieved value from the
                                                                               // instance of the Caesar class, without
                                                                               // this it won't work and causes an error
            System.out.println(readyEncryptedText);
            return; // need this to stop Caesar from going further down the code after execution
        }
        // if decrypt then (same process as above):
        if (action.equals("decrypt")) { // again need to use .equals() instead of ==
            // doing actual shift as before, but with (n - 12224) % 26 as 1st parameter:
            String readyDecryptedText = rotate((26 - shiftInt - 12224) % 26, text); // 26 - shiftInt) reverses the int
                                                                                    // given as a shift, which will
                                                                                    // allow me to revrse the encryption
                                                                                    // by then - 12224 as instructed on
                                                                                    // Canvas
            System.out.println(readyDecryptedText);
            return;
        }

        else // if this condition is met, then something else was inutted in "action"
        { // even thought this wasnt explicetly shown as a test case on Canvas, I put it
          // anyway just in case :)
            System.out.println("First argument is incompatible!");
            System.out.println("Usage: java Caesar encrypt n \"cipher text\"");
            return;
        }
    }

    // declaring variable that will store the value of shift for
    // encrypting/decrypting
    int newShiftInt;

    // 1st constructor for no no key or shift
    public Caesar() {
        // instantiating the variable created earlier, to store new value of shift (0)
        this.newShiftInt = 0;
    }

    // 2nd constructor for when there is a shift
    public Caesar(int shiftInt) {
        // instantiaing newShiftInt variable like we did with the hashmap in MonoAl..
        this.newShiftInt = (shiftInt + 12224) % 26; // +12224 & %26 as per Canvas instructions
    }

    // Doing the cezar cipher:
    // this method only rotates a single char (will be used in rotateString)
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
