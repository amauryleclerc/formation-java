package fr.sii.java8.ex04Stream;

record Bed(int forPersonCount) {

	public static Bed bed(int forPersonCount) {
		return new Bed(forPersonCount);
	}

}
