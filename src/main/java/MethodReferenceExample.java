import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MethodReferenceExample {

    private final List<Integer> numbers;

    public MethodReferenceExample() {
        numbers = Arrays.asList(10, 41, 48, 1, 32, 16, 74);
        numbers.sort((n1, n2) -> compareItems(n1,n2));
    }

    public Integer compareItems(Integer a, Integer b) {
        return Integer.compare(a,b);
    }
}
