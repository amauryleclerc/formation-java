package fr.sii.java8.ex03Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BaseTest {

	protected <T> List<T> sorted(List<T> in, Comparator<T> cmp) {
		ArrayList<T> cloned = new ArrayList<>(in);

		Collections.sort(cloned, cmp);

		return cloned;
	}
}
