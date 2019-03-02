import java.util.*;

class Pair {
    String word;
    int step;
    int row;
    int col;

    public Pair(String word, int step, int row, int col) {
        this.word = word;
        this.step = step;
        this.row = row;
        this.col = col;
    }

    public String getWord() {
        return word;
    }

    public int getStep() {
        return step;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}

class Solution {
    // 时间超时，dfs算法时间复杂度过高
    // 时间复杂度：O(n^3)
    // 空间复杂度：O(n^2)
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> queue = new LinkedList<>();
        List<List<String>> ans = new ArrayList<>();
        int[][] graph = new int[wordList.size() + 1][wordList.size() + 1];
        int[][] visited = new int[wordList.size() + 1][wordList.size() + 1];
        int minStep = wordList.size() + 1;
        int beginIndex = wordList.indexOf(beginWord);
        if (beginIndex != -1)
            visited[beginIndex][beginIndex] = 1;
        queue.offer(new Pair(beginWord, 1, 0, 0));
        // 提交后时间超限，找出一种方法，能在这个while循环中记录路径，而不使用下面的dfs
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            String word = pair.getWord();
            int step = pair.getStep();
            int row = pair.getRow();
            int col = pair.getCol();
            if (step >= minStep)
                break;
            graph[row][col] = 1;
            for (int i = 0; i < wordList.size(); i++) {
                String str = wordList.get(i);
                if (canChange(word, str)) {
                    if (str.equals(endWord)) {
                        graph[col][i + 1] = 1;
                        minStep = step + 1;
                    } else {
                        if (visited[col][i + 1] == 0) {
                            queue.offer(new Pair(str, step + 1, col, i + 1));
                            visited[col][i + 1] = 1;
                            visited[i + 1][col] = 1;
                            graph[col][i + 1] = 1;
                        }
                    }
                }
            }
        }
        for (int i = 0 ; i < graph.length ; i ++) {
            for (int j = 0 ; j < graph.length ; j ++) {
                System.out.print(graph[i][j]);
            }
            System.out.println();
        }
        List<String> temp = new ArrayList<>();
        temp.add(beginWord);
        dfs(graph, 0, ans, temp, endWord, wordList, minStep, 1);
        return ans;
    }

    private void dfs(int[][] graph, int start, List<List<String>> ans, List<String> temp, String endWord, List<String> wordList, int minStep, int curStep) {
        if (temp.get(temp.size() - 1).equals(endWord) && minStep == curStep) {
            ans.add(temp);
            return;
        } else if (minStep < curStep) {
            return;
        }

        for (int i = 1; i < graph.length; i++) {
            if (graph[start][i] == 1) {
                List<String> t = new ArrayList<>();
                t.addAll(temp);
                t.add(wordList.get(i - 1));
                dfs(graph, i, ans, t, endWord, wordList,minStep,curStep+1);
            }
        }
    }


    // 判断字符串a和b是否只有1个字符不相同
    private boolean canChange(String a, String b) {
        assert a.length() == b.length() : " 字符串a和b的长度不相同 ";
        int different = 0;
        for (int i = 0; i < a.length(); i++) {
            if (different > 1)
                return false;
            if (a.charAt(i) != b.charAt(i))
                different++;
        }
        return different == 1 ? true : false;
    }
}