package code;

import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        //code.SubstitutionCipher s = new code.SubstitutionCipher("Joe");
        //code.SubstitutionCipher t = new code.SubstitutionCipher("Molly");
        //code.SubstitutionCipher u = new code.SubstitutionCipher("Mississippi");
        //String n = u.encipher(t.encipher(s.encipher("Attack at dawn.")));
        //String str = "abcdefghijklmnopqrstuvwxyz";
        //for(int i=0; i<25;i++){
            //code.VigenereCipher s = new code.VigenereCipher(str.substring(i,i+1));
            //code.SubstitutionCipher s = new code.SubstitutionCipher(str.substring(i,i+2));
            //code.TranspositionCipher s = new code.TranspositionCipher("bca");
            //String n = s.encipher(str);
            //code.Polybius polybius = new code.Polybius();
            //String n = polybius.encode("bat");
            //System.out.println(n);
            //System.out.println(polybius.decode(n));
            //System.out.println(s.decipher(n));
        //}
        //System.out.println(s.decipher(t.decipher(u.decipher(n))));
        /*for (int i = 0x20; i < 0x7F ; i++) {
            System.out.print(String.format("\'\\u%04X\',",i));
        }
        for (int i = 0xB0; i < 0x151 ; i++) {
            System.out.print(String.format("\'\\u%04X\',",i));
        }*/
        //System.out.println(code.Cipher.alphabet256.length);
        Comp comp=new Comp("This is a good key.");
        /*String string=comp.encipher("Hi");
        System.out.println(string);
        System.out.println(Arrays.toString(code.Comp.stringToIntArr(string)));
        System.out.println(Arrays.toString(code.Comp.stringToIntStrArr(string)));
        System.out.println(Arrays.toString(code.Comp.fut(code.Comp.stringToIntArr(string))));
        System.out.println(Arrays.toString(code.Comp.unfut(code.Comp.fut(code.Comp.stringToIntArr(string)))));
        //System.out.println(Arrays.toString(comp.strRand(comp.stringToIntArr(string))));
        String str= comp.decipher(string);
        System.out.println(str);
        System.out.println(Arrays.toString(code.Comp.stringToIntArr(str)));
        System.out.println(Arrays.toString(code.Comp.stringToIntStrArr(str)));
        System.out.println(Arrays.toString(code.Comp.fut(code.Comp.stringToIntArr(str))));
        System.out.println(Arrays.toString(code.Comp.unfut(code.Comp.fut(code.Comp.stringToIntArr(str)))));*/
        //System.out.println(Arrays.toString(comp.strRand(comp.stringToIntArr(str))));
        System.out.println(Arrays.toString(comp.encipher2("Hi.")));
        System.out.println(Arrays.toString(comp.encipher2dec("Hi.")));
        System.out.println(comp.decipher2(comp.encipher2("Hi.")));

        System.out.println(Arrays.toString(comp.encipher3("Hi.")));
        System.out.println(Arrays.toString(comp.encipher3dec("Hi.")));
        System.out.println(comp.decipher3(comp.encipher3("Hi.")));

        System.out.println(Arrays.toString(comp.encipher4("Hi.")));
        System.out.println(Arrays.toString(comp.encipher4dec("Hi.")));
        System.out.println(comp.decipher4(comp.encipher4("Hi.")));
    }
}
