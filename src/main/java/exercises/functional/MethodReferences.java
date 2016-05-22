package exercises.functional;

import java.util.Date;
import java.util.function.Supplier;

interface Dummy1<T>  {
	T get();
}
interface Dummy2<T>  {
	T get();
}

public class MethodReferences {
	static public void main(String[] args) {
		receive(String::new,String::new,Date::new);
		receive( ()->{return new String();}, String::new,String::new);
		receive(MethodReferences::create,String::new,String::new);
		MethodReferences mf = new MethodReferences();
		receive(mf::createInstance,String::new,String::new);
	}
	static void receive( Dummy2<String> x, Dummy1<?> y, Supplier<?> z) {
		System.out.println(
				String.format("-------\n %s\n %s\n %s", 
						x.getClass().getName(),
						y.getClass().getName(),
						z.getClass().getName()));
	}
	static <T> T create(){
		T t = null;
		try {
			return (T) t.getClass().newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}
	<T> T createInstance(){
		T t = null;
		try {
			return (T) t.getClass().newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}
}
