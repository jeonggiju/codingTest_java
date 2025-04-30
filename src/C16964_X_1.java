    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.ArrayList;

    public class C16964_X_1 {
        public static boolean[] visited;
        public static ArrayList[] graph;
        public static String target;
        public static int vertexNum;

        public static void dfs(int startVertex, int depth, String currentString){

            if(depth == vertexNum){
                currentString = currentString.strip();
                if(currentString.equals(target)){
                    System.out.print(1);
                    System.exit(1);
                }else{
                    return;
                }
            }

            visited[startVertex]=true;
            currentString += (startVertex+1) + " ";

            for(Object nextVertex : graph[startVertex]){
                if(!visited[(int)nextVertex]){
                    dfs((int)nextVertex, depth+1, currentString);
                }
            }
            visited[startVertex]=false;
        }

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            vertexNum = Integer.parseInt(br.readLine());
            visited = new boolean[vertexNum];
            String[] inp;


            graph = new ArrayList[vertexNum];

            for(int i = 0 ; i < vertexNum ; i++){
                graph[i] = new ArrayList<Integer>();
            }

            for(int i = 0 ; i < vertexNum-1 ;i++){
                inp = br.readLine().split(" ");

                int startVertex = Integer.parseInt(inp[0])-1;
                int endVertex = Integer.parseInt(inp[1])-1;

                graph[startVertex].add(endVertex);
                graph[endVertex].add(startVertex);
            }

            target= br.readLine();

            dfs(0, 0, "");

            System.out.print(0);

        }
    }
