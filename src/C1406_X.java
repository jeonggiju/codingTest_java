import java.util.*;

public class C1406_X {
    public static void main(String[] args){
        Stack<Character> stLeft = new Stack<>();
        Stack<Character> stRight = new Stack<>();
        Scanner sc = new Scanner(System.in);

        // 초기 문자열 입력
        char[] cArr = sc.nextLine().toCharArray();
        for(char c : cArr){
            stLeft.push(c);
        }

        // 명령 개수
        int num = sc.nextInt();
        sc.nextLine(); // 개행 제거

        for(int i = 0 ; i < num ; i++){
            String str = sc.nextLine();
            char keyword = str.charAt(0);

            switch(keyword){
                case 'L':
                    if(!stLeft.isEmpty()){
                        stRight.push(stLeft.pop());
                    }
                    break;

                case 'D':
                    if(!stRight.isEmpty()){
                        stLeft.push(stRight.pop());
                    }
                    break;

                case 'B':
                    if(!stLeft.isEmpty()){
                        stLeft.pop();
                    }
                    break;

                case 'P':
                    stLeft.push(str.charAt(2));
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!stLeft.isEmpty()){
            sb.append(stLeft.pop());
        }
        sb.reverse();

        while(!stRight.isEmpty()){
            sb.append(stRight.pop());
        }

        System.out.println(sb.toString());
    }
}
