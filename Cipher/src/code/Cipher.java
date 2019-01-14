package code;

class Cipher {
    static char[] alphabet6 = {'0','1','2','3','4','5'};
    static char[] alphabet16 ={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
    static char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    static char[] alphabet36 = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v',
            'w','x','y','z','0','1','2','3','4','5','6','7','8','9'};
    static char[] alphabet41 = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v',
            'w','x','y','z','0','1','2','3','4','5','6','7','8','9',' ',',','.','!','?'};
    static char[] alphabet49 = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v',
            'w','x','y','z','0','1','2','3','4','5','6','7','8','9',' ',',','.','!','?','@','#','$','%','^','&','*','/'};
    static char[] alphabet256 = {'\u0020','\u0021','\u0022','\u0023','\u0024','\u0025','\u0026','\'','\u0028','\u0029','\u002A','\u002B','\u002C','\u002D','\u002E','\u002F','\u0030','\u0031','\u0032','\u0033','\u0034','\u0035','\u0036','\u0037','\u0038','\u0039','\u003A','\u003B','\u003C','\u003D','\u003E','\u003F','\u0040','\u0041','\u0042','\u0043','\u0044','\u0045','\u0046','\u0047','\u0048','\u0049','\u004A','\u004B','\u004C','\u004D','\u004E','\u004F','\u0050','\u0051','\u0052','\u0053','\u0054','\u0055','\u0056','\u0057','\u0058','\u0059','\u005A','\u005B','\\','\u005D','\u005E','\u005F','\u0060','\u0061','\u0062','\u0063','\u0064','\u0065','\u0066','\u0067','\u0068','\u0069','\u006A','\u006B','\u006C','\u006D','\u006E','\u006F','\u0070','\u0071','\u0072','\u0073','\u0074','\u0075','\u0076','\u0077','\u0078','\u0079','\u007A','\u007B','\u007C','\u007D','\u007E','\u00B0','\u00B1','\u00B2','\u00B3','\u00B4','\u00B5','\u00B6','\u00B7','\u00B8','\u00B9','\u00BA','\u00BB','\u00BC','\u00BD','\u00BE','\u00BF','\u00C0','\u00C1','\u00C2','\u00C3','\u00C4','\u00C5','\u00C6','\u00C7','\u00C8','\u00C9','\u00CA','\u00CB','\u00CC','\u00CD','\u00CE','\u00CF','\u00D0','\u00D1','\u00D2','\u00D3','\u00D4','\u00D5','\u00D6','\u00D7','\u00D8','\u00D9','\u00DA','\u00DB','\u00DC','\u00DD','\u00DE','\u00DF','\u00E0','\u00E1','\u00E2','\u00E3','\u00E4','\u00E5','\u00E6','\u00E7','\u00E8','\u00E9','\u00EA','\u00EB','\u00EC','\u00ED','\u00EE','\u00EF','\u00F0','\u00F1','\u00F2','\u00F3','\u00F4','\u00F5','\u00F6','\u00F7','\u00F8','\u00F9','\u00FA','\u00FB','\u00FC','\u00FD','\u00FE','\u00FF','\u0100','\u0101','\u0102','\u0103','\u0104','\u0105','\u0106','\u0107','\u0108','\u0109','\u010A','\u010B','\u010C','\u010D','\u010E','\u010F','\u0110','\u0111','\u0112','\u0113','\u0114','\u0115','\u0116','\u0117','\u0118','\u0119','\u011A','\u011B','\u011C','\u011D','\u011E','\u011F','\u0120','\u0121','\u0122','\u0123','\u0124','\u0125','\u0126','\u0127','\u0128','\u0129','\u012A','\u012B','\u012C','\u012D','\u012E','\u012F','\u0130','\u0131','\u0132','\u0133','\u0134','\u0135','\u0136','\u0137','\u0138','\u0139','\u013A','\u013B','\u013C','\u013D','\u013E','\u013F','\u0140','\u0141','\u0142','\u0143','\u0144','\u0145','\u0146','\u0147','\u0148','\u0149','\u014A','\u014B','\u014C','\u014D','\u014E','\u014F','\u0150'};

    static int[] primes = {313,317,331,337,347,349,353,359,367,373,379,383,389,397,401,409,419,421,431,433,439,443,449,457,461,463,467,479,487,491,499,503,509,521,523,541,547};

    static String filter(String text){
        return filter(text, "abcdefghijklmnopqrstuvwxyz");
    }

    static String filter(String text, char[] alphabet){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < text.length(); i++){
            for (int j = 0; j < alphabet.length ; j++) {
                if (alphabet[j]==text.charAt(i)) {
                    stringBuilder.append(text.charAt(i));
                    break;
                }
            }
        }
        return stringBuilder.toString();
    }

    /*static String filter(String text, char[] alphabet){
        StringBuilder stringBuilder = new StringBuilder();
        for (char c: alphabet) {
            stringBuilder.append(c);
        }
        return filter(text, stringBuilder.toString());
    }*/

    static String filter(String text, String chars){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < text.length(); i++){
            if(chars.contains(Character.toString(text.charAt(i)))){
                stringBuilder.append(text.charAt(i));
            }
        }
        return stringBuilder.toString();
    }

    static int toInt(char c) {
        return toInt(c,alphabet);
    }

    static int toInt(char c, char[] alphabet)  {
        for (int i = 0; i < alphabet.length; i++) if (c == alphabet[i]) return i;
        new Exception().printStackTrace();
        return -1;
    }
    static int toInt(char c, char[] alphabet,String str)  {
        for (int i = 0; i < alphabet.length; i++) if (c == alphabet[i]) return i;
        System.out.println(str);
        new Exception().printStackTrace();
        return -1;
    }

}
