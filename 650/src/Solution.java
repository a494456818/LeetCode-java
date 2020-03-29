/**
 * 解法一：递归
 */
public class Solution {

    private int minTime = Integer.MAX_VALUE; // 最少的操作次数
    private int objectLen = 0; // 目标长度

    public int minSteps(int n) {
        int curStrNum = 1, operationTime = 1, copyNum = 1;
        if (n == 0 || n == 1)
            return 0;

        this.objectLen = n;

        getRes(curStrNum, operationTime, copyNum);

        return minTime;
    }

    /**
     * @param curStrNum：当前string的长度，有curStrNun个A
     * @param operationTime：已经是第几个操作了
     * @param copyNum：当前正在复制A的数量
     */
    private void getRes(int curStrNum, int operationTime, int copyNum) {
        if (curStrNum > this.objectLen)
            return;
        if (curStrNum == this.objectLen) {
            minTime = Math.min(minTime, operationTime);
            return;
        }
        // 复制操作
        getRes(curStrNum + copyNum, operationTime + 1, copyNum);

        if (curStrNum != 1) { // =1的时候，已经有粘贴操作了，只要直接复制即可
            // 粘贴全部并且复制
            getRes(curStrNum * 2, operationTime + 2, curStrNum);
        }

        return;
    }

}
