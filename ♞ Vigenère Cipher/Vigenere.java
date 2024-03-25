public class Vigenere extends Substitution {
    // apologies, I was not able to solve this class on time, so have to submit it
    // as it is :(
    public static void main(String[] args) {
        // same outputs as in other classes:
        // Firstly, if there are less than 3 inputs (arguments)
        if (args.length < 3) {// output same messages as shown in Canvas
            System.out.println("Too few parameters!");
            // !!! what should be noted is that in provided Canvas example, even if the
            // action is "decrypt", the output still says "encrypt" in "Usage: java..." part
            // in output, thus I'll just print out same message for both, unlike in Caesar
            System.out.println("Usage: java Vigenere encrypt key \"cipher text\"");
            return; // need this to stop executing code if this condition is met
        }
        // Secondly, if there are more than 3 inputs
        if (args.length > 3) {// also output same messages as in Canvas
            System.out.println("Too many parameters!");
            System.out.println("Usage: java Vigenere encrypt key \"cipher text\"");
            return; // same as above i need this to stop execution
        }
        // if code gets to here, means that there are enough args:
        // 1. prepating variables to be passed into the code later in main()
        String action = args[0];
        String key = args[1];
        String text = args[2];

        // 1. variable will store instantiated value of integerValuesForKey
        // Vigenere newShiftInt = new Vigenere(key);

        // 2. putting text letters into array of chars
        char[] textArray = text.toCharArray();

        // ENCRYPTING text, will use keysValuesHolder to encrypt text
        if (action.equals("encrypt")) {
            for (int i = 0; i <= textArray.length; i++) {
                // overwriting the letter with its encrypted value
                textArray[i] = encrypt(textArray[i]);
            }
        }

        // if DECRYPTING text:
        if (action.equals("decrypt")) {

        }
        // Canvas instructions explicitely did not specify any other test cases then the
        // ones i checked for above, thus the main() method stops here
    }

    // stores value of individual shiftsfrom the key
    int[] integerValuesForKey; // e.g., [1, 4, 5, 9, 12, 4]

    // 1st constructor - no args again as in other classes
    public Vigenere() {
        this.integerValuesForKey = ""; // instantiating obj integerValues... to store new value
    }

    // 2nd constructor - yes args
    public Vigenere(String keyWordForEncrDecr) {
        int[] intVFK = keyWordForEncrDecr.toCharArray();// e.g., ['A','G','F','U','N']

        int shiftValue = 0; // will store individual shifts of chars from provided key
        // countsdistance from A to the input letter
        for (int z = 0; z <= intVFK.length; z++) {
            if (Character.isLetter(intVFK[z])) { // checking if its a letter
                for (int i = 'A'; i <= 'Z'; i++) {
                    while (i != intVFK[z]) {
                        shiftValue = shiftValue + 1;
                        i = i + 1; // changes to next letter
                    }
                    // once we find the required shift (hiftValue), push it to array
                    // intValuesForKeys..
                    integerValuesForKey[z] = shiftValue;
                }
            }
        }

        this.integerValuesForKey = integerValuesForKey; // initialises new object to store int values of shifts
    }

    char characterToBeReturned; // for method below
    // Overriding encrypt() method from the Subtitution class:

    int counter = 0;

    public static char encrypt(char plainChar) {
        // checking if value is a letter
        if (Character.isLetter(plainChar)) {
            for (int i = 0; i <= integerValuesForKey.length; i++) {
                for (int z = 'A'; z <= 'Z'; z++) {
                    if (plainChar == z) {
                        plainChar = z + integerValuesForKey[i];
                    }
                }
            }
        }
        return plainChar;
    }
}