public class Main {

    public static void main(String[] args) {
        System.out.println(Plant.getPlantByLifeCycle());

        System.out.println(Phase.Transition.getTransitionMap());
        System.out.println(Phase.Transition.from(Phase.SOLID, Phase.LIQUID));
    }
}
