package fr.sii.java8.ex04Stream;

final class Garden {
    private final int surface;

    public Garden(int surface) {
        this.surface = surface;
    }

    public int getSurface() {
        return surface;
    }

    public static Garden garden(int surface) {
        return new Garden(surface);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (prime * result) + surface;
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
        Garden other = (Garden) obj;
        if (surface != other.surface) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Garden[surface=" + surface + "]";
    }

}
