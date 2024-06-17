import java.text.DecimalFormat;
import java.time.LocalDate;

public class Invoice {
    private final LocalDate currentDate;
    private final String customerName;
    private final Pricing pricing;

    public Invoice(String customerName, Pricing pricing) {
        this.currentDate = LocalDate.now();

        if (customerName == null || customerName.trim().isEmpty()) {
            throw new IllegalArgumentException("The customer name cannot be empty!");
        }
        this.customerName = customerName;

        this.pricing = pricing;
    }

    public String getCustomerName() {
        return customerName;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        String output = "XXXXXXXXXX\n" +
                "Date: " + currentDate + "\n" +
                "Customer name: " + getCustomerName() + "\n" +
                "Rented Vehicle: " + pricing.getVehicle().getBrand() + " " + pricing.getVehicle().getModel() + "\n\n" +
                "Reservation start date: " + pricing.getRentalPeriod().getResStartDate() + "\n" +
                "Reservation end date: " + pricing.getRentalPeriod().getResEndDate() + "\n" +
                "Reserved rental days: " + pricing.getRentalPeriod().getRentalDays() + " days\n\n" +
                "Actual return date: " + pricing.getRentalPeriod().getActualReturnDate() + "\n" +
                "Actual rental days: " + pricing.getRentalPeriod().getActualRentalDays() + " days\n\n" +
                "Rental cost per day: $" + df.format(pricing.getRentalCostPerDay()) + "\n";

        if (pricing.getInsuranceAdditionValuePerDay() != 0) {
            output += "Initial insurance per day: $" + df.format(pricing.getInitialInsuranceCostPerDay()) + "\n" +
                    "Insurance addition per day: $" + df.format(pricing.getInsuranceAdditionValuePerDay()) + "\n" +
                    "Insurance per day: $" + df.format(pricing.getInsuranceCostPerDay()) + "\n\n";
        } else if (pricing.getInsuranceDiscountValuePerDay() != 0) {
            output += "Initial insurance per day: $" + df.format(pricing.getInitialInsuranceCostPerDay()) + "\n" +
                    "Insurance discount per day: $" + df.format(pricing.getInsuranceDiscountValuePerDay()) + "\n" +
                    "Insurance per day: $" + df.format(pricing.getInsuranceCostPerDay()) + "\n\n" +
                    "Early return discount for rent: $" + df.format(pricing.getRentDiscount()) + "\n" +
                    "Early return discount for insurance: $" + df.format(pricing.getInsuranceDiscount()) + "\n\n";
        } else {
            output += "Insurance per day: $" + df.format(pricing.getInsuranceCostPerDay()) + "\n\n";
        }
        output += "Total rent: $" + df.format(pricing.getTotalRent()) + "\n" +
                "Total insurance: $" + df.format(pricing.getTotalInsurance()) + "\n" +
                "Total: $" + df.format(pricing.getTotalCost()) + "\n" +
                "XXXXXXXXXX";

        return output;
    }

}
