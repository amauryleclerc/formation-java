package fr.sii.java8.ex01Functions;

import java.awt.KeyEventDispatcher;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.lang.Thread.UncaughtExceptionHandler;
import java.nio.file.PathMatcher;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalQuery;
import java.util.Comparator;
import java.util.concurrent.Callable;
import java.util.logging.Filter;
import java.util.prefs.PreferenceChangeListener;

import org.junit.Test;

public class IsomorphFunctionsTest extends FunctionChecker {

	@Test
	public void test() {
		check(KeyEventDispatcher.class, "Function<KeyEvent, Boolean>");
		check(KeyEventDispatcher.class, "Predicate<KeyEvent>");

		check(FileFilter.class, "Predicate<File>");
		check(FileFilter.class, "Function<File, Boolean>");

		check(FilenameFilter.class, "");
		check(FilenameFilter.class, "");

		check(UncaughtExceptionHandler.class, "");

		check(Filter.class, "");
		check(Filter.class, "");

		check(PathMatcher.class, "");
		check(PathMatcher.class, "");

		check(TemporalAdjuster.class, "");
		check(TemporalAdjuster.class, "");

		// Utilisez le type R.
		check(TemporalQuery.class, "");

		// Utilisez le type T.
		check(Comparator.class, "BiFunction<T,T,Integer>");
		check(Comparator.class, "");

		// Utilisez le type V.
		check(Callable.class, "");

		check(PreferenceChangeListener.class, "");
	}

}
