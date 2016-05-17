package exercises.hash;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import exercises.hash.HashTable.KeyValue;

public class HashTableTest {

	@Test
	public void simplestCenarioStoreAndRetrieveObjects() {
		HashTable<String, String> bag = new HashTable<String, String>();
		String key1 = "Enrico";
		String key2 = "Mônica";
		String key3 = "Denise";
		String value1 = "Enrico Proment";
		String value2 = "Mônica Proment";
		String value3 = "Denise Kosaka";
		bag.put(key1,value1);
		bag.put(key2,value2);
		bag.put(key3,value3);
		assertEquals(value1,bag.get(key1));
		assertEquals(value3,bag.get(key3));
	}
	
	@Test
	public void findEmptyPositionWhenIndexIsEmpty() {
		HashTable<String, Integer> bag = new HashTable<>();
		KeyValue<String, Integer>[] objects = new KeyValue[10];
		int index = bag.findEmptyPosition(5, objects );
		assertEquals(5, index);
	}

	@Test
	public void findEmptyNextPositionWhenIndexIsNotEmpty() {
		HashTable<String, Integer> bag = new HashTable<>();
		KeyValue<String, Integer>[] objects = new KeyValue[10];
		objects[5] = new KeyValue("",0);
		int index = bag.findEmptyPosition(5, objects );
		assertEquals(6, index);
	}

	@Test
	public void findEmptyPreviousPositionWhenIndexIsNotEmpty() {
		HashTable<String, Integer> bag = new HashTable<>();
		KeyValue<String, Integer>[] objects = new KeyValue[10];
		objects[9] = new KeyValue("",0);
		int index = bag.findEmptyPosition(9, objects );
		assertEquals(8, index);
	}
	
	@Test
	public void hashFunctionShouldNotBeGreaterThanArray() {
		HashTable<String, Integer> bag = new HashTable<>();
		assertTrue(bag.hash("Mônica", 100)<100);
	}
}
