# N皇后

## 解题思路
1. 使用三个数组，分别记录第i列是否存在皇后，第i条主对角线是否存在皇后以及第i条副对角线是否存在皇后。
通过图片可知，存在规律：
![副对角线](https://github.com/a494456818/LeetCode-java/blob/master/51/img/Auxiliary.png)
![主对角线](https://github.com/a494456818/LeetCode-java/blob/master/51/img/main.png)
* N\*N矩阵的对角线条数为 2\*n-1条
* 同一对角线上的编号相同
2. 查找每一行中，皇后可以存放在哪一列；
3. 当查找到最后一行时，切皇后满足放置条件，找到一组解。
