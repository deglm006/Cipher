package code;

public class Polybius {
    private String key="";
    private char[][] square;
    private char[] alphabet1;
    private char[] alphabet2;

    Polybius(){
        this(Cipher.alphabet36,Cipher.alphabet6);
    }

    Polybius(char[] alphabet1, char[] alphabet2){
        this.alphabet1=alphabet1;
        this.alphabet2=alphabet2;
        createSquare();
    }

    Polybius(String key){
        this(key,Cipher.alphabet36,Cipher.alphabet6);
    }

    Polybius(String key,char[] alphabet1, char[] alphabet2){
        this.key=key;
        this.alphabet1=alphabet1;
        this.alphabet2=alphabet2;
        createSquare();
    }

    //private void createSquare()[]
    private void createSquare(){
        square = new char[alphabet2.length][alphabet2.length];
        int j =0;
        for (int i = 0; i < key.length(); i++) {
            if (!key.substring(0, i).contains(Character.toString(key.charAt(i)))) {
                square[j / alphabet2.length][j % alphabet2.length] = key.charAt(i);
                j++;
            }
        }
        for (int i = 0; i < alphabet1.length; i++) {
            if (!key.contains(Character.toString(alphabet1[i]))) {
                square[j/alphabet2.length][j%alphabet2.length] = alphabet1[i];
                j++;
            }
        }
    }

    String encode(String text){
        text = Cipher.filter(text,alphabet1);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0;i<text.length();i++){
            stringBuilder.append(find(text.charAt(i)));
        }
        return stringBuilder.toString();
    }

    String decode(String text) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < text.length(); i+=2) {
            int k = Cipher.toInt(text.charAt(i-1),alphabet2,i-1+": "+text.charAt(i-1));
            int n = Cipher.toInt(text.charAt(i),alphabet2,i+": "+text.charAt(i));
            char c = square[k][n];
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    private String find(char c){
        String s = "";
        for (int i = 0; i < alphabet2.length; i++) {
            for (int j = 0; j < alphabet2.length; j++) {
                if(square[i][j]==c){
                    s=alphabet2[i]+""+alphabet2[j];
                }
            }
        }
        return s;
    }
}