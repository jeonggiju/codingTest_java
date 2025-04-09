// 시간 초과

import java.util.*;

public class C10799_X {
    public static void plusOne(Stack<Integer> st){
        for(int i = 0 ; i < st.size(); i++){
            st.set(i, st.get(i) + 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().replace("()", "R").replace("(", "1");

        int count  = 0;
        Stack<Integer> st= new Stack<>();

        for(int i = 0 ; i< str.length() ; i++){
            char c =  str.charAt(i);
            if(c == 'R'){
                plusOne(st);
            }else if(c == ')'){
                count += st.pop();
            }else{
                st.push(Integer.parseInt(String.valueOf(c)));
            }
        }
        System.out.println(count);
    }
}
