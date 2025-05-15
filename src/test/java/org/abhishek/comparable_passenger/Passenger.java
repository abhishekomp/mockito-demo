package org.abhishek.comparable_passenger;

public class Passenger implements Comparable<Passenger>{

    private final String name;
    private final int memberLevel;
    private final int memberDays;

    public Passenger(String name, int memberLevel, int memberDays) {
        this.name = name;
        this.memberLevel = memberLevel; // 1 = Gold(Member with this level comes at the top when sorting passengers), 2 = Silver, 3 = Bronze
        this.memberDays = memberDays;
    }

    public String getName() {
        return name;
    }
    public int getMemberLevel() {
        return memberLevel;
    }
    public int getMemberDays() {
        return memberDays;
    }
    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", memberLevel=" + memberLevel +
                ", memberDays=" + memberDays +
                '}';
    }

    @Override
    public int compareTo(Passenger otherPassenger) {
        // Compare by member level first (lower number is better)
        // A positive value indicates this passenger is "greater" than the other, hence other passenger will come first
        // A negative value indicates this passenger is "lesser" than the other, hence this passenger will come first
        // A zero value indicates both passengers are equal

        // In this case, we are comparing the member level first, and if they are equal, we compare the member days.
        // In our case, member level = 1 comes first, then member level = 2, and finally member level = 3.
        // The passenger with the lower member level comes first. If the member levels are equal, the passenger with more member days comes first.
        int compare = Integer.compare(this.memberLevel, otherPassenger.memberLevel);
        if (compare == 0) {
            compare = Integer.compare(otherPassenger.getMemberDays(), this.getMemberDays());
        }
        return compare;
    }
    //README about how the sorting will happen with Comparable
    // When using Comparable, we should also override equals and hashCode methods to ensure consistency
    // When you write the compareTo method, you should also override the equals and hashCode methods
    // When you write the compareTo method, it is generally like this: public int compareTo(Passenger otherPassenger)
    // Now the code inside could be like this: Integer.compare(this.getMemberDays(), otherPassenger.getMemberDays())
    // In this case, a negative value indicates this passenger is "lesser" than the other, hence this passenger will come first
    // A positive value indicates this passenger is "greater" than the other, hence other passenger will come first
    // A zero value indicates both passengers are equal
}
