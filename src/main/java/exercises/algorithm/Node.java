package exercises.algorithm;

public class Node<T> {
	T value;
	Node<T> childLeft;
	Node<T> childRight;

	public Node(T value) {
		super();
		this.value = value;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public Node<T> getChildLeft() {
		return childLeft;
	}

	public Node<T> setChildLeft(Node<T> childLeft) {
		this.childLeft = childLeft;
		return this;
	}

	public Node<T> getChildRight() {
		return childRight;
	}

	public Node<T> setChildRight(Node<T> childRight) {
		this.childRight = childRight;
		return this;
	}
}
