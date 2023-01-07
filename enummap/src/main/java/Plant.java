import java.util.*;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;

public enum Plant {
    BASIL(LifeCycle.ANNUAL),
    CARROWAY(LifeCycle.BIENNIAL),
    DILL(LifeCycle.ANNUAL),
    LAVENDAR(LifeCycle.PERENNIAL);

    enum LifeCycle {
        ANNUAL, PERENNIAL, BIENNIAL

        }

    private final LifeCycle lifeCycle;

    Plant(LifeCycle lifeCycle) {
        this.lifeCycle = lifeCycle;
    }

    private static final Map<Plant.LifeCycle, Set<Plant>> plantByLifeCycle;

    static {
        plantByLifeCycle = Arrays.stream(Plant.values()).collect(groupingBy(plant -> plant.lifeCycle, () -> new EnumMap<>(LifeCycle.class), toSet()));
    }

    public static Map<Plant.LifeCycle, Set<Plant>> getPlantByLifeCycle(){
        return plantByLifeCycle;
    }



}
