public class CargoVan extends Vehicle {
    private final int customerExperience;

    public CargoVan(String brand, String model, double value, int customerExperience) {
        super(brand, model, value);
        if (customerExperience < 0) {
            throw new IllegalArgumentException("Customer experience must be non-negative!");
        }
        this.customerExperience = customerExperience;
    }

    public int getCustomerExperience() {
        return customerExperience;
    }
}
