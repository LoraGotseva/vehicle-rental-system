public class Car extends Vehicle {
    private final int safetyRating;

    public Car(String brand, String model, double value, int safetyRating) {
        super(brand, model, value);
        if (safetyRating < 1 || safetyRating > 5) {
            throw new IllegalArgumentException("Safety rating must be between 1 and 5!");
        }
        this.safetyRating = safetyRating;
    }

    public int getSafetyRating() {
        return safetyRating;
    }
}
