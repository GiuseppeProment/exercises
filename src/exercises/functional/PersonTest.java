package exercises.functional;

import java.time.LocalDate;
import java.time.Month;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import exercises.functional.Person.Sex;

public class PersonTest {

	private Collection<Person> persons;

	@Test
	public void countMale() {
		Assert.assertEquals(4, 
				persons
					.stream()
					.filter(p -> p.sex.equals(Sex.MALE))
					.count());
	}

	@Test
	public void getSortedNames() {
		Person[] list = persons
			.stream()
			.sorted((x,y) -> x.name.compareTo(y.name) )
			.map(p -> p.name )
			.toArray(Person[]::new);
	}

	@Before
	public void setup() {
		persons = new LinkedList<>();
		persons.add(new Person("Giuseppe Proment", Sex.MALE, LocalDate.of(1968, Month.MARCH, 15)));
		persons.add(new Person("Anselmo Proment", Sex.MALE, LocalDate.of(1969, Month.APRIL, 26)));
		persons.add(new Person("Ricardo Proment", Sex.MALE, LocalDate.of(1970, Month.SEPTEMBER, 26)));
		persons.add(new Person("Mônica Proment", Sex.FEMALE, LocalDate.of(1972, Month.MARCH, 10)));
		persons.add(new Person("Leonardo da Silva Proment", Sex.MALE, LocalDate.of(1976, Month.MAY, 19)));
		persons.add(new Person("Dirce Rosa da Silva Proment", Sex.FEMALE, LocalDate.of(1941, Month.JULY, 31)));
	}

}
