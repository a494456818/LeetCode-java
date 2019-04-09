import java.util.*;

/**
 * 以下是第一感觉的错误解法，不要照抄：
 *  下面代码处理不了的反例：
 *      input : [["David","David0@m.co","David1@m.co"],["David","David3@m.co","David4@m.co"],["David","David1@m.co","David3@m.co"]]
 *      这样的输入其实所有的邮箱都是David的，但是用这个代码会分解成两个邮箱
 *  正确的解法，使用并查集，查看Solution1
 */
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        // key: 用户名，value：所有用户名相同的邮箱地址
        Map<String, List<List<String>>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();

        if (accounts == null || accounts.size() == 0)
            return res;

        for (int i = 0; i < accounts.size(); i++) {
            String name = accounts.get(i).get(0);
            List<String> emails = accounts.get(i).subList(1, accounts.get(i).size());

            if (!map.containsKey(name)) { // 没有同名
                List<List<String>> list = new ArrayList<>();
                list.add(emails);
                map.put(name, list);
            } else { // 出现同名
                // 判断合并
                List<List<String>> temp = map.get(name); // 用户名为name的所有邮箱
                boolean isCombine = false;
                for (int j = 0; j < temp.size(); j++) {
                    if (isCombine)
                        break;
                    for (int k = 0; k < emails.size(); k++) {
                        if (temp.get(j).contains(emails.get(k))) { // 包含了，合并
                            temp.get(j).addAll(emails); // 没有去重
                            isCombine = true;
                            break;
                        }
                    }
                }
                if (!isCombine) { // 不合并，直接追加
                    temp.add(emails);
                }
            }
        }
        for (String name : map.keySet()) {
            for (List<String> email : map.get(name)) {
                email = new ArrayList<>(new HashSet<String>(email));
                Collections.sort(email);
                email.add(0, name);
                res.add(email);
            }
        }

        return res;
    }
}