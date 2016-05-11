package exercises.algorithm;

import java.util.function.Predicate;

/**
@formatter:off
--------------------------------
 Recursive
 preorder(node)
  if (node = null)
    return
  visit(node)
  preorder(node.left)
  preorder(node.right)
--------------------------------
iterativePreorder(node)
s ← empty stack
while (not s.isEmpty() or node ≠ null)
  if (node ≠ null)
    visit(node)
    if (node.right ≠ null)
      s.push(node.right)
    node ← node.left
  else
    node ← s.pop()  
--------------------------------
@formatter:on
*/
public class TransversalExecutor {
	private int bigOstepCounter;
	public <T> T findRecursive(Node<T> root, Predicate<T> predicate ) {
		bigOstepCounter++;
		if (root == null)
			return null;
		if ( predicate.test(root.value))
			return root.value;
		T found = findRecursive(root.getChildLeft(),predicate);
		if (found != null) return found;
		return findRecursive(root.getChildRight(),predicate);
	}
	public int getBigOstepCounter() {
		return bigOstepCounter;
	}

}
