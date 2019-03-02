import java.util.ArrayDeque;
import java.util.Queue;

class Pair {
    private int number;
    private int step;

    public Pair(int number, int step) {
        this.number = number;
        this.step = step;
    }

    public int getNumber() {
        return number;
    }

    public int getStep() {
        return step;
    }
}

public class Solution {

    // 利用图的广度优先遍历来查找最短路径
    public int numSquares(int n) {
        Queue<Pair> queue = new ArrayDeque<>();
        int[] visited = new int[n+1];
        visited[n] = 1;
        queue.add(new Pair(n, 0));

        while (!queue.isEmpty()) {
            Pair pair = queue.remove();
            int number = pair.getNumber();
            int step = pair.getStep();

            for (int i = 1 ; ; i++ ) {
                int temp = number - i*i;
                if (temp < 0)
                    break;
                if (temp == 0)
                    return step+1;
                // temp > 0
                if (visited[temp] == 0)
                    queue.add(new Pair(temp,step+1));
            }
        }
        return -1;
    }
}
