public class Brutus {
    public static final double[] english = {
            0.0855, 0.0160, 0.0316, 0.0387, 0.1210, 0.0218, 0.0209, 0.0496, 0.0733,
            0.0022, 0.0081, 0.0421, 0.0253, 0.0717, 0.0747, 0.0207, 0.0010, 0.0633,
            0.0673, 0.0894, 0.0268, 0.0106, 0.0183, 0.0019, 0.0172, 0.0011
    };

    public static void main(String[] args) {
        // 1. Checking if the inputed array of str in args has too many elements
        if (args.length > 1) {
            System.out.println("Too many parameters!");
            System.out.println("Usage: java Brutus \"cipher text\"");
        }

        // 2. Now checking if there are too few parameters inputted, the same way
        if (args.length < 1) {
            System.out.println("Too few parameters!");
            System.out.println("Usage: java Brutus \"cipher text\"");
        }

        // 3. Lastly, if the prior 2 conditions weren't met, means enough inputs
        else {
            // calling this method as it will be the one to "brute force" the cipher, by
            // shifting the inputted encrypted str 26 times, and seeing which shifted string
            // corresponds to the lowest chi! In theory that should be our deciphered input
            // string!
            System.out.println(shiftFinder(args[0]));

        }

    }

    // Count method will give me the n times each letter in the ciphered str occurs
    // (It will use a helper function repeatingCounter)
    public static int[] count(String lettersString) {
        // 1. Since we treat UPPER & LOWER case as same, I will lower them all to
        // lowercase
        int[] numOfOccurences = new int[26];

        // declared var. now contains lowered input str
        String loweredLetters = lettersString.toLowerCase();

        for (char Char = 'a'; Char <= 'z'; Char++) {
            // calculating index of current letter first
            int i = Char - 'a';
            String letterTemp = String.valueOf(Char);
            numOfOccurences[i] = repeatingCounter(loweredLetters, letterTemp);
        }
        return numOfOccurences;

    }

    // Helper function for count() method, will return n repeats of each letter
    public static int repeatingCounter(String targetString, String letter) {
        int nRepeats = 0;
        int fstIndex = targetString.indexOf(letter);

        while (fstIndex != -1) {
            targetString = targetString.substring(fstIndex + letter.length(), targetString.length());
            fstIndex = targetString.indexOf(letter);
            nRepeats = nRepeats + 1;
        }

        return nRepeats;
    }

    // Frequency method now returns an array of doubles, each representing frequency
    // value of a letter
    public static double[] frequency(String inputString) {
        // declaring the var. that will store frequencies
        double[] doublesArray = new double[26];

        // Adding frequencies into the array one by one
        for (int i = 0; i < 26; i++) {
            doublesArray[i] = (double) (count(inputString))[i] / inputString.length();
        }

        return doublesArray;
    }

    // calculating how close inputted arrays are by calc. score
    public static double chiSquared(double[] frequency1, double[] frequency2) {
        double chiSqrd = 0.0;

        for (int i = 0; i < 26; i++) {
            // making the calculations now using given formula & storing the sum in chiSqrd
            chiSqrd = chiSqrd + ((frequency1[i] - frequency2[i]) * (frequency1[i] - frequency2[i])) / frequency2[i];
        }

        // returning the value of chi squared
        return chiSqrd;
    }

    public static String shiftFinder(String inputString) {
        // newString will store the new shifter string
        String newString = "";

        // this var. will store the chiSquared value for each string (in which letters
        // have been shifter by one)
        double updatedChi = 0.0;

        // bestString will store the string which chi is the smallest
        String bestString = "";

        // lastly, tempChi will store the temp (highest value of chi possible at first),
        // which will then decrease with each smaller chi of a each shifted string!
        double lowestChi = 10000.0;

        for (int i = 0; i < 26; i++) {
            newString = Caesar.rotate(i, inputString);
            updatedChi = chiSquared(frequency(newString), english);
            if (updatedChi < lowestChi) {
                lowestChi = updatedChi;
                bestString = newString;
            }
        }

        return bestString;

    }

}
