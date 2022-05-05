package fr.sii.java8.ex01Functions;

import java.awt.KeyEventDispatcher;
import java.awt.event.KeyEvent;
//import java.awt.event.KeyEvent;
//import java.io.File;
//import java.io.FileFilter;
//import java.io.FilenameFilter;
//import java.lang.Thread.UncaughtExceptionHandler;
//import java.nio.file.Path;
//import java.nio.file.PathMatcher;
//import java.time.temporal.Temporal;
//import java.time.temporal.TemporalAccessor;
//import java.time.temporal.TemporalAdjuster;
//import java.time.temporal.TemporalQuery;
//import java.util.Comparator;
//import java.util.concurrent.Callable;
//import java.util.logging.Filter;
//import java.util.logging.LogRecord;
//import java.util.prefs.PreferenceChangeEvent;
//import java.util.prefs.PreferenceChangeListener;
import java.util.function.Predicate;

import org.junit.Test;

public class IsomorphFunctionsCompileTest extends FunctionChecker {

	@Test
	public void test() {
		{
			Predicate<KeyEvent> func = ke -> ke.isActionKey();

			KeyEventDispatcher ked1 = ke -> ke.isActionKey();
			KeyEventDispatcher ked2 = ke -> func.test(ke);

			KeyEventDispatcher typeJava7 = func::test;
		}

		{
			// TrouvezLeType func = écrire -> une lambda;
			// KeyEventDispatcher typeJava7 = func::trouvezLaMéthode;
		}

		{
			// TrouvezLeType func = écrire -> une lambda;
			// FileFilter typeJava7 = func::trouvezLaMéthode;
		}

		{
			// TrouvezLeType func = écrire -> une lambda;
			// FileFilter typeJava7 = func::trouvezLaMéthode;
		}

		{
			// TrouvezLeType func = écrire -> une lambda;
			// FilenameFilter typeJava7 = func::trouvezLaMéthode;
		}

		{
			// TrouvezLeType func = écrire -> une lambda;
			// FilenameFilter typeJava7 = func::trouvezLaMéthode;
		}

		{
			// TrouvezLeType func = écrire -> une lambda;
			// UncaughtExceptionHandler typeJava7 = func::trouvezLaMéthode;
		}

		{
			// TrouvezLeType func = écrire -> une lambda;
			// Filter typeJava7 = func::trouvezLaMéthode;
		}

		{
			// TrouvezLeType func = écrire -> une lambda;
			// Filter typeJava7 = func::trouvezLaMéthode;
		}

		{
			// TrouvezLeType func = écrire -> une lambda;
			// PathMatcher typeJava7 = func::trouvezLaMéthode;
		}

		{
			// TrouvezLeType func = écrire -> une lambda;
			// PathMatcher typeJava7 = func::trouvezLaMéthode;
		}

		{
			// TrouvezLeType func = écrire -> une lambda;
			// TemporalAdjuster typeJava7 = func::trouvezLaMéthode;
		}

		{
			// TrouvezLeType func = écrire -> une lambda;
			// TemporalAdjuster typeJava7 = func::trouvezLaMéthode;
		}

		{
			// TrouvezLeType func = écrire -> une lambda;
			// TemporalQuery<String> typeJava7 = func::trouvezLaMéthode;
		}

		{
			// TrouvezLeType func = écrire -> une lambda;
			// Comparator<String> typeJava7 = func::trouvezLaMéthode;
		}

		{
			// TrouvezLeType func = écrire -> une lambda;
			// Comparator<String> typeJava7 = func::trouvezLaMéthode;
		}

		{
			// TrouvezLeType func = écrire -> une lambda;
			// Callable<String> typeJava7 = func::trouvezLaMéthode;
		}

		{
			// TrouvezLeType func = écrire -> une lambda;
			// PreferenceChangeListener typeJava7 = func::trouvezLaMéthode;
		}
	}

}
