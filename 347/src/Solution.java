import java.util.*;

class Pair implements Comparable<Pair> {
    int frequency;
    int number;

    public Pair(int frequency, int number) {
        this.frequency = frequency;
        this.number = number;
    }

    public int getFrequency() {
        return frequency;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public int compareTo(Pair o) {
        return this.frequency == o.frequency ? 0 : (this.frequency > o.frequency ? 1 : -1);
    }
}

public class Solution {

    public static void main(String[] args) {
        int[] nums = {4, 1, -1, 2, -1, 2, 3};
        int k = 2;
        List<Integer> ans = new Solution().topKFrequent(nums, k);
        System.out.println(ans.toString());
    }

    // 时间复杂度：O(nlogk)
    // 空间复杂度：O(k)
    // k表示去除nums中的重复数后，还有k个数
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        Queue<Pair> queue = new PriorityQueue();
        for (int key : freq.keySet()) {
            int val = freq.get(key);
            if (queue.size() >= k) {
                if (queue.peek().getFrequency() < val) {
                    queue.poll(); // 出队最小的元素
                    queue.add(new Pair(val, key));
                }
            } else
                queue.add(new Pair(val, key));
        }
        List<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            ans.add(queue.poll().getNumber());
        }
        return ans;
    }
}
