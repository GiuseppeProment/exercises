package exercises.algorithm;

import java.util.function.Function;
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
public class TransversalDepthFirst {
	private int bigOstepCounter;
	private String visited;
	
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
	public <T> String visitPreOrder(Node<T> root, Function<T, String> mapper ) {
		visited="";
		bigOstepCounter=0;
		visitPreOrderImpl(root, mapper);
		return visited;
	}
	private <T> void visitPreOrderImpl(Node<T> root, Function<T, String> mapper) {
		bigOstepCounter++;
		if (root == null)
			return;
		visited += mapper.apply(root.value);
		visitPreOrderImpl(root.getChildLeft(),mapper);
		visitPreOrderImpl(root.getChildRight(),mapper);
	}
	public <T> String visitInOrder(Node<T> root, Function<T, String> mapper ) {
		visited="";
		bigOstepCounter=0;
		visitInOrderImpl(root, mapper);
		return visited;
	}
	private <T> void visitInOrderImpl(Node<T> root, Function<T, String> mapper) {
		bigOstepCounter++;
		if (root == null)
			return;
		visitPreOrderImpl(root.getChildLeft(),mapper);
		visited += mapper.apply(root.value);
		visitPreOrderImpl(root.getChildRight(),mapper);
	}
	public <T> String visitPostOrder(Node<T> root, Function<T, String> mapper ) {
		visited="";
		bigOstepCounter=0;
		visitPostOrderImpl(root, mapper);
		return visited;
	}
	private <T> void visitPostOrderImpl(Node<T> root, Function<T, String> mapper) {
		bigOstepCounter++;
		if (root == null)
			return;
		visitPreOrderImpl(root.getChildLeft(),mapper);
		visitPreOrderImpl(root.getChildRight(),mapper);
		visited += mapper.apply(root.value);
	}
	public String getName() {
		return "DPF";
	}

}
