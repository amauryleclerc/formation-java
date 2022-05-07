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

		check(FilenameFilter.class, "BiFunction<File,String,Boolean>");
		check(FilenameFilter.class, "BiPredicate<File,String>");

		check(UncaughtExceptionHandler.class, "BiConsumer<Thread,Throwable>");

		check(Filter.class, "Function<LogRecord,Boolean>");
		check(Filter.class, "Predicate<LogRecord>");

		check(PathMatcher.class, "Function<Path,Boolean>");
		check(PathMatcher.class, "Predicate<Path>");

		check(TemporalAdjuster.class, "Function<Temporal,Temporal>");
		check(TemporalAdjuster.class, "UnaryOperator<Temporal>");

		// Utilisez le type R.
		check(TemporalQuery.class, "Function<TemporalAccessor,R>");

		// Utilisez le type T.
		check(Comparator.class, "BiFunction<T,T,Integer>");
		check(Comparator.class, "ToIntBiFunction<T,T>");

		// Utilisez le type V.
		check(Callable.class, "Supplier<V>");

		check(PreferenceChangeListener.class, "Consumer<PreferenceChangeEvent>");
	}

}
