import java.util.ArrayList;
import java.util.List;

public class Solution {

    final String[] letterMap = {
            " ", // 0
            "", // 1
            "abc", // 2
            "def", // 3
            "ghi", // 4
            "jkl", // 5
            "mno", //6
            "pqrs", // 7
            "tuv", // 8
            "wxyz" // 9
    };

    List<String> res = new ArrayList<>();

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.letterCombinations("23");
        System.out.println(solution.res.toString());
    }

    public List<String> letterCombinations(String digits) {
        res.clear();
        if (digits.equals(""))
            return res;
        findCombination(digits, 0, "");
        return res;
    }

    // s中保存了此时从digits[0...index-1]翻译得到的一个字母字符串
    // 寻找和digits[index]匹配的字母，获得digits[0...index]翻译得到的解
    private void findCombination(String digits, int index, String s) {
        if (index == digits.length()) { // s为一个解
            res.add(s);
            return;
        }
        char c = digits.charAt(index);
        assert (c >= '0' && c <= '9' && c != '1');
        String letters = letterMap[c - '0'];
        for (int i = 0; i < letters.length(); i++)
            findCombination(digits, index + 1, s + letters.charAt(i));
        return;
    }
}
