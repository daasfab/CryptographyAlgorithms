# Vigenère Cipher

---

## 🔍 Overview

The Vigenère Cipher is a 16th century encryption scheme first described by Giovan Battista Bellaso and later misattributed to French diplomat Blaise de Vigenère. It addresses the main weakness of earlier ciphers which are easily broken with a frequency analysis, as we have done in the first assignment.

The idea behind the Vigenère cipher is to disguise the plaintext letter frequencies by not encoding each letter according to the same translation table. Instead, it uses one translation table for each letter position in the plaintext. Such ciphers are called polyalphabetic substitutions because there is more than one mapping (alphabet) involved. This way, the most common letter ‘e’ for instance translates to different letters depending on where in the plaintext it occurs. In fact this cipher has resisted crypto-analytic attacks for well over two centuries, which earned it the nick name le chiffre indéchiffrable.

What makes this cipher particularly user friendly is the way one specifies the secret key, i.e. the substitutions to use at each position. This is done by arranging several Caesar ciphers with different shifts based on some key word which is easy to remember for all communicating parties.


---

## 📬 Developer Notes!!! (Updated)

Hello, Dear Reader! Please note that there are 4 text files, each taking a slightly different approach to encrypting text, from the substitution shift (Caesar Cipher) to the Vigenère Cipher. 
All of them were developed with the principles of OOP (using constructors, inheritance, and encapsulation; thus, it was a challenge to get them working!). Please note that the Vigenère Cipher itself is not yet fully working, and I am working on it. 

This is how the encryption with the provided key will work: 
Suppose for example that the keyword is “COMPONETWOTWO”. Then the first character of the plaintext would be translated according to a Caesar cipher with shift 2, as 'C' - 'A' == 2, the first letter ‘C’ of the keyword is two letters after ‘A’ in the Roman alphabet. The second character will be translated using a Caesar cipher with shift 14 == 'O' - 'A' and so on. If the plaintext is longer than the key one continues at the start of the key word, so that the 14th position will again use the Caesar shift 2. If you encrypt the phrase “fun fun fun” with the key above, you should get “hiz thr big”. Notice that the letter ‘f’ maps to a different letter each time!

---

## 📥 Installation
Download the required text files, and open a new terminal window, loading the Vigenere.java file. Then pass in your key and text as required by the source code, and your text will be securely encrypted! 

Make sure that your key is at least as long as the text itself, with trully random comnination of letters to achieve true unbreakability of the encrypted message. 




