package exercises.functional;

import java.time.LocalDate;

public class Person {
	public enum Sex { MALE, FEMALE }
	Sex sex;
	LocalDate bithday;
	String name;
	public Person(String name, Sex sex, LocalDate birthday) {
		this.name = name;
		this.sex = sex;
		this.bithday = birthday;
	}
	public int getAge() {
		return LocalDate.now().getYear()-bithday.getYear();
	}
}
