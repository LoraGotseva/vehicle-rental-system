public class Pricing {
    private final double rentalCostPerDay;
    private final double initialInsuranceCostPerDay;
    private final double insuranceAdditionValuePerDay;
    private final double insuranceDiscountValuePerDay;
    private final double insuranceCostPerDay;
    private final double rentDiscount;
    private final double insuranceDiscount;
    private final double totalRent;
    private final double totalInsurance;
    private final double totalCost;
    private final Vehicle vehicle;
    private final RentalPeriod rentalPeriod;

    public Pricing(Vehicle vehicle, RentalPeriod rentalPeriod) {
        this.rentalCostPerDay = calcRentalCostBasedOnVehicleType(vehicle, rentalPeriod);
        this.initialInsuranceCostPerDay = calcInitialInsuranceCostBasedOnVehicleType(vehicle);
        this.insuranceAdditionValuePerDay = calcAdditionInsuranceValueBasedOnVehicleType(vehicle);
        this.insuranceDiscountValuePerDay = calcDiscountInsuranceValueBasedOnVehicleType(vehicle);
        this.insuranceCostPerDay = calcInsuranceCostPerDay(vehicle);
        this.rentDiscount = calcRentDiscount(rentalPeriod);
        this.insuranceDiscount = calcInsuranceDiscount(rentalPeriod);
        this.totalRent = (rentalPeriod.getRentalDays() * getRentalCostPerDay()) - getRentDiscount();
        this.totalInsurance = rentalPeriod.getActualRentalDays() * getInsuranceCostPerDay();
        this.totalCost = getTotalRent() + getTotalInsurance();
        this.vehicle = vehicle;
        this.rentalPeriod = rentalPeriod;
    }

    public double getRentalCostPerDay() {
        return rentalCostPerDay;
    }

    public double getInitialInsuranceCostPerDay() {
        return initialInsuranceCostPerDay;
    }

    public double getInsuranceAdditionValuePerDay() {
        return insuranceAdditionValuePerDay;
    }

    public double getInsuranceDiscountValuePerDay() {
        return insuranceDiscountValuePerDay;
    }

    public double getInsuranceCostPerDay() {
        return insuranceCostPerDay;
    }

    public double getRentDiscount() {
        return rentDiscount;
    }

    public double getInsuranceDiscount() {
        return insuranceDiscount;
    }

    public double getTotalRent() {
        return totalRent;
    }

    public double getTotalInsurance() {
        return totalInsurance;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public RentalPeriod getRentalPeriod() {
        return rentalPeriod;
    }

    private double calcRentalCostBasedOnVehicleType(Vehicle vehicle, RentalPeriod rentalPeriod) {
        if (rentalPeriod.getActualRentalDays() <= 7) {
            if (vehicle instanceof Car) {
                return 20.0;
            } else if (vehicle instanceof Motorcycle) {
                return 15.0;
            } else if (vehicle instanceof CargoVan) {
                return 50.0;
            } else {
                throw new IllegalArgumentException("Unsupported vehicle type!");
            }
        } else {
            if (vehicle instanceof Car) {
                return 15.0;
            } else if (vehicle instanceof Motorcycle) {
                return 10.0;
            } else if (vehicle instanceof CargoVan) {
                return 40.0;
            } else {
                throw new IllegalArgumentException("Unsupported vehicle type!");
            }
        }
    }

    private double calcInitialInsuranceCostBasedOnVehicleType(Vehicle vehicle) {
        if (vehicle instanceof Car) {
            return 0.0001 * vehicle.getValue();
        } else if (vehicle instanceof Motorcycle) {
            return 0.0002 * vehicle.getValue();
        } else if (vehicle instanceof CargoVan) {
            return 0.0003 * vehicle.getValue();
        } else {
            throw new IllegalArgumentException("Unsupported vehicle type!");
        }
    }

    private double calcAdditionInsuranceValueBasedOnVehicleType(Vehicle vehicle) {
        if (vehicle instanceof Car) {
            return 0.0;
        } else if (vehicle instanceof Motorcycle motorcycle) {
            if (motorcycle.getCustomerAge() < 25) {
                return getInitialInsuranceCostPerDay() * 0.20;
            } else {
                return 0.0;
            }
        } else if (vehicle instanceof CargoVan) {
            return 0.0;
        } else {
            throw new IllegalArgumentException("Unsupported vehicle type!");
        }
    }

    private double calcDiscountInsuranceValueBasedOnVehicleType(Vehicle vehicle) {
        if (vehicle instanceof Car car) {
            if (car.getSafetyRating() >=4 ) {
                return getInitialInsuranceCostPerDay() * 0.10;
            } else {
                return 0.0;
            }
        } else if (vehicle instanceof Motorcycle) {
            return 0;
        } else if (vehicle instanceof CargoVan cargoVan) {
            if (cargoVan.getCustomerExperience() > 5) {
                return getInitialInsuranceCostPerDay() * 0.15;
            } else {
                return 0.0;
            }
        } else {
            throw new IllegalArgumentException("Unsupported vehicle type!");
        }
    }

    private double calcInsuranceCostPerDay(Vehicle vehicle) {
        if (vehicle instanceof Motorcycle) {
            return getInitialInsuranceCostPerDay() + getInsuranceAdditionValuePerDay();
        } else if (vehicle instanceof Car || vehicle instanceof CargoVan) {
            return getInitialInsuranceCostPerDay() - getInsuranceDiscountValuePerDay();
        } else {
            throw new IllegalArgumentException("Unsupported vehicle type!");
        }
    }

    private double calcRentDiscount(RentalPeriod rentalPeriod) {
        if (rentalPeriod.getActualRentalDays() < rentalPeriod.getRentalDays()) {
            return (rentalPeriod.getRentalDays() - rentalPeriod.getActualRentalDays()) * getRentalCostPerDay() / 2.0;
        } else {
            return 0.0;
        }
    }

    private double calcInsuranceDiscount(RentalPeriod rentalPeriod) {
        if (rentalPeriod.getActualRentalDays() < rentalPeriod.getRentalDays()) {
            return (rentalPeriod.getRentalDays() - rentalPeriod.getActualRentalDays()) * getInsuranceCostPerDay();
        } else {
            return 0.0;
        }
    }
}
