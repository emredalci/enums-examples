import java.util.Collection;
import java.util.List;

public class OperationMain2 {

    public static void main(String[] args) {
        double x = 10;
        double y = 5;

        test(List.of(ExtendedOperation.values()), x, y);
    }

    private static void test(Collection<? extends Operation> operationSet, double x, double y){
        operationSet.forEach(operation -> System.out.printf("%f %s %f = %f%n", x,operation,y, operation.apply(x,y)));
    }
}
