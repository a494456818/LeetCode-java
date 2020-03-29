import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Pair {
    String word;
    int step;

    public Pair(String word, int step) {
        this.word = word;
        this.step = step;
    }

    public String getWord() {
        return word;
    }

    public int getStep() {
        return step;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> queue = new LinkedList<>();
        int[] visited = new int[wordList.size() + 1];
        queue.offer(new Pair(beginWord, 1));
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            String word = pair.getWord();
            int step = pair.getStep();
            for (int i = 0; i < wordList.size(); i++) {
                String str = wordList.get(i);
                if (canChange(word, str)) {
                    if (str.equals(endWord))
                        return step + 1;
                    else {
                        if (visited[i] == 0) {
                            queue.offer(new Pair(str, step + 1));
                            visited[i] = 1;
                        }
                    }
                }
            }
        }
        return 0;
    }

    // 判断字符串a和b是否只有1个字符不相同
    private boolean canChange(String a, String b) {
        assert a.length() == b.length() : " 字符串a和b的长度不相同 ";
        int different = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i))
                different++;
        }
        return different == 1 ? true : false;
    }
}