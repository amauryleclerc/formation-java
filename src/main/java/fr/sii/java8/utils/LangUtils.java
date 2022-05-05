package fr.sii.java8.utils;

import java.util.Optional;
import java.util.function.Consumer;

public class LangUtils {

	public static <T> void ifPresentOrElse(Optional<T> opt, Consumer<T> ifPresent, Runnable orElse) {
		if (opt.isPresent()) {
			ifPresent.accept(opt.get());
		} else {
			orElse.run();
		}
	}

	public static <T> Optional<T> opt(T t) {
		return Optional.of(t);
	}

}
