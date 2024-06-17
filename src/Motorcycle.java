public class Motorcycle extends Vehicle{
    private final int customerAge;

    public Motorcycle(String brand, String model, double value, int customerAge) {
        super(brand, model, value);
        if (customerAge < 18) {
            throw new IllegalArgumentException("Customer age must be at least 18");
        }
        this.customerAge = customerAge;
    }

    public int getCustomerAge() {
        return customerAge;
    }
}
