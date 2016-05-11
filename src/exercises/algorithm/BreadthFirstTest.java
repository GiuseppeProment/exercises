package exercises.algorithm;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BreadthFirstTest {
	private Node<Person> root;

	@Test
	public void findSingleElementRecursive() {
		tryFindElment("C");
		tryFindElment("B");
		tryFindElment("F");
		tryFindElment("G");
		tryFindElment("A");
	}

	private void tryFindElment(String name) {
		TransversalExecutor bdf = new TransversalExecutor();
		assertEquals(name, bdf.findRecursive( root, p -> p.getName().equals(name) ).getName());
		System.out.println(String.format("BigO counter:%d for:%s", bdf.getBigOstepCounter(), name));
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
