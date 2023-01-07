import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

public enum Phase {

    SOLID, LIQUID, GAS;

    public enum Transition{

        MELT(SOLID, LIQUID), FREEZE(LIQUID, SOLID),
        BOIL(LIQUID, GAS), CONDENSE(GAS, LIQUID),
        SUBLIME(SOLID, GAS), DEPOSIT(GAS, SOLID);


        private final Phase from;
        private final Phase to;

        Transition(Phase from, Phase to) {
            this.from = from;
            this.to = to;
        }

        private static final Map<Phase, Map<Phase, Transition>> transitionMap;

        static {
            transitionMap = Arrays.stream(values()).collect(groupingBy(transition -> transition.from,
                    () -> new EnumMap<>(Phase.class),
                    toMap(transition -> transition.to,
                            transition -> transition,
                            (phase, transition) -> transition,
                            () -> new EnumMap<>(Phase.class))));
        }

        public static Map<Phase, Map<Phase, Transition>> getTransitionMap(){
            return transitionMap;
        }

        public static Transition from(Phase from, Phase to){
            return transitionMap.get(from).get(to);
        }
    }
}
