package example2;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.DoubleBinaryOperator;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public enum Operation2 {

    //Constant-specific
    PLUS("+", (x,y) -> x + y),
    MINUS("-",(x,y) -> x - y),
    TIMES("*", (x,y) -> x * y),
    DIVIDE("/", (x,y) -> x / y);


    private final String symbol;
    private final DoubleBinaryOperator operator;

    Operation2(String symbol, DoubleBinaryOperator operator) {
        this.symbol = symbol;
        this.operator = operator;
    }

    @Override
    public String toString() {
        return symbol;
    }


    public static Optional<Operation2> fromString(String symbol) {
        return Optional.ofNullable(stringToEnum.get(symbol));
    }

    private static final Map<String, Operation2> stringToEnum;

    static {
        stringToEnum = Stream.of(values()).collect(toMap(Objects::toString, Function.identity()));
    }

    public double apply(double x, double y){
        return operator.applyAsDouble(x, y);
    }
}
