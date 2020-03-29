import java.util.*;

/**
 * 使用并查集解决
 * 超出时间限制
 */
public class Solution1 {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        List<List<String>> res = new ArrayList<>();

        if (accounts == null || accounts.size() == 0)
            return res;

        int n = accounts.size();
        int[] uf = new int[n];

        // 初始化
        for (int i = 0; i < n; i++)
            uf[i] = i;

        List<int[]> relation = new ArrayList<>();
        // 类似于寻找朋友圈
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // 是否i和j处于一个朋友圈
                if (isCircle(accounts.get(i), accounts.get(j)))
                    relation.add(new int[]{i, j});
            }
        }

        // 根据relation构建UF
        for (int i = 0; i < relation.size(); i++) {
            int l = relation.get(i)[0];
            int r = relation.get(i)[1];
            int lRoot = l;
            int rRoot = r;
            while (uf[lRoot] != lRoot)
                lRoot = uf[lRoot];
            while (uf[rRoot] != rRoot)
                rRoot = uf[rRoot];
            uf[rRoot] = lRoot;
        }

        // 将uf全部和根相连接
        for (int i = 0; i < uf.length; i++) {
            int root = i;
            while (uf[root] != root)
                root = uf[root];
            uf[i] = root;
        }

        // 划分朋友圈
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < uf.length; i++) {
            if (map.containsKey(uf[i]))
                map.get(uf[i]).add(i);
            else {
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                map.put(uf[i], temp);
            }
        }

        // 合并
        for (int key : map.keySet()) {
            List<Integer> list = map.get(key);
            List<String> p0 = accounts.get(list.get(0));
            Set<String> emails = new HashSet<>();
            emails.addAll(p0.subList(1, p0.size()));
            String name = p0.get(0);

            for (int i = 1; i < list.size(); i++) {
                List<String> p = accounts.get(list.get(i));
                emails.addAll(p.subList(1, p.size()));
            }
            List<String> listEmails = new ArrayList<>(emails);
            Collections.sort(listEmails);
            listEmails.add(0, name);
            res.add(listEmails);
        }

        return res;
    }

    private boolean isCircle(List<String> person1, List<String> person2) {
        String name1 = person1.get(0);
        List<String> emails1 = person1.subList(1, person1.size());
        String name2 = person2.get(0);
        List<String> emails2 = person2.subList(1, person2.size());
        if (!name1.equals(name2))
            return false;
        else {
            for (String email : emails2)
                if (emails1.contains(email))
                    return true;
        }
        return false;
    }


    public static void main(String[] args) {

        Solution1 solution = new Solution1();
        List<List<String>> list = new ArrayList<>();
//        String[][] str = {{"David", "David0@m.co", "David1@m.co"}, {"David", "David3@m.co", "David4@m.co"}, {"David", "David4@m.co", "David5@m.co"}, {"David", "David2@m.co", "David3@m.co"}, {"David", "David1@m.co", "David2@m.co"}};
        String[][] str = {{"John", "johnsmith@mail.com", "john00@mail.com"}, {"John", "johnnybravo@mail.com"}, {"John", "johnsmith@mail.com", "john_newyork@mail.com"}, {"Mary", "mary@mail.com"}};
        for (int i = 0; i < str.length; i++) {
            List<String> temp = new ArrayList<>();
            for (int j = 0; j < str[i].length; j++)
                temp.add(str[i][j]);
            list.add(temp);
        }

        solution.accountsMerge(list);

    }
}
