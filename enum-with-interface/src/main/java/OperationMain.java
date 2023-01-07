import java.util.Arrays;

public class OperationMain {

    public static void main(String[] args) {
        double x = 10;
        double y = 5;

        test(ExtendedOperation.class, x, y);

    }

    private static <T extends Enum<T> & Operation> void test(Class<T> operationEnumType, double x, double y){

        Arrays.stream(operationEnumType.getEnumConstants())
                .forEach(operation -> System.out.printf("%f %s %f = %f%n", x,operation,y, operation.apply(x,y)));
    }
}
