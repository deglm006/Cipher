package code;

class TranspositionCipher {
    private String key;
    private int[] perm;
    private char[] alphabet;

    TranspositionCipher(String key) {
        this(key, Cipher.alphabet);
    }
    TranspositionCipher(String key, char[] alphabet) {
        this.key = key;
        this.alphabet = alphabet;
        createPerm();
    }

    private void createPerm() {
        boolean[] flags = new boolean[key.length()];
        perm = new int[key.length()];
        for (int i = 0; i < key.length(); i++) {
            int val = alphabet.length;
            for (int j = 0; j < key.length(); j++) {
                if (!flags[j] && Cipher.toInt(key.charAt(j),alphabet) < val) {
                    val = Cipher.toInt(key.charAt(j),alphabet);
                    perm[i] = j;
                }
            }
            flags[perm[i]] = true;
        }
    }

     String encipher(String plaintext) {
         //plaintext=code.Cipher.filter(plaintext,alphabet);
         int n = plaintext.length() / key.length() + 1;
         StringBuilder[] stringBuilders = new StringBuilder[key.length()];
         for (int i = 0; i < key.length(); i++) {
             stringBuilders[i] = new StringBuilder();
         }
         for (int j = 0; j < key.length(); j++) {
             for (int i = 0; i < n; i++) {
                 try {
                     stringBuilders[j].append(plaintext.charAt(j * n + i));
                 } catch (StringIndexOutOfBoundsException e) {
                     int num = (int)(Math.random()*alphabet.length);
                     stringBuilders[j].append(alphabet[num]);
                 }
             }
         }
         String[] strings = new String[key.length()];
         for (int i = 0; i < key.length(); i++) {
             strings[perm[i]] = stringBuilders[i].toString();
         }
         StringBuilder stringBuilder = new StringBuilder();
         for (int i = 0; i < strings[0].length(); i++) {
             for (int j = 0; j < strings.length; j++) {
                 try {
                     stringBuilder.append(strings[j].charAt(i));
                 }catch (Exception e){}
             }
         }
         return stringBuilder.toString();
     }

     String decipher(String ciphertext){
        StringBuilder stringBuilder = new StringBuilder();
         for (int i = 0; i <key.length(); i++) {
             int n = perm[i];
             for (int j = 0; j <ciphertext.length()/key.length(); j++) {
                 stringBuilder.append(ciphertext.charAt(n+j*key.length()));
             }
         }
        return stringBuilder.toString();
     }
}