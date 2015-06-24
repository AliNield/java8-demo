import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamDemo {

    private List<Person> people;

    private Predicate<Person> isPersonYoungerThan10 = new Predicate<Person>() {
        @Override
        public boolean test(Person person) {
            return person.getAge() < 10;
        }
    };

    private Predicate<Integer> isGreaterThan10Lambda  = i -> i < 10;

    public StreamDemo() {
        people = Arrays.asList(
                new Person("David", LocalDate.of(1993, 04, 19)),
                new Person("Simon", LocalDate.of(1993, 06, 29)),
                new Person("Robert", LocalDate.of(1991, 02, 28)),
                new Person("Sally", LocalDate.of(2015, 04, 01)),
                new Person("Snoop Dogg", LocalDate.of(2011, 07, 01)),
                new Person("Richard", LocalDate.of(1985, 12, 25)),
//                new Person("Robert", LocalDate.of(1991, 02, 30)),
                new Person("Zoe", LocalDate.of(1968, Month.FEBRUARY, 11)));
    }

    public void findPeopleOlderThan25() {
        System.out.println("People older than 25");
        List<Person> peopleOlderThan25 = people.stream()
                                            .filter(person -> person.getAge() > 25)
                                            .peek(System.out::println)
                                            .collect(Collectors.toCollection(ArrayList::new));

        System.out.println("People younger than 10");
        List <Person> peopleOlderThan10 = people.stream()
                                            .filter(isPersonYoungerThan10)
                                            .peek(System.out::println)
                                            .collect(Collectors.toList());

    }

    public void getAverageAge() {
        Double averageAge = people.parallelStream()
                                .mapToDouble(Person::getAge)
                                .average()
                                .getAsDouble();
        System.out.println("Average age is: " + averageAge);
    }

    public void findPersonWithTheNextBirthday() {
        Comparator<Person> birthdayComparator = Comparator.comparing(Person::getMonthofDateOfBirth)
                                                                .thenComparing(Person::getDayOfDateOfBirth);
        people.sort(birthdayComparator);

        Person personWithNextBirthday = people.stream()
                .sorted(birthdayComparator)
                .filter(person -> person.getMonthofDateOfBirth() >= LocalDate.now().getMonthValue())
                .findFirst()
                .get();

        System.out.println(personWithNextBirthday);
    }

    public static void main(String[] args) {
        StreamDemo streamDemo = new StreamDemo();
        streamDemo.findPeopleOlderThan25();
        streamDemo.getAverageAge();
        streamDemo.findPersonWithTheNextBirthday();
    }


}
