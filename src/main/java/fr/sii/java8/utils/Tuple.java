package fr.sii.java8.utils;

import java.util.Map.Entry;
import java.util.function.Function;

public final class Tuple<A, B> {

	public final A a;
	public final B b;

	private Tuple(final A a, final B b) {
		this.a = a;
		this.b = b;
	}

	public A getA() {
		return a;
	}

	public B getB() {
		return b;
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((a == null) ? 0 : a.hashCode());
		result = (prime * result) + ((b == null) ? 0 : b.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Tuple other = (Tuple) obj;
		if (a == null) {
			if (other.a != null) {
				return false;
			}
		} else if (!a.equals(other.a)) {
			return false;
		}
		if (b == null) {
			if (other.b != null) {
				return false;
			}
		} else if (!b.equals(other.b)) {
			return false;
		}
		return true;
	}
}