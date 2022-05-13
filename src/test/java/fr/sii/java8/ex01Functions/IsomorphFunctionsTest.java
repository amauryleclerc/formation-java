package fr.sii.java8.ex01Functions;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import java.awt.*;
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

import static org.junit.Assert.assertTrue;

public class IsomorphFunctionsTest extends FunctionChecker {

    @Test
    public void test() {
        assertTrue(check(KeyEventDispatcher.class, "Function<KeyEvent, Boolean>"));
        assertTrue(check(KeyEventDispatcher.class, "Predicate<KeyEvent>"));

        assertTrue(check(FileFilter.class, "Function<File, Boolean>"));
        assertTrue(check(FileFilter.class, "Predicate<File>"));

        assertTrue(check(FilenameFilter.class, ""));
        assertTrue(check(FilenameFilter.class, ""));

        assertTrue(check(UncaughtExceptionHandler.class, ""));

        assertTrue(check(Filter.class, ""));
        assertTrue(check(Filter.class, ""));

        assertTrue(check(PathMatcher.class, ""));
        assertTrue(check(PathMatcher.class, ""));

        assertTrue(check(TemporalAdjuster.class, ""));
        assertTrue(check(TemporalAdjuster.class, ""));

        // Utilisez le type R.
        assertTrue(check(TemporalQuery.class, ""));

        // Utilisez le type T.
        assertTrue(check(Comparator.class, ""));
        assertTrue(check(Comparator.class, ""));

        // Utilisez le type V.
        assertTrue(check(Callable.class, ""));

        assertTrue(check(PreferenceChangeListener.class, ""));
    }

}
