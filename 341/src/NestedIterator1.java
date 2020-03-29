import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/*
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
*/

class Cursor {
    List<NestedInteger> list;
    int i;
    Cursor(List<NestedInteger> list) {
        this.list = list;
    }
}

// 非递归实现
public class NestedIterator1 implements Iterator<Integer> {

    private Stack<Cursor> stack = new Stack<>();

    public NestedIterator1(List<NestedInteger> nestedList) {
        if (nestedList != null)
            stack.push(new Cursor(nestedList));
    }

    @Override
    public Integer next() {
        while ( !stack.empty() ) {
            Cursor cursor = stack.peek();
            if (cursor.i < cursor.list.size()) {
                NestedInteger nested = cursor.list.get(cursor.i++);
                if (nested.isInteger())
                    return nested.getInteger();
                else
                    stack.push(new Cursor(nested.getList()));
            } else {
                stack.pop();
            }
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        while ( !stack.empty() ) {
            Cursor cursor = stack.peek();
            if (cursor.i < cursor.list.size()) {
                NestedInteger nested = cursor.list.get(cursor.i);
                if (nested.isInteger())
                    return true;
                cursor.i++;
                stack.push(new Cursor(nested.getList()));
            } else {
                stack.pop();
            }
        }
        return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */