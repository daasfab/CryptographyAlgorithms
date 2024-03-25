import java.util.HashMap;
import java.util.Map;

//subclass (object) of Substituion, meaning it inherits stuff from it
public class MonoAlphaSubstitution extends Substitution {

    public static void main(String[] args) {
        // Firstly, if there are less than 3 inputs (arguments)
        if (args.length < 3) {// output same messages as shown in Canvas
            System.out.println("Too few parameters!");
            System.out.println("Usage: java MonoAlphaSubstitution encrypt key \"cipher text\"");
            return; // need this to stop executing code if this condition is met
        }
        // Secondly, if there are more than 3 inputs
        if (args.length > 3) {// also output same messages as in Canvas
            System.out.println("Too many parameters!");
            System.out.println("Usage: java MonoAlphaSubstitution encrypt key \"cipher text\"");
            return; // same as above i need this to stop execution
        }
        // if code gets to here, means that there are enough args:
        // 1. prepating variables to be passed into the code later in main()
        String action = args[0];
        String key = args[1];
        String text = args[2];

        // 2. converting inputted str into an array of chars:
        char[] stringToChars = text.toCharArray();
        MonoAlphaSubstitution cipher; // instantiating the class
        // 3. if ENCRYPT
        if (action.equals("encrypt")) { // need to use .equals() since == doesnt compare actual contents of variables
            // creating new instance of the hash map with new key
            cipher = new MonoAlphaSubstitution(key);
            // encrypting each character in the inputted str, using hash map created
            // using inputted key and constructors below
            for (int i = 0; i < stringToChars.length; i++) {
                System.out.print(cipher.encrypt(stringToChars[i]));
            }
            return; // need this so that the program doesnt keep going into decrypt after finishing
        }
        // 4. if DECRYPT
        if (action.equals("decrypt")) { // does same thing as above just with decrypt() method
            // creating new instance of the hash map with new key
            cipher = new MonoAlphaSubstitution(key);
            // decrypting each character in the inputted str, using hash map created
            // using inputted key and constructors below
            for (int i = 0; i < stringToChars.length; i++) {
                System.out.print(cipher.decrypt(stringToChars[i]));
            }
            return;
        }
        // 5. if something else is inputted, it means invalid operation:
        else { // printing out the outputs shown on Canvas
            System.out.println("The first parameter must be \"encrypt\" or \"decrypt\"!");
            System.out.println("Usage: java MonoAlphaSubstitution encrypt key \"cipher text\"");
        }
    }

    // creating a hash map to store key and corresponding value form a given key
    private Map<Character, Character> defaultMapping = new HashMap<>();

    // 1st constructor for the case of no parameters
    public MonoAlphaSubstitution() {
        defaultMapping = new HashMap<>(); // initialising new map to store the new hashmap
        // maps every LOWER CASE letter to itself
        for (int i = 'a'; i <= 'z'; i++) {
            defaultMapping.put((char) i, (char) i);
        }

        // maps every UPPER CASE letter to itself
        for (int i = 'A'; i <= 'Z'; i++) {
            defaultMapping.put((char) i, (char) i);
        }
    }

    // 2nd constructor, sets up custom mapping rules from given key (hashmap)
    public MonoAlphaSubstitution(String keyString) { // keyString is a key, consisting of mappings of chars to other
                                                     // chars
        defaultMapping = new HashMap<>(); // instantiating a new hashmap to store the new values

        // converting string args to array of chars first
        char[] keyStringCharacters = keyString.toCharArray();

        // checking if args is empty, if so do same thing as in other constructor
        if (keyString.length() == 0) {
            // maps every LOWER CASE letter to itself
            for (int i = 'a'; i <= 'z'; i++) {
                defaultMapping.put((char) i, (char) i);
            }
            // maps every UPPER CASE letter to itself
            for (int i = 'A'; i <= 'Z'; i++) {
                defaultMapping.put((char) i, (char) i);
            }

        } else {
            // selecting odd chars as instructed in Canvas, by skipping every other char
            for (int i = 0; i < keyStringCharacters.length - 1; i += 2) {
                // update the hashmap above, where each odd elem is first value, and char after
                // that is a corresponding value
                defaultMapping.put(keyStringCharacters[i], keyStringCharacters[i + 1]);
            }
        }
    }

    // translates plaintext char into its cryptotext variant
    public char encrypt(char plainChar) {
        // in here, inbuilt function getOrDefault, literally gets value associated with
        // the first attrbiute from the map defaultMapping
        // or if it finds nothing linked to that attribute, just returns the character
        // itself, encrypting the inputted char!
        return defaultMapping.getOrDefault(plainChar, plainChar);
    }

    // does same thing as above, just other way around
    public char decrypt(char encryptedChar) {
        // getting all keys in defaultMapping (which were put there through above
        // constructors) with keySet() inbuilt function, it'll allow us to compare keys
        // with inputted chars

        for (char plainChar : defaultMapping.keySet()) {
            // if plainChar (the key) == encryptedChar, then return original unciphered char
            if (defaultMapping.get(plainChar) == encryptedChar) {
                return plainChar;
            }
        }
        // but if no matches are found, then return inputted char, since its one of the
        // chars that weren't encrypted by the key passed into th constructers
        return encryptedChar;
    }
}