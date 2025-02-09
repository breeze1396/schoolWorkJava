import java.util.*;
/*
85712463
16
15348267
-1

 */

class Node
{
    public String str;
    Node(String s,int sec)
    {
        str = s;
        op = new ArrayList<>();
        second = sec;
    }
    public ArrayList<String> op;
    public int second = 0;
}
public class j20011 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int maxLength = bfs(new Node("12345678",0), sc.nextLine().trim());
        System.out.print(maxLength);
    }

    private static int bfs(Node initialState, String targetState) {
        Queue<Node> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(initialState);
        visited.add(initialState.str);
        int maxLength = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node currentState = queue.poll();
                if (currentState.str.equals(targetState)) {
                    int sec = 0;
                   for(String c : currentState.op)
                        if (Objects.equals(c, "op2")) sec++;

                   if(sec>8) {
                        return -1;
                    }
                    return maxLength;
                }

                ArrayList<String> curOp = currentState.op;
                // 操作1
                Node nextState1 = new Node(applyOperation1(currentState.str),currentState.second);
                nextState1.op = new ArrayList<>(curOp);
                nextState1.op.add("op1");

                if (!visited.contains(nextState1.str)) {
                    queue.offer(nextState1);
                    visited.add(nextState1.str);
                }


                //操作3
                Node nextState3 = new Node(applyOperation3(currentState.str),currentState.second);
                nextState3.op = new ArrayList<>(curOp);
                nextState3.op.add("op3");

                if (!visited.contains(nextState3.str)) {
                    queue.offer(nextState3);
                    visited.add(nextState3.str);
                }

                //操作2
                if (currentState.second <= 8) {
                    Node nextState2 = new Node(applyOperation2(currentState.str),currentState.second+1);
                    nextState2.op = new ArrayList<>(curOp);
                    nextState2.op.add("op2");

                    if (!visited.contains(nextState2.str)) {
                        queue.offer(nextState2);
                        visited.add(nextState2.str);
                    }
                }
            }
            maxLength++;
        }
        return -1;
    }

    private static String applyOperation1(String state) {
        char[] chars = state.toCharArray();
        char temp = chars[0];
        chars[0] = chars[7];
        chars[7] = temp;
        temp = chars[1];
        chars[1] = chars[6];
        chars[6] = temp;
        temp = chars[2];
        chars[2] = chars[5];
        chars[5] = temp;
        temp = chars[3];
        chars[3] = chars[4];
        chars[4] = temp;
        return new String(chars);
    }

    private static String applyOperation2(String state) {
        char[] chars = state.toCharArray();
        char temp = chars[0];
        chars[0] = chars[3];
        chars[3] = chars[2];
        chars[2] = chars[1];
        chars[1] = temp;
        temp = chars[4];
        chars[4] = chars[5];
        chars[5] = chars[6];
        chars[6] = chars[7];
        chars[7] = temp;
        return new String(chars);
    }

    private static String applyOperation3(String state) {
        char[] chars = state.toCharArray();
        char temp = chars[1];
        chars[1] = chars[6];
        chars[6] = chars[5];
        chars[5] = chars[2];
        chars[2] = temp;
        return new String(chars);
    }

}

