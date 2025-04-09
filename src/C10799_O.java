import java.util.Scanner;
import java.util.Stack;

public class C10799_O {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        int count  = 0;
        Stack<Integer> st= new Stack<>();

        for(int i = 0 ; i< str.length() ; i++){
            char c =  str.charAt(i);

            if(c == '(' && str.charAt(i+1) == ')'){ // 레이저인 경우
                count += st.size();
                i++;
            }
            else if(c == '('){ // 막대기 추가
                st.push(1);
            }else{
                count += 1;
                st.pop();
            }
        }
        System.out.println(count);
    }
}
