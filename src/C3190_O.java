import java.util.*;
import java.io.*;

public class C3190_O {

    public static class TimeAndDirect {
        int time;
        String Direct;
    }

    public static class Coordinate {
        public int x;
        public int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void move(int dir, Coordinate coord) {
        // 1: 위, 2: 오른쪽, 3: 아래, 4: 왼쪽
        switch (dir) {
            case 1: coord.y -= 1; break;
            case 2: coord.x += 1; break;
            case 3: coord.y += 1; break;
            case 4: coord.x -= 1; break;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int mapSize = Integer.parseInt(br.readLine());
        int appleNum = Integer.parseInt(br.readLine());

        int[][] map = new int[mapSize][mapSize]; // 0: 빈칸, 1: 몸, 2: 사과

        for (int i = 0; i < appleNum; i++) {
            String[] str = br.readLine().split(" ");
            int y = Integer.parseInt(str[0]) - 1; // 1-based → 0-based
            int x = Integer.parseInt(str[1]) - 1;
            map[y][x] = 2;
        }

        int changeDir = Integer.parseInt(br.readLine());
        Deque<TimeAndDirect> dq = new LinkedList<>();

        for (int i = 0; i < changeDir; i++) {
            String[] str = br.readLine().split(" ");
            TimeAndDirect tad = new TimeAndDirect();
            tad.time = Integer.parseInt(str[0]);
            tad.Direct = str[1];
            dq.addLast(tad);
        }

        int time = 0;
        int dir = 2; // 시작 방향: 오른쪽
        Deque<Coordinate> snake = new LinkedList<>();
        snake.addFirst(new Coordinate(0, 0));
        map[0][0] = 1; // 뱀 시작 위치

        while (true) {

            // 다음 머리 위치 계산
            Coordinate head = snake.peekFirst();
            Coordinate next = new Coordinate(head.x, head.y);
            move(dir, next);

            // 범위 밖이거나 자기 몸에 부딪히면 게임 종료
            if (next.x < 0 || next.x >= mapSize || next.y < 0 || next.y >= mapSize || map[next.y][next.x] == 1) {
                System.out.println(time+1);
                break;
            }

            // 사과가 있다면: 몸 길이 늘리고 사과 제거
            if (map[next.y][next.x] == 2) {
                map[next.y][next.x] = 1;
                snake.addFirst(next);
            }
            // 사과 없으면: 머리 늘리고 꼬리 줄임
            else {
                map[next.y][next.x] = 1;
                snake.addFirst(next);
                Coordinate tail = snake.removeLast();
                map[tail.y][tail.x] = 0;
            }

            time++;

            // 방향 전환 처리
            if (!dq.isEmpty() && dq.peekFirst().time == time) {
                String d = dq.pollFirst().Direct;
                if (d.equals("L")) {
                    dir = (dir == 1) ? 4 : dir - 1;
                } else if (d.equals("D")) {
                    dir = (dir == 4) ? 1 : dir + 1;
                }
            }

        }
    }
}
