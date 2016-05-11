package exercises.algorithm;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

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
public class BreadthFirstTest {
	private Node<Person> root;

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Before
	public void initialize() {
		root = new Node<>(new Person("A",100,false));
		root
			.setChildLeft(new Node<Person>(new Person("B",50, true)));
		root
			.setChildRight(new Node<Person>(new Person("C",50, true)));
	}
}
