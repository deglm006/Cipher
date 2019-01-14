package code;

class SubstitutionCipher {
    private String key;
    char[] alphabet;
    char[] inputAlphabet;

    SubstitutionCipher(String key){
        this.key = Cipher.filter(key);
        this.inputAlphabet=Cipher.alphabet;
        createAlphabet();
    }

    SubstitutionCipher(String key, char[] alphabet){
        this.key = Cipher.filter(key,alphabet);
        this.inputAlphabet=alphabet;
        createAlphabet(alphabet);
    }

    private void createAlphabet(){
        createAlphabet(Cipher.alphabet);
    }

    private void createAlphabet(char[] alphabet){
        /*this.alphabet = new char[alphabet.length];
        int j = 0;
        for(int i = 0; i < key.length(); i++){
            if(!key.substring(0,i).contains(Character.toString(key.charAt(i)))){
                this.alphabet[j] = key.charAt(i);
                j++;
            }
        }
        for (int i = 0; i < alphabet.length; i++) {
            if (!key.contains(Character.toString(alphabet[i]))) {
                this.alphabet[j] = alphabet[i];
                j++;
            }
        }*/
        this.alphabet = createAlphabet(key,alphabet);
    }
    static char[] createAlphabet(String key){return createAlphabet(key,Cipher.alphabet);}

    static char[] createAlphabet(String key, char[] alphabet){
        char[] newAlphabet = new char[alphabet.length];
        int j = 0;
        for(int i = 0; i < key.length(); i++){
            if(!key.substring(0,i).contains(Character.toString(key.charAt(i)))){
                newAlphabet[j] = key.charAt(i);
                j++;
            }
        }
        for (int i = 0; i < alphabet.length; i++) {
            if (!key.contains(Character.toString(alphabet[i]))) {
                newAlphabet[j] = alphabet[i];
                j++;
            }
        }
        return newAlphabet;
    }

    String encipher(String plaintext){
        plaintext = Cipher.filter(plaintext,alphabet);
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < plaintext.length(); i++){
            stringBuilder.append(alphabet[Cipher.toInt(plaintext.charAt(i),inputAlphabet)]);
        }
        return stringBuilder.toString();
    }

    String decipher(String ciphertext){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < ciphertext.length(); i++){
            stringBuilder.append(inputAlphabet[Cipher.toInt(ciphertext.charAt(i),alphabet)]);
        }
        return stringBuilder.toString();
    }
}
