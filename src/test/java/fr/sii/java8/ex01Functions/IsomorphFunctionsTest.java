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

import static org.junit.Assert.assertTrue;

public class IsomorphFunctionsTest extends FunctionChecker {

	@Test
	public void test() {
		assertTrue(check(KeyEventDispatcher.class, "Function<KeyEvent, Boolean>"));
		assertTrue(check(KeyEventDispatcher.class, "Predicate<KeyEvent>"));

		assertTrue(check(FileFilter.class, "Predicate<File>"));
		assertTrue(check(FileFilter.class, "Function<File, Boolean>"));

		assertTrue(check(FilenameFilter.class, "BiFunction<File,String,Boolean>"));
		assertTrue(check(FilenameFilter.class, "BiPredicate<File,String>"));

		assertTrue(check(UncaughtExceptionHandler.class, "BiConsumer<Thread,Throwable>"));

		assertTrue(check(Filter.class, "Function<LogRecord,Boolean>"));
		assertTrue(check(Filter.class, "Predicate<LogRecord>"));

		assertTrue(check(PathMatcher.class, "Function<Path,Boolean>"));
		assertTrue(check(PathMatcher.class, "Predicate<Path>"));

		assertTrue(check(TemporalAdjuster.class, "Function<Temporal,Temporal>"));
		assertTrue(check(TemporalAdjuster.class, "UnaryOperator<Temporal>"));

		// Utilisez le type R.
		assertTrue(check(TemporalQuery.class, "Function<TemporalAccessor,R>"));

		// Utilisez le type T.
		assertTrue(check(Comparator.class, "BiFunction<T,T,Integer>"));
		assertTrue(check(Comparator.class, "ToIntBiFunction<T,T>"));

		// Utilisez le type V.
		assertTrue(check(Callable.class, "Supplier<V>"));

		assertTrue(check(PreferenceChangeListener.class, "Consumer<PreferenceChangeEvent>"));
	}

}
