package example2;

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

    }
}
