package fr.sii.java8.ex01Functions;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertTrue;

import java.awt.KeyEventDispatcher;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.lang.Thread.UncaughtExceptionHandler;
import java.nio.file.PathMatcher;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalQuery;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.function.IntUnaryOperator;
import java.util.logging.Filter;
import java.util.prefs.PreferenceChangeListener;
import java.util.stream.Collectors;

public class FunctionChecker {

    private final static Map<Class<?>, List<String>> FUNCS = new HashMap<>();

    static {
        FUNCS.put(UncaughtExceptionHandler.class, asList("CjDpotvnfs=Uisfbe-!Uispxbcmf?"));
        FUNCS.put(TemporalAdjuster.class, asList("Gvodujpo=Ufnqpsbm-!Ufnqpsbm?", "VobszPqfsbups=Ufnqpsbm?"));
        FUNCS.put(TemporalQuery.class, asList("Gvodujpo=UfnqpsbmBddfttps-!S?"));
        FUNCS.put(PathMatcher.class, asList("Gvodujpo=Qbui-!Cppmfbo?", "Qsfejdbuf=Qbui?"));
        FUNCS.put(KeyEventDispatcher.class, asList("Gvodujpo=LfzFwfou-!Cppmfbo?", "Qsfejdbuf=LfzFwfou?"));
        FUNCS.put(PreferenceChangeListener.class, asList("Dpotvnfs=QsfgfsfodfDibohfFwfou?"));
        FUNCS.put(Callable.class, asList("Tvqqmjfs=W?"));
        FUNCS.put(FileFilter.class, asList("Gvodujpo=Gjmf-!Cppmfbo?", "Qsfejdbuf=Gjmf?"));
        FUNCS.put(FilenameFilter.class, asList("CjGvodujpo=Gjmf-!Tusjoh-!Cppmfbo?", "CjQsfejdbuf=Gjmf-!Tusjoh?"));
        FUNCS.put(Filter.class, asList("Gvodujpo=MphSfdpse-!Cppmfbo?", "Qsfejdbuf=MphSfdpse?"));
        FUNCS.put(Comparator.class, asList("CjGvodujpo=U-!U-!Joufhfs?", "UpJouCjGvodujpo=U-!U?"));
    }

    protected void check(final Class<?> clazz, final String result) {
        final boolean checked = FUNCS.getOrDefault(clazz, asList()).stream().map(s -> sanitize(decode(s)))
                .collect(toList()).contains(sanitize(result));

        System.out.println(clazz.getSimpleName() + (checked ? " == " : " =! ") + result);

        assertTrue(checked);
    }

    private String sanitize(final String result) {
        return result.replaceAll("\\s", "");
    }

    private static String decode(String s) {
        return map(s, i -> i - 1);
    }

    private static String map(String s, final IntUnaryOperator mapper) {
        return s.chars().map(mapper).mapToObj(i -> new Character((char) i)).map(String::valueOf)
                .collect(Collectors.joining());
    }
}
