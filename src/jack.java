import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class jack {

	static public void main( String args[]) {
		try {
			doit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void doit() throws Exception {
		try {
			throw new Exception("E1");
		}
		finally{
			throw new Exception("E2");
		}
	}
	
	static int findMissing( int a[] ) {
		Arrays.sort(a); // O(n log(n))
		// O(n) + O(n log(n))
		for(int i=0; i< a.length; i++) {
			if (a[i] != i) return a[i];
		}
		return -1;
	}
}
