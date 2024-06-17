abstract class Vehicle {
    protected String brand;
    protected String model;
    protected double value;

    public Vehicle(String brand, String model, double value) {
        setBrand(brand);
        setModel(model);
        setValue(value);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        if (brand == null || brand.trim().isEmpty()) {
            throw new IllegalArgumentException("The brand name cannot be empty!");
        }
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if (model == null || model.trim().isEmpty()) {
            throw new IllegalArgumentException("The model name cannot be empty!");
        }
        this.model = model;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        if (value <= 0) {
            throw new IllegalArgumentException("The value must be greater than 0!");
        }
        this.value = value;
    }
}
