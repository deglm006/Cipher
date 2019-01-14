package code;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class test {
    String plaintext1;
    String plaintext2;
    String plaintext;
    String plaintext3;


    @Before
    public void before(){
        plaintext1 = "ingeoingvewiofewi;,rp31ew8 ir3bdj7^%$%ERTFGHIUYTSEXCTRG4irndu3nmewmdon3fbf";
        plaintext = "bnevuenvneuvnueineieffnewnuifn";
        plaintext2= "ABCDEF1234567890";
    }


    @Test
    public void transpositionCipher(){
        TranspositionCipher transpositionCipher= new TranspositionCipher("key");
        assert(transpositionCipher.decipher(transpositionCipher.encipher(plaintext)).substring(0,plaintext.length()).equals(plaintext));
    }

    @Test
    public void transpositionCipher256(){
        TranspositionCipher transpositionCipher= new TranspositionCipher("key",Cipher.alphabet256);
        assert(transpositionCipher.decipher(transpositionCipher.encipher(plaintext1)).substring(0,plaintext1.length()).equals(plaintext1));
    }

    @Test
    public void transpositionCipher256a(){
        TranspositionCipher transpositionCipher= new TranspositionCipher("IUBFBhf nw7&*T674",Cipher.alphabet256);
        assert(transpositionCipher.decipher(transpositionCipher.encipher(plaintext1)).substring(0,plaintext1.length()).equals(plaintext1));
    }

    @Test
    public void substitutionCipher(){
        SubstitutionCipher substitutionCipher=new SubstitutionCipher("key");
        assert(substitutionCipher.decipher(substitutionCipher.encipher(plaintext)).equals(plaintext));
    }

    @Test
    public void substitutionCipher16(){
        SubstitutionCipher substitutionCipher=new SubstitutionCipher("12382F",Cipher.alphabet16);
        System.out.println(plaintext2);
        System.out.println(substitutionCipher.encipher(plaintext2));
        System.out.println(substitutionCipher.decipher(substitutionCipher.encipher(plaintext2)));
        assert(substitutionCipher.decipher(substitutionCipher.encipher(plaintext2)).equals(plaintext2));
    }

    @Test
    public void substitutionCipher16null(){
        SubstitutionCipher substitutionCipher=new SubstitutionCipher("0",Cipher.alphabet16);
        System.out.println(plaintext2);
        System.out.println(substitutionCipher.encipher(plaintext2));
        System.out.println(substitutionCipher.decipher(substitutionCipher.encipher(plaintext2)));
        assert(substitutionCipher.decipher(substitutionCipher.encipher(plaintext2)).equals(plaintext2));
    }

    @Test
    public void substitutionCipher16alphabet(){
        SubstitutionCipher substitutionCipher=new SubstitutionCipher("12382F",Cipher.alphabet16);
        char[] alph = {'1','2','3','8','F','0','4','5','6','7','9','A','B','C','D','E'};
        assert(Arrays.equals(substitutionCipher.alphabet,alph));
    }

    @Test
    public void substitutionCipher16nullAlphabet(){
        SubstitutionCipher substitutionCipher=new SubstitutionCipher("0",Cipher.alphabet16);
        assert(Arrays.equals(substitutionCipher.alphabet,Cipher.alphabet16));
        System.out.println(plaintext2);
        System.out.println(substitutionCipher.encipher(plaintext2));
        System.out.println(substitutionCipher.decipher(substitutionCipher.encipher(plaintext2)));
        assert(substitutionCipher.encipher(plaintext2).equals(plaintext2));
    }

    @Test
    public void substitutionCipher256(){
        SubstitutionCipher substitutionCipher=new SubstitutionCipher("key",Cipher.alphabet256);
        System.out.println(plaintext2);
        System.out.println(substitutionCipher.encipher(plaintext2));
        System.out.println(substitutionCipher.decipher(substitutionCipher.encipher(plaintext2)));
        System.out.println(plaintext1);
        System.out.println(substitutionCipher.encipher(plaintext1));
        System.out.println(substitutionCipher.decipher(substitutionCipher.encipher(plaintext1)));
        assert(substitutionCipher.decipher(substitutionCipher.encipher(plaintext1)).equals(plaintext1));
    }

    @Test
    public void substitutionCipher256null(){
        SubstitutionCipher substitutionCipher=new SubstitutionCipher(" ",Cipher.alphabet256);
        System.out.println(plaintext2);
        System.out.println(substitutionCipher.encipher(plaintext2));
        System.out.println(substitutionCipher.decipher(substitutionCipher.encipher(plaintext2)));
        System.out.println(plaintext);
        System.out.println(substitutionCipher.encipher(plaintext));
        System.out.println(substitutionCipher.decipher(substitutionCipher.encipher(plaintext)));
        System.out.println(plaintext1);
        System.out.println(substitutionCipher.encipher(plaintext1));
        System.out.println(substitutionCipher.decipher(substitutionCipher.encipher(plaintext1)));
        assert(Arrays.equals(substitutionCipher.alphabet,Cipher.alphabet256));
        assert(substitutionCipher.encipher(plaintext).equals(plaintext));
        assert(substitutionCipher.encipher(plaintext2).equals(plaintext2));
        assert(substitutionCipher.encipher(plaintext1).equals(plaintext1));
        assert(substitutionCipher.decipher(substitutionCipher.encipher(plaintext1)).equals(plaintext1));
    }

    @Test
    public void vigenereCipher(){
        VigenereCipher vigenereCipher=new VigenereCipher("key");
        assert(vigenereCipher.decipher(vigenereCipher.encipher(plaintext)).equals(plaintext));
    }

    @Test
    public void vigenereCipher16(){
        VigenereCipher vigenereCipher=new VigenereCipher("4F64A",Cipher.alphabet16);
        System.out.println(plaintext2);
        System.out.println(vigenereCipher.encipher(plaintext2));
        System.out.println(vigenereCipher.decipher(vigenereCipher.encipher(plaintext2)));
        assert(vigenereCipher.decipher(vigenereCipher.encipher(plaintext2)).equals(plaintext2));
    }

    @Test
    public void vigenereCipher16null(){
        VigenereCipher vigenereCipher=new VigenereCipher("0",Cipher.alphabet16);
        System.out.println(plaintext2);
        System.out.println(vigenereCipher.encipher(plaintext2));
        System.out.println(vigenereCipher.decipher(vigenereCipher.encipher(plaintext2)));
        assert(vigenereCipher.decipher(vigenereCipher.encipher(plaintext2)).equals(plaintext2));
    }

    @Test
    public void vigenereCipher256(){
        VigenereCipher vigenereCipher=new VigenereCipher("key",Cipher.alphabet256);
        System.out.println(plaintext1);
        System.out.println(vigenereCipher.encipher(plaintext1));
        System.out.println(vigenereCipher.decipher(vigenereCipher.encipher(plaintext1)));
        assert(vigenereCipher.decipher(vigenereCipher.encipher(plaintext1)).equals(plaintext1));
    }

    @Test
    public void vigenereCipher256null(){
        VigenereCipher vigenereCipher=new VigenereCipher(" ",Cipher.alphabet256);
        System.out.println(plaintext1);
        System.out.println(vigenereCipher.encipher(plaintext1));
        System.out.println(vigenereCipher.decipher(vigenereCipher.encipher(plaintext1)));
        assert(vigenereCipher.decipher(vigenereCipher.encipher(plaintext1)).equals(plaintext1));
    }

    @Test
    public void polybius(){
        Polybius polybius= new Polybius();
        assert(polybius.decode(polybius.encode(plaintext)).equals(plaintext));
    }

    @Test
    public void polybius256(){
        Polybius polybius= new Polybius(Cipher.alphabet256,Cipher.alphabet16);
        assert(polybius.decode(polybius.encode(plaintext1)).equals(plaintext1));
    }

    @Test
    public void filter(){
        assert(Cipher.filter("ABCDE","ABCDE").equals("ABCDE"));
        assert(Cipher.filter("ABCDE",Cipher.alphabet16).equals("ABCDE"));
        assert(Cipher.filter("ABCDE",Cipher.alphabet).equals(""));
        assert(Cipher.filter("ABCDE",Cipher.alphabet256).equals("ABCDE"));
    }

    @Test
    public void fut(){
        int[] ints ={1,2,3,4,5,6,78,24};
        assert(Arrays.equals(ints,Comp.unfut(Comp.fut(ints)) ));
        ints = new int[]{12, 2, 3, 24, 255, 6, 238, 24,4};
        assert(Arrays.equals(ints,Comp.unfut(Comp.fut(ints)) ));
    }

    @Test
    public void futCiph(){
        int[] ints ={1,2,3,4,5,6,78,24};
        Comp comp = new Comp("key");
        assert(Arrays.equals(ints,comp.unfutCiph(comp.futCiph(ints)) ));
        ints = new int[]{12, 2, 3, 24, 255, 6, 238, 24,4};
        assert(Arrays.equals(ints,comp.unfutCiph(comp.futCiph(ints)) ));

        ints =new int[]{1,2,3,4,5,6,78,24,65,242,};
        comp = new Comp("nvegt98hg73wHBU.");
        assert(Arrays.equals(ints,comp.unfutCiph(comp.futCiph(ints)) ));
        ints = new int[]{12, 2, 3, 24, 255, 6, 238, 24,4,300,0};
        assert(Arrays.equals(ints,comp.unfutCiph(comp.futCiph(ints)) ));
    }

    @Test
    public void futCiph2(){
        int[] ints ={1,2,3,4,5,6,78,24};
        Comp comp = new Comp("key");
        assert(Arrays.equals(ints,comp.unfutCiph2(comp.futCiph2(ints)) ));
        ints = new int[]{12, 2, 3, 24, 255, 6, 238, 24,4};
        assert(Arrays.equals(ints,comp.unfutCiph2(comp.futCiph2(ints)) ));

        ints =new int[]{1,2,3,4,5,6,78,24,65,242,};
        comp = new Comp("nvegt98hg73wHBU.");
        assert(Arrays.equals(ints,comp.unfutCiph2(comp.futCiph2(ints)) ));
        ints = new int[]{12, 2, 3, 24, 255, 6, 238, 24,4,300,0};
        assert(Arrays.equals(ints,comp.unfutCiph2(comp.futCiph2(ints)) ));

        ints =new int[]{1,2,3,4,5,6,78,24,65,242,};
        comp = new Comp("This is a good key.");
        assert(Arrays.equals(ints,comp.unfutCiph2(comp.futCiph2(ints)) ));
        ints = new int[]{12, 2, 3, 24, 255, 6, 238, 24,4,300,0};
        assert(Arrays.equals(ints,comp.unfutCiph2(comp.futCiph2(ints)) ));
    }

    @Test
    public void rand(){
        int[] ints ={1,2,3,4,5,6,78,24};
        assert(Arrays.equals(ints,Comp.unrand(Comp.rand(ints,307),307) ));
        ints = new int[]{12, 2, 3, 24, 255, 6, 238, 24,4,287,146,32,305};
        assert(Arrays.equals(ints,Comp.unrand(Comp.rand(ints,307),307) ));
    }


}
