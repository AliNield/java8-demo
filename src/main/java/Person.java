
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.StringJoiner;

public class Person {

    private String name;
    private LocalDate dateOfBirth;

    public Person(String name,  LocalDate dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getAge() {
        return dateOfBirth.until(LocalDate.now(), ChronoUnit.YEARS);
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getDayOfDateOfBirth() {
        return dateOfBirth.getDayOfMonth();
    }

    public int getMonthofDateOfBirth() {
        return dateOfBirth.getMonthValue();
    }

    public static int compareByAge(Person a, Person b) {
        return Long.compare(a.getAge(), b.getAge());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ")
                .add(name)
                .add(dateOfBirth.toString())
                .add(String.valueOf(getAge()))
                .toString();
    }
}
