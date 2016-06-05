package exercises.functional;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

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
		String[] names = persons
			.stream()
			.sorted((x,y) -> x.name.compareTo(y.name) )
			.map(p -> p.name ) 
			.toArray(String[]::new);
		
		assertArrayEquals(
				new String[]{
						"Anselmo Proment",
						"Dirce Rosa da Silva Proment",
						"Giuseppe Proment",
						"Leonardo da Silva Proment",
						"Mônica Proment",
						"Ricardo Proment"
						}, names);
	}

	@Test
	public void mapReduceOptionalReturn() {

		persons
			.stream()
			.mapToInt( p -> p.getAge() )
			.reduce( (a,b) -> a+b )
			.getAsInt();
		
		persons
			.stream()
			.mapToInt( p -> p.getAge() )
			.reduce( Integer::sum )
			.getAsInt();
		
		assertThat(
			persons
				.stream()
				.map( p -> p.name )
				.reduce((a,b) -> a+b)
				.orElseThrow( IllegalStateException::new ),
		is ( equalTo ( "xxx" ) ) );
	}

	@Test
	public void mapReduce() {

		persons
			.stream()
			.mapToInt( p -> p.getAge() )
			.reduce(0, (a,b) -> a+b );

		persons
			.stream()
			.mapToInt( p -> p.getAge() )
			.reduce(0, Integer::sum );

		persons
			.stream()
			.map( p -> p.name )
			.reduce("", (a,b) -> a+b);
	}

	@Test
	public void mapReduceCompleteForm() {
		persons
			.stream()
			.reduce( 0, (sum,p)-> sum + p.getAge(), Integer::sum );
	}

	@Test
	public void mutableReduce_Collect() {
		persons
			.parallelStream()
			.map(p->p.name)
			.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
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
