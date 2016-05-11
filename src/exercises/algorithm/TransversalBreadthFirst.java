package exercises.algorithm;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.function.Function;
import java.util.function.Predicate;

/**
@formatter:off
levelorder(root)
  q ← empty queue
  q.enqueue(root)
  while (not q.isEmpty())
    node ← q.dequeue()
    visit(node)
    if (node.left ≠ null)
      q.enqueue(node.left)
    if (node.right ≠ null)
      q.enqueue(node.right)
@formatter:on
*/
public class TransversalBreadthFirst {
	private int bigOstepCounter;
	private String visited;

	public <T> T findRecursive(Node<T> root, Predicate<T> predicate) {
		Deque<Node<T>> deque = new ArrayDeque<>();
		deque.add(root);
		while (!deque.isEmpty()) {
			bigOstepCounter++;
			root = deque.poll();
			if (predicate.test(root.value))
				return root.value;
			if (root.getChildLeft() != null)
				deque.add(root.getChildLeft());
			if (root.getChildRight() != null)
				deque.add(root.getChildRight());
		}
		return null;
	}

	public int getBigOstepCounter() {
		return bigOstepCounter;
	}

	public <T> String visit(Node<T> root, Function<T, String> mapper) {
		visited = "";
		bigOstepCounter = 0;
		visitImpl(root, mapper);
		return visited;
	}

	private <T> void visitImpl(Node<T> root, Function<T, String> mapper) {
		Deque<Node<T>> deque = new ArrayDeque<>();
		deque.add(root);
		while (!deque.isEmpty()) {
			bigOstepCounter++;
			root = deque.poll();
			visited += mapper.apply(root.value);
			if (root.getChildLeft() != null)
				deque.add(root.getChildLeft());
			if (root.getChildRight() != null)
				deque.add(root.getChildRight());
		}
	}

	public String getName() {
		return "BDF";
	}
}
