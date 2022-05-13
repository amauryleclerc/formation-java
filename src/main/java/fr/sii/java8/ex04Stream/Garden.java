package fr.sii.java8.ex04Stream;

record Garden(int surface) {

	public static Garden garden(int surface) {
		return new Garden(surface);
	}


}
