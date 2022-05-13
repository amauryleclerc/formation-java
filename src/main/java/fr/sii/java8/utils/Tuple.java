package fr.sii.java8.utils;

import java.util.Map.Entry;
import java.util.function.Function;

public record Tuple<A, B>(A a, B b) {

	public static <A, B> Tuple<A, B> tuple(final A a, final B b) {
		return new Tuple<>(a, b);
	}

	public static <K, V> Tuple<K, V> fromEntry(Entry<K, V> e) {
		return tuple(e.getKey(), e.getValue());
	}

	public <T> Tuple<T, B> mapA(Function<A, T> f) {
		return tuple(f.apply(a), b);
	}

	public <T> Tuple<A, T> mapB(Function<B, T> f) {
		return tuple(a, f.apply(b));
	}

	@Override
	public String toString() {
		return "(" + a + "," + b + ")";
	}

}