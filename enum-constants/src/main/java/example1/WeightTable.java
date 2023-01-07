package example1;

public class WeightTable {

    public static void main(String[] args) {
        double earthWeight = 80;
        double mass = earthWeight / Planet.EARTH.getSurfaceGravity();
        for (Planet planet: Planet.values()) {
            System.out.printf("Weight on %s is %f%n", planet, planet.surfaceWeight(mass));
        }
    }
}
