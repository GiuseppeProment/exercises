package exercises.algorithm;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TransversalDepthFirstTest {
	private Node<Person> root;

	@Test
	public void findSingleElementRecursive() {
		tryFindElment("C");
		tryFindElment("B");
		tryFindElment("F");
		tryFindElment("G");
		tryFindElment("A");
	}
	
	@Test
	public void visitAllPreOrder() {
		TransversalDepthFirst alg = new TransversalDepthFirst();
		assertEquals("ABDECFG", alg.visitPreOrder( root, p -> p.getName() ) );
		System.out.println(String.format("BigO %s:%d for:visit",alg.getName() ,alg.getBigOstepCounter()));
	}

	@Test
	public void visitAllInOrder() {
		TransversalDepthFirst alg = new TransversalDepthFirst();
		assertEquals("BDEACFG", alg.visitInOrder( root, p -> p.getName() ) );
		System.out.println(String.format("BigO %s:%d for:visit",alg.getName() ,alg.getBigOstepCounter()));
	}

	@Test
	public void visitAllPostOrder() {
		TransversalDepthFirst alg = new TransversalDepthFirst();
		assertEquals("BDECFGA", alg.visitPostOrder( root, p -> p.getName() ) );
		System.out.println(String.format("BigO %s:%d for:visit",alg.getName() ,alg.getBigOstepCounter()));
	}

	private void tryFindElment(String name) {
		TransversalDepthFirst alg = new TransversalDepthFirst();
		assertEquals(name, alg.findRecursive( root, p -> p.getName().equals(name) ).getName());
		System.out.println(String.format("BigO %s:%d for:%s", alg.getName(), alg.getBigOstepCounter(), name));
	}

	@Before
	public void initialize() {
		root = new Node<>(new Person("A", 100, false));
		//@formatter:off
		root
			.setChildLeft(new Node<Person>(new Person("B",50, true)));
		root
			.setChildRight(new Node<Person>(new Person("C",50, true)));
		root
			.getChildLeft()
			.setChildLeft(new Node<Person>(new Person("D")))		
			.setChildRight(new Node<Person>(new Person("E")));
		root
			.getChildRight()
			.setChildLeft(new Node<Person>(new Person("F")))		
			.setChildRight(new Node<Person>(new Person("G")));
		//@formatter:on
	}
}
