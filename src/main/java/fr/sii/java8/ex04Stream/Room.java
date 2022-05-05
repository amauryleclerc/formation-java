package fr.sii.java8.ex04Stream;

import java.util.List;

import static java.util.Arrays.asList;

final class Room {

    private final int windowCount;

    private final List<Bed> beds;

    public Room(int windowCount, List<Bed> beds) {
        this.windowCount = windowCount;
        this.beds = beds;
    }

    public int getWindowCount() {
        return windowCount;
    }

    public List<Bed> getBeds() {
        return beds;
    }

    public static Room room(int windowCount, Bed... beds) {
        return new Room(windowCount, asList(beds));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (prime * result) + ((beds == null) ? 0 : beds.hashCode());
        result = (prime * result) + windowCount;
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
        Room other = (Room) obj;
        if (beds == null) {
            if (other.beds != null) {
                return false;
            }
        } else if (!beds.equals(other.beds)) {
            return false;
        }
        if (windowCount != other.windowCount) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Room[windowCount=" + windowCount + ", beds=" + beds + "]";
    }

}
