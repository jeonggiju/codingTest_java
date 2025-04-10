import java.util.*;

public class C1002_con {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt(); // 개행문자
        sc.nextLine();
        int[][] nums = new int[num][6];

        for(int i = 0 ; i  < nums.length ; i++){
            String s = sc.nextLine();
            nums[i] = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for(int i = 0 ; i < nums.length ; i++){
            // 점이 겹치는 경우
            if(nums[i][0] == nums[i][3] && nums[i][1] == nums[i][4] && nums[i][2] == nums[i][5]){
                System.out.println(-1);
            }

            // 두 중점 사이 거리
            double dis = Math.sqrt(Math.pow(nums[i][0]-nums[i][3],2) + Math.pow(nums[i][1]-nums[i][4],2));


        }

    }
}
