package fr.sii.java8.utils;

public class ExerciceAFaireException extends RuntimeException {

    private static final long serialVersionUID = 5430956080158011953L;

    public static <T> T exerciceAFaire() {
        return exerciceAFaire("A vos claviers!...");
    }

    public static <T> T exerciceAFaire(String msg) {
        if (true) {
            throw new ExerciceAFaireException(msg);
        }

        return null;
    }

    public ExerciceAFaireException() {
        super();
    }

    public ExerciceAFaireException(String message) {
        super(message);
    }

}
