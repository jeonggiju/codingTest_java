import java.util.*;
import java.io.*;
public class C17298_X_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int len = Integer.parseInt(br.readLine());

        Deque<Integer> leftSt = new ArrayDeque<>();
        List<Integer> rightList = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        String[] str =  br.readLine().split(" ");

        // 입력 데이터 왼쪽 스택에 넣기
        for(int i = 0 ; i < len ; i++){
            leftSt.addLast(Integer.parseInt(str[i]));
        }

        for(int i = 0 ; i < len ; i++){
            int curVal = leftSt.pollLast();

            // 제일 오른쪽 값
            result.add(-1);

            for(int j = rightList.size()-1; j >= 0 ; j--){
                int rightValue = rightList.get(j);
                if(curVal < rightValue){
                    result.set(i, rightValue);
                    break;
                }
            }
            // 현재의 값을 추가.
            rightList.add(curVal);
        }

        // 출력 형식 다듬기
        StringBuilder sb = new StringBuilder();
        for (int i = result.size() - 1; i >= 0; i--) {
            sb.append(result.get(i)).append(" ");
        }

        System.out.println(sb.toString().trim());  // 마지막 공백 제거
    }
}
