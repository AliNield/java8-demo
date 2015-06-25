import java.util.List;
import java.util.function.Supplier;

import static java.util.Arrays.asList;

public class TypeErasureDemo {
//
//    public void doSomething(List<String> listOfStrings) {
//        listOfStrings
//                .forEach(string -> System.out.println(string));
//    }
//
//    public void doSomething(List<Integer> listOfIntegers){
//        listOfIntegers
//                .stream()
//                .filter(i -> i % 2 == 0)
//                .forEach(integer -> System.out.println(integer));
//    }


    public interface StringListRef extends Supplier<List<String>> {}
    public interface IntegerListRef extends Supplier<List<Integer>> {}

    public void doSomething(StringListRef listOfStrings) {
        listOfStrings
                .get()
                .forEach(string -> System.out.println(string));
    }

    public void doSomething(IntegerListRef listOfIntegers) {
        listOfIntegers
                .get()
                .stream()
                .filter(i -> i % 2 == 0)
                .forEach(integer -> System.out.println(integer));
    }

    public static void main(String[] args) {
        TypeErasureDemo typeErasureDemo = new TypeErasureDemo();

        typeErasureDemo.doSomething(() -> asList("Java", "Is", "Cool"));
        typeErasureDemo.doSomething(() -> asList(10, 11, 12));
    }
}
