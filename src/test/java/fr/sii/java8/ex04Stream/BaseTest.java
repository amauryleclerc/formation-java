package fr.sii.java8.ex04Stream;

import static fr.sii.java8.ex04Stream.Bed.bed;
import static fr.sii.java8.ex04Stream.Garden.garden;
import static fr.sii.java8.ex04Stream.House.house;
import static fr.sii.java8.ex04Stream.Person.person;
import static fr.sii.java8.ex04Stream.Room.room;
import static fr.sii.java8.utils.LangUtils.opt;
import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableList;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.toSet;
import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;

import org.junit.Rule;
import org.junit.rules.TestName;

import fr.sii.java8.utils.Tuple;

public class BaseTest {

	@Rule
	public TestName testName = new TestName();

	// === 44 ===

	protected static final Person MARIE = person("Marie", 25, 44, //
			house(opt(garden(100)), room(2, bed(2), bed(1)), room(0, bed(1))));

	protected static final Person DAVID = person("David", 38, 44, //
			house(opt(garden(150)), room(2, bed(2), bed(1)), room(2, bed(2), bed(2)), room(0, bed(1))));

	protected static final Person JOHN = person("JOHN globe-trotter", 53, 44);

	// === 22 ====

	protected static final Person JACQUES = person("Jacques", 50, 22, //
			house(Optional.empty(), room(1, bed(1)), room(0, bed(2))));

	protected static final Person MARTINE = person("Martine", 62, 22, //
			house(opt(garden(50)), room(2, bed(1)), room(3, bed(2))));

	protected static final Person PATRICK = person("Patrick", 65, 22, //
			house(Optional.empty(), room(1, bed(2)), room(1, bed(2))));

	// === 35 ===

	protected static final Bed[] CONSTANCE_BEDS = { bed(2), bed(2), bed(2), bed(2), bed(2) };

	protected static final Person CONSTANCE = person("Constance-Cunegonde", 87, 35, //
			house(opt(garden(5_000)), room(1), room(8, CONSTANCE_BEDS)));

	protected List<Person> getPersons() {
		return unmodifiableList(list(MARIE, DAVID, JOHN, JACQUES, MARTINE, PATRICK, CONSTANCE));
	}

	protected List<Person> getPersons2() {
		return unmodifiableList(list(MARIE, DAVID, JACQUES, MARTINE, PATRICK, CONSTANCE));
	}

	protected List<Person> getPersons3() {
		return unmodifiableList(list(MARIE, DAVID, JACQUES, MARTINE, PATRICK, CONSTANCE));
	}

	protected String getTestName() {
		return testName.getMethodName();
	}

	protected <T> void eq(Class<T> clazz, T expected, T actual) {
		System.out.println("Expected: " + expected);
		System.out.println("  Actual: " + actual);
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------");

		assertEquals(expected, actual);
	}

	protected <K, V, T> Map<K, T> mapMapValues(Map<K, V> map, Function<V, T> f) {
		return map.entrySet().stream() //
				.map(kv -> Tuple.fromEntry(kv).mapB(f)) //
				.collect(toMap(Tuple::a, Tuple::b));
	}

	protected <C extends Collection<Person>> Function<C, Set<String>> toPersonNamesSet() {
		return ps -> ps.stream().map(Person::getName).collect(toSet());
	}

	protected <C extends Collection<Person>, T> Map<T, Set<String>> justNames(Map<T, C> personsToMap) {
		return mapMapValues(personsToMap, toPersonNamesSet());
	}

	protected <C extends Collection<Person>, T> List<String> justNames(C persons) {
		return persons.stream().map(Person::getName).collect(toList());
	}

	protected <T> List<T> list(T... a) {
		return asList(a);
	}

	protected <T> Set<T> set(T... a) {
		return new HashSet<>(asList(a));
	}

	protected <K, V> Map<K, V> map() {
		return new HashMap<>();
	}

	protected <K, V> Map<K, V> map( //
			K k1, V v1) {
		return new HashMap<K, V>() {
			{
				put(k1, v1);
			}
		};
	}

	protected <K, V> Map<K, V> map( //
			K k1, V v1, //
			K k2, V v2) {
		return new HashMap<K, V>() {
			{
				put(k1, v1);
				put(k2, v2);
			}
		};
	}

	protected <K, V> Map<K, V> map( //
			K k1, V v1, //
			K k2, V v2, //
			K k3, V v3) {
		return new HashMap<K, V>() {
			{
				put(k1, v1);
				put(k2, v2);
				put(k3, v3);
			}
		};
	}

	protected <K, V> Map<K, V> map( //
			K k1, V v1, //
			K k2, V v2, //
			K k3, V v3, //
			K k4, V v4) {
		return new HashMap<K, V>() {
			{
				put(k1, v1);
				put(k2, v2);
				put(k3, v3);
				put(k4, v4);
			}
		};
	}

	protected <K, V> Map<K, V> map( //
			K k1, V v1, //
			K k2, V v2, //
			K k3, V v3, //
			K k4, V v4, //
			K k5, V v5) {
		return new HashMap<K, V>() {
			{
				put(k1, v1);
				put(k2, v2);
				put(k3, v3);
				put(k4, v4);
				put(k5, v5);
			}
		};
	}

	protected <K, V> Map<K, V> map( //
			K k1, V v1, //
			K k2, V v2, //
			K k3, V v3, //
			K k4, V v4, //
			K k5, V v5, //
			K k6, V v6) {
		return new HashMap<K, V>() {
			{
				put(k1, v1);
				put(k2, v2);
				put(k3, v3);
				put(k4, v4);
				put(k5, v5);
				put(k6, v6);
			}
		};
	}

	protected <K, V> Map<K, V> map( //
			K k1, V v1, //
			K k2, V v2, //
			K k3, V v3, //
			K k4, V v4, //
			K k5, V v5, //
			K k6, V v6, //
			K k7, V v7) {
		return new HashMap<K, V>() {
			{
				put(k1, v1);
				put(k2, v2);
				put(k3, v3);
				put(k4, v4);
				put(k5, v5);
				put(k6, v6);
				put(k7, v7);
			}
		};
	}

	protected <T> void functionalAndImperativeTester(List<Person> persons, Function<List<Person>, T> functional,
			Function<List<Person>, T> imperative, Consumer<T> verif) {
		System.out.println("--- functional --- " + getTestName() + " ----");
		verif.accept(functional.apply(persons));

		System.out.println("--- imperative --- " + getTestName() + " ----");
		verif.accept(imperative.apply(persons));
	}

}
