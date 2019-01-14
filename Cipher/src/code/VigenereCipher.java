package code;

public class VigenereCipher {
    private String key;
    private char[][] alphabets;
    private char[] inputAlphabet;

    VigenereCipher(String key) {
        this(key,Cipher.alphabet);
        inputAlphabet=Cipher.alphabet;
    }


    VigenereCipher(String key1, String key2){this(key1,SubstitutionCipher.createAlphabet(key2));}
    VigenereCipher(String key1, String key2, char[] alphabet){this(key1,SubstitutionCipher.createAlphabet(key2,alphabet));}


    VigenereCipher(String key, char[] alphabet) {
        this.key = Cipher.filter(key,alphabet);
        inputAlphabet=alphabet;
        alphabets = createAlphabets(alphabet);
    }

    private char[][] createAlphabets() {
        return createAlphabets(Cipher.alphabet);
    }

    private char[][] createAlphabets(char[] alphabet) {
        char[][] alphabets = new char[key.length()][alphabet.length];
        for(int i=0; i<key.length(); i++){
            int n = Cipher.toInt(key.charAt(i),alphabet);
            System.arraycopy(alphabet,0,alphabets[i],alphabet.length-n,n);
            System.arraycopy(alphabet, n, alphabets[i], 0,alphabet.length-n);
        }
        return alphabets;
    }

    String encipher(String plaintext) {
        plaintext = Cipher.filter(plaintext,inputAlphabet);
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0; i<plaintext.length(); i++){
            stringBuilder.append(alphabets[i%key.length()][Cipher.toInt(plaintext.charAt(i),inputAlphabet)]);
        }
        return stringBuilder.toString();
    }

    String decipher(String ciphertext) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0; i<ciphertext.length(); i++){
            stringBuilder.append(inputAlphabet[Cipher.toInt(ciphertext.charAt(i),alphabets[i%key.length()])]);
        }
        return stringBuilder.toString();
    }
}