// 시간 초과

import java.util.*;

public class C10799_X_2 {
    // 이 부분 뺴니까 되네 씨이이잉펄
    public static void plusOne(Stack<Integer> st){
        for(int i = 0 ; i < st.size(); i++){
            st.set(i, st.get(i) + 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        int count  = 0;
        Stack<Integer> st= new Stack<>();

        for(int i = 0 ; i< str.length() ; i++){
            char c =  str.charAt(i);

            if(c == '(' && str.charAt(i+1) == ')'){ // 레이저인 경우
                plusOne(st);
                i++;
            }
            else if(c == '('){ // 막대기 추가
                st.push(1);
            }else{
                count += st.pop();
            }
        }
        System.out.println(count);
    }
}
