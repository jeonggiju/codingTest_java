import java.io.BufferedReader;
import java.io.CharArrayReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C15486 {
    public static Element[][] dp;

    public static class Element{
        public int value;
        public int arrow; // 1 : 왼쪽, 2 : 위쪽, 3 : 왼위쪽

        public Element(int value, int arrow){
            this.value = value;
            this.arrow = arrow;
        }
    }

    public static void lcs(String first, String second){
        for(int i = 1 ; i <= first.length(); i++){
            char fc = first.charAt(i-1);
            for(int j = 1 ; j <= second.length() ; j++){
                char sc = second.charAt(j-1);
                if(fc == sc){
                    dp[i][j].value = dp[i-1][j-1].value + 1;
                    dp[i][j].arrow = 3;
                }
                else if(dp[i-1][j].value >= dp[i][j-1].value){
                    dp[i][j].value = dp[i-1][j].value;
                    dp[i][j].arrow = 2;
                }else{
                    dp[i][j].value = dp[i][j-1].value;
                    dp[i][j].arrow = 1;
                }
            }
        }
    }

    public static char[] printLsc(String first, String second){
        int maxLength = dp[first.length()][second.length()].value;
        char[] ch = new char[maxLength];

        Element current = dp[first.length()][second.length()];
        int i = first.length();
        int j = second.length();
        int idx = ch.length-1;

        while(true){
            // 탈출 조건
            if(current.value == 0){
                break;
            }
            // 왼쪽
            if(current.arrow == 1) {
                current = dp[i][--j];
            }
            // 위쪽
            else if(current.arrow == 2){
                current = dp[--i][j];
            }

            // 왼위쪽
            else if(current.arrow == 3){
                 ch[idx--] = first.charAt(--i);
                current = dp[  i][--j];
            }
        }




        return ch;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String first = br.readLine();
        String second = br.readLine();

        dp = new Element[first.length()+1][second.length()+1];

        for(int i = 0 ; i <= first.length(); i++){
            for(int j = 0 ; j <= second.length(); j++){
                dp[i][j] = new Element(0, 0);
            }
        }

        lcs(first, second);
        char[] res = printLsc(first, second);

//        for(int i = 0 ; i < res.length; i++){
//            System.out.println(res[i]);
//        }

        System.out.println(dp[first.length()][second.length()].value);
        System.out.println(String.valueOf(res));
    }
}
