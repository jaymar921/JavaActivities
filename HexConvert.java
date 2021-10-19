public class HexConvert {
    //convert string into hexadecimal value
    public static String toHex(String str){
        StringBuilder sb = new StringBuilder();
        //Converting string to character array
        char[] ch = str.toCharArray();
        for (char c : ch) {
            String hexString = Integer.toHexString(c);
            sb.append(hexString);
        }
        return sb.toString();
    }
    //convert hexadecimal value into string
    public static String fromHex(String str){
        StringBuilder result = new StringBuilder();
        char[] charArray = str.toCharArray();
        for(int i = 0; i < charArray.length; i=i+2) {
            String st = ""+charArray[i]+""+charArray[i+1];
            char ch = (char)Integer.parseInt(st, 16);
            result.append(ch);
        }
        return result.toString();

    }
}
