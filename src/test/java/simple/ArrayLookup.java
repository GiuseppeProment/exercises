package simple;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.BitSet;

import org.junit.Test;

public class ArrayLookup {

	@Test
	public void findMissing_on_sorted_set_iterative() {
		int missing = findMissingElementIterative(new int[]{0,1,2,3,5,6,7,8,9});
		assertEquals(4, missing);
	}

	@Test
	public void findMissing_on_sorted_math() {
		int missing = findMissingElementMath(new int[]{0,1,2,3,5,6,7,8,9});
		assertEquals(4, missing);
	}

	// O(n)
	private int findMissingElementMath(int[] numbers) {
		int sum = Arrays
			.stream(numbers)
			.reduce( Integer::sum )
			.getAsInt();
		int sumAll = (numbers.length+1) * numbers.length / 2;
		return sumAll - sum;
	}

	// O(2n) 
	private int findMissingElementIterative(int[] numbers ) {
		BitSet bs = new BitSet( numbers.length);
		// O(n)
		Arrays
			.stream(numbers)
			.forEach( i -> bs.set(i));
		// O(n)
		return bs.nextClearBit(0);
	}

}
