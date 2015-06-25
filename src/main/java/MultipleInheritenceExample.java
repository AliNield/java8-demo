
public class MultipleInheritenceExample {

    public interface InterfaceA {
        default void defaultMethod() {
            System.out.println("Interface A default");
        }
    }
    public interface InterfaceB {
        default void defaultMethod() {
            System.out.println("Interface B default");
        }
    }
    public class Implementation implements InterfaceA, InterfaceB {
        @Override
        public void defaultMethod() {
            InterfaceA.super.defaultMethod();
        }
    }
}
