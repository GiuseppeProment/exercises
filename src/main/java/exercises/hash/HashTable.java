package exercises.hash;

public class HashTable<K, V> {

	private static final int INITIAL_SIZE = 100;
	private KeyValue<?,?>[] keyValues = new KeyValue[INITIAL_SIZE];

	int findEmptyPosition(int index, KeyValue<?, ?>[] lKeyValues) {
		while (lKeyValues[index] != null && index < lKeyValues.length - 1)
			index++;
		while (lKeyValues[index] != null && index > 0)
			index--;
		return index;
	}

	int findKeyPositition(K key, int index, KeyValue<?, ?>[] bag) {
		while (bag[index] != null && index < bag.length - 1 && !bag[index].key.equals(key))
			index++;
		while (bag[index] != null && index > 0 && !bag[index].key.equals(key))
			index--;
		return index;
	}

	@SuppressWarnings("unchecked")
	public V get(K key) {
		int index = hash(key, keyValues.length);
		index = findKeyPositition(key, index, keyValues);
		if (keyValues[index] != null)
			if (keyValues[index].key.equals(key))
				return (V) keyValues[index].value;
		return null;
	}

	int hash(K key, int length) {
		return Math.abs(key.hashCode() % length - 1);
	}

	public void put(K key, V value) {
		int index = hash(key, keyValues.length);
		index = findEmptyPosition(index, keyValues);
		keyValues[index] = new KeyValue<K, V>(key, value);
	}

	static class KeyValue<K, V> {
		final K key;
		final V value;
		public KeyValue(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}
}
