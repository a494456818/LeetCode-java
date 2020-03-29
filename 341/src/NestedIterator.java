import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;


// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}

// 递归实现
public class NestedIterator implements Iterator<Integer> {

    private List<Integer> list = new ArrayList<>();
    private int pointer = 0;

    public NestedIterator(List<NestedInteger> nestedList) {
        resolve(nestedList);
    }

    public void resolve(List<NestedInteger> nestedList) {
        for (int i = 0 ; i < nestedList.size() ; i++) {
            NestedInteger t = nestedList.get(i);
            if (t.isInteger()) {
                list.add(t.getInteger());
            } else {
                resolve(t.getList());
            }
        }
    }

    @Override
    public Integer next() {
        assert pointer < list.size() : " 数组越界 ";
        return list.get(pointer++);
    }

    @Override
    public boolean hasNext() {
        return pointer < list.size();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */