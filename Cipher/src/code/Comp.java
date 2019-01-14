package code;

import java.util.Arrays;

public class Comp {
    String key;
    Polybius p;
    VigenereCipher v;
    VigenereCipher v2;
    SubstitutionCipher s;
    SubstitutionCipher s2;
    TranspositionCipher t;

    Comp(String key){
        this.key=key;
        v = new VigenereCipher(key,key,Cipher.alphabet256);
        v2 = new VigenereCipher(trans(),trans(),Cipher.alphabet16);
        p = new Polybius(key,Cipher.alphabet256,Cipher.alphabet16);
        t = new TranspositionCipher(key, Cipher.alphabet256);
        s = new SubstitutionCipher(trans(),Cipher.alphabet16);
        s2 = new SubstitutionCipher(key,Cipher.alphabet256);
    }

    String trans(){
        StringBuilder stringBuilder= new StringBuilder();
        for (int i = 0; i < key.length() ; i++) {
            int n= Character.getNumericValue(key.charAt(i));
            stringBuilder.append(String.format("%X",n));
        }
        String str = stringBuilder.toString();
        //System.out.println(str);
        return str;
    }

    String encipher(String plaintext) {
        plaintext=Cipher.filter(plaintext,Cipher.alphabet256);
        return v.encipher(t.encipher(s2.encipher(v.encipher(p.decode(s.encipher(v2.encipher(p.encode(v.encipher(s2.encipher(plaintext))))))))));
    }

    String decipher(String ciphertext) {
        return s2.decipher(v.decipher(p.decode(v2.decipher(s.decipher(p.encode(v.decipher(s2.decipher(t.decipher(v.decipher(ciphertext))))))))));
    }

    String[] encipher2(String plaintext){
        String str= encipher(plaintext);
        int[] ints= fut(stringToIntArr(str));
        ints=rand(ints,307);
        return intArrToIntStrArr(ints);
    }

    int[] encipher2dec(String plaintext){
        String str= encipher(plaintext);
        int[] ints= fut(stringToIntArr(str));
        ints=rand(ints,307);
        return ints;  //intArrToIntStrArr(ints);
    }

    String decipher2(String[] strings){
        int[] ints = stringArrToIntArr(strings);
        ints = unrand(ints,307);
        System.out.println();
        System.out.println(Arrays.toString(ints));
        ints = unfut(ints);
        System.out.println(Arrays.toString(ints));
        String ciphertext= intArrToString(ints);
        System.out.println(ciphertext);
        return decipher(ciphertext);
    }

    String[] encipher3(String plaintext){
        String str= encipher(plaintext);
        int[] ints =stringToIntArr(str);
        System.out.println(Arrays.toString(ints));
        ints= futCiph(ints);
        System.out.println(Arrays.toString(ints));
        ints=rand(ints,307);
        System.out.println(Arrays.toString(ints));
        System.out.println();
        return intArrToIntStrArr(ints);
    }

    int[] encipher3dec(String plaintext){
        String str= encipher(plaintext);
        int[] ints= futCiph(stringToIntArr(str));
        ints=rand(ints,307);
        return ints;  //intArrToIntStrArr(ints);
    }

    String decipher3(String[] strings){
        int[] ints = stringArrToIntArr(strings);
        ints = unrand(ints,307);
        System.out.println();
        System.out.println(Arrays.toString(ints));
        ints = unfutCiph(ints);
        System.out.println(Arrays.toString(ints));
        String ciphertext= intArrToString(ints);
        System.out.println(ciphertext);
        return decipher(ciphertext);
    }

    String[] encipher4(String plaintext){
        int[] ints = encipher4dec(plaintext);
        String[] strings = intArrToIntStrArr(ints);
        return strings;
    }

    int[] encipher4dec(String plaintext){
        String str= encipher(plaintext);
        int[] ints = stringToIntArr(str);
        ints= futCiph2(ints);
        ints=rand(ints,findM());
        return ints;  //intArrToIntStrArr(ints);
    }

    String decipher4(String[] strings){
        int[] ints = stringArrToIntArr(strings);
        ints = unrand(ints,findM());
        ints = unfutCiph2(ints);
        String ciphertext= intArrToString(ints);
        return decipher(ciphertext);
    }

    static String intArrToString(int[] ints) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <ints.length ; i++) {
            //ints[i]= code.Cipher.toInt(text.charAt(i),code.Cipher.alphabet256);
            stringBuilder.append(Cipher.alphabet256[ints[i]]);
        }
        return stringBuilder.toString();
    }

    static int[] stringArrToIntArr(String[] strings){
        int[] ints = new int[strings.length];
        for (int i = 0; i < ints.length; i++) {
            ints[i]=Integer.parseInt(strings[i],2);
        }
        return ints;
    }

    static int[] stringToIntArr(String text){
        text=Cipher.filter(text,Cipher.alphabet256);
        int[] ints = new int[text.length()];
        for (int i = 0; i <ints.length ; i++) {
            ints[i]= Cipher.toInt(text.charAt(i),Cipher.alphabet256);
        }
        return ints;
    }

    static String[] stringToIntStrArr(String text){
        text=Cipher.filter(text,Cipher.alphabet256);
        String[] ints = new String[text.length()];
        for (int i = 0; i <ints.length ; i++) {
            ints[i]= Integer.toBinaryString(Cipher.toInt(text.charAt(i),Cipher.alphabet256));
        }
        return ints;
    }

    static String[] intArrToIntStrArr(int[] ints){
        String[] strings = new String[ints.length];
        for (int i = 0; i <ints.length ; i++) {
            strings[i]= Integer.toBinaryString(ints[i]);
        }
        return strings;
    }


    static int[] rand(int[] ints){
        return rand(ints,256);
    }

    static int[] rand(int[] ints, int m){
        for (int i = 0; i <ints.length ; i++) {
            int n= (int)(Math.random()*(100000000/m));
            ints[i]+= n*m;
        }
        return ints;
    }

    static int[] unrand(int[] ints, int m){
        for (int i = 0; i <ints.length ; i++) {
            ints[i] = ints[i]%m;
        }
        return ints;
    }

    static String[] strRand(int[] ints){
        return strRand(ints,256);
    }

    static String[] strRand(int[] ints, int m){
        String[] strings= new String[ints.length];
        for (int i = 0; i <ints.length ; i++) {
            int n= (int)(Math.random()*(100000000/m));
            strings[i] = Integer.toBinaryString(n*m+ints[i]);
        }
        return strings;
    }

    static int[] fut(int[] ints){
        for (int i = 1; i < ints.length ; i++) {
            ints[i]= (ints[i-1]+ints[i])%307;
        }
        return ints;
    }

    static int[] unfut(int[] ints){
        int[] ret =ints;
        for (int i = ints.length-1; i > 1 ; i--) {
            ints[i]= (ints[i]-ints[i-1]+307000)%307;
        }
        return ret;
    }

    int[] futCiph(int[] ints){
        int n=0;
        for (int i = 0; i < key.length(); i++) {
            n+=Cipher.toInt(key.charAt(i),Cipher.alphabet256);
        }
        ints[0]=(ints[0]+n)%307;
        for (int i = 1; i < ints.length ; i++) {
            ints[i]= (ints[i-1]+ints[i]+n)%307;
        }
        return ints;
    }

     int[] unfutCiph(int[] ints){
        int n=0;
        for (int i = 0; i < key.length(); i++) {
            n+=Cipher.toInt(key.charAt(i),Cipher.alphabet256);
        }
         int[] ret =ints;
         for (int i = ints.length-1; i > 0 ; i--) {
             ret[i]= (ints[i]-ints[i-1]-n+307000)%307;
         }
         ret[0] = (ints[0]-n+3070)%307;
        return ret;
    }

    int findM(){
        int n=0;
        for (int i = 0; i < key.length(); i++) {
            n+=Cipher.toInt(key.charAt(i),Cipher.alphabet256);
        }
        return Cipher.primes[n%37];
    }

    int[] futCiph2(int[] ints){
        int[] n=new int[key.length()];
        for (int i = 0; i < key.length(); i++) {
            for (int j = 0; j < key.length() ; j++) {
                n[j]+=Cipher.toInt(key.charAt((i+j)%key.length()),Cipher.alphabet256);
            }
        }
        int m = n[0]%37;
        ints[0]=(ints[0]+n[0])%Cipher.primes[m];
        for (int i = 1; i < ints.length && i < key.length() ; i++) {
            ints[i] = (ints[i-1]+ ints[i]+n[i])%Cipher.primes[m];
        }
        for (int i = key.length(); i < ints.length ; i++) {
            ints[i]= (ints[i-key.length()]+ints[i]+n[i%key.length()])%Cipher.primes[m];
        }
        return ints;
    }

    int[] unfutCiph2(int[] ints){
        int[] n=new int[key.length()];
        for (int i = 0; i < key.length(); i++) {
            for (int j = 0; j < key.length() ; j++) {
                n[j]+=Cipher.toInt(key.charAt((i+j)%key.length()),Cipher.alphabet256);
            }
        }
        int m = n[0]%37;
        int[] ret =ints;
        if(ints.length>key.length()){
            for (int i = ints.length-1; i > key.length()-1 ; i--) {
                ret[i]= (ints[i]-ints[i-key.length()]-n[i%key.length()]+Cipher.primes[m]*1000)%Cipher.primes[m];
            }
            for (int i = key.length()-1; i >0 ; i--) {
                ret[i] = (ints[i]-ints[i-1]-n[i]+Cipher.primes[m]*1000)%Cipher.primes[m];
            }
        }else {
            for (int i = ints.length-1; i >0 ; i--) {
                ret[i] = (ints[i]-ints[i-1]-n[i]+Cipher.primes[m]*1000)%Cipher.primes[m];
            }
        }
        ret[0] = (ints[0]-n[0]+Cipher.primes[m]*100)%Cipher.primes[m];
        return ret;
    }

}
