package example2;

import java.util.Arrays;
import java.util.Optional;

public class OperationMain {

    public static void main(String[] args) {
        double x = 2;
        double y = 4;

        for (Operation operation: Operation.values()) {
            System.out.printf("%f %s %f = %f%n", x,operation, y, operation.apply(x,y));
        }

        System.out.println("----------");
        Optional<Operation> optionalOperation = Operation.fromString("+");
        optionalOperation.ifPresent(operation -> System.out.printf("%f%n", operation.apply(x, y)));

        System.out.println("----------");
        Arrays.stream(Operation2.values()).forEach(operation -> {
            System.out.printf("%f %s %f = %f%n", x, operation, y, operation.apply(x,y));
        });
        System.out.println("----------");
        Optional<Operation2> optionalOperation2 = Operation2.fromString("+");
        optionalOperation2.ifPresent(operation -> System.out.printf("%f%n", operation.apply(x, y)));

    }
}
