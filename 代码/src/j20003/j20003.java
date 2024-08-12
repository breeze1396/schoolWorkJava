package j20003;
import java.util.*;
/*
0  1  2 3  4  -1 6  7 5
0  4  1 -1 3  2 6 7 5
0 1 2 3 4 5 6 7 -1
-1 0 1 2 3  4 5 6 7
7 -1 0
3 1 4
5 6 2
* */
class Node
{
    public Integer[][] arr;
    public int second = 0;
    Node(Integer[][] s, int sec) {arr = s; second=sec;}

    public String toString()
    {
        return Arrays.deepToString(arr);
    }

}

public class j20003 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer[][] targetState =
                {{0, 1, 2},
                {3, 4, 5},
                {6, 7, -1}};
        int maxLength = 0;
        Integer[][] initialState = new Integer[3][3];
        for(int i=0 ;i<3; i++) {
            for (int j = 0; j < 3; j++) {
                initialState[i][j] = scanner.nextInt();
            }
        }
        maxLength = bfs(new Node(initialState,0), targetState);
        System.out.println(maxLength);
    }

    private static int bfs(Node initialState, Integer[][] targetState) {
        Queue<Node> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(initialState);
        visited.add(initialState.toString());
        int maxLength = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {  //方便看层数
                Node cur = queue.poll();

                if (cur != null && Arrays.deepEquals(cur.arr, targetState)) {
                    if(cur.second <= 5 && maxLength<= 25)
                        return maxLength;
                }

                if(maxLength > 25 ) return -1;

                Node nextState1 = new Node(opUp(cur.arr), cur.second);
                if (!visited.contains(nextState1.toString())) {
                    queue.offer(nextState1);
                    visited.add(nextState1.toString());
                }

                Node nextState2 = new Node(opUnder(cur.arr), cur.second);
                if (!visited.contains(nextState2.toString())) {
                    queue.offer(nextState2);
                    visited.add(nextState2.toString());
                }

                if(cur.second<5) {
                    Node nextState3 = new Node(opRight(cur.arr),cur.second+1);
                    if (!visited.contains(nextState3.toString())) {
                        queue.offer(nextState3);
                        visited.add(nextState3.toString());
                    }
                }

                Node nextState4 = new Node(opLeft(cur.arr),cur.second);
                if (!visited.contains(nextState4.toString())) {
                    queue.offer(nextState4);
                    visited.add(nextState4.toString());
                }
            }

            maxLength++;
        }
        return -1;
    }
    private  static Integer[][] Clone(Integer[][] state){
        Integer[][] clone = new Integer[3][3];
        for(int i=0 ;i<3;i++)
            for (int j=0;j<3;j++)
            {
                clone[i][j]=state[i][j];
            }
        return clone;
    }
    private static Integer[] serchIndex(Integer[][] state) {
        Integer[] station = {0, 0};
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                if (state[i][j] == -1) {
                    station[0] = i;
                    station[1] = j;
                    return station;
                }

            }
        return station;
    }

    private static Integer[][] opUp(Integer[][] state) {
        Integer[][] inter = Clone(state);
        Integer[] station = serchIndex(inter);
        if (station[0] != 0) {
            inter[station[0]][station[1]] = inter[station[0]-1][station[1]];
            inter[station[0]-1][station[1]] = -1;
        }
        return inter;
    }

    private static Integer[][] opUnder(Integer[][] state) {
        Integer[][] inter = Clone(state);
        Integer[] station = serchIndex(inter);
        if (station[0] != 2) {
            inter[station[0]][station[1]] = inter[station[0]+1][station[1]];
            inter[station[0]+1][station[1]] = -1;
        }
        return inter;
    }

    private static Integer[][] opRight(Integer[][] state) {
        Integer[][] inter = Clone(state);
        Integer[] station = serchIndex(inter);
        if (station[1] != 2) {
            inter[station[0]][station[1]] = inter[station[0]][station[1]+1];
            inter[station[0]][station[1]+1] = -1;
        }
        return inter;
    }
    private static Integer[][] opLeft(Integer[][] state) {
        Integer[][] inter = Clone(state);
        Integer[] station = serchIndex(inter);
        if(station[1]!=0)
        {
            inter[station[0]][station[1]] = inter[station[0]][station[1]-1];
            inter[station[0]][station[1]-1] = -1;
        }
        return  inter;
    }
}
