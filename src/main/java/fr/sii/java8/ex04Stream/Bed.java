package fr.sii.java8.ex04Stream;

final class Bed {
	private final int forPersonCount;

	public static Bed bed(int forPersonCount) {
		return new Bed(forPersonCount);
	}

	public Bed(int forPersonCount) {
		this.forPersonCount = forPersonCount;
	}

	public int getForPersonCount() {
		return forPersonCount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + forPersonCount;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Bed other = (Bed) obj;
		if (forPersonCount != other.forPersonCount) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Bed[forPersonCount=" + forPersonCount + "]";
	}

}
