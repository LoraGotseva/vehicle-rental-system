import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class RentalPeriod {
    private final LocalDate resStartDate;
    private final LocalDate resEndDate;
    private final int rentalDays;
    private final LocalDate actualReturnDate;
    private final int actualRentalDays;

    public RentalPeriod(LocalDate resStartDate, LocalDate resEndDate, LocalDate actualReturnDate) {
        validateReservationDates(resStartDate, resEndDate);
        validateActualReturnDate(resStartDate, resEndDate, actualReturnDate);

        this.resStartDate = resStartDate;
        this.resEndDate = resEndDate;
        this.actualReturnDate = actualReturnDate;
        this.rentalDays = calcRentalDays();
        this.actualRentalDays = calcActualRentalDays();
    }

    public LocalDate getResStartDate() {
        return resStartDate;
    }

    public LocalDate getResEndDate() {
        return resEndDate;
    }

    public int getRentalDays() {
        return rentalDays;
    }

    public LocalDate getActualReturnDate() {
        return actualReturnDate;
    }

    public int getActualRentalDays() {
        return actualRentalDays;
    }

    private int calcRentalDays() {
        if (resStartDate != null && resEndDate != null) {
            return (int) ChronoUnit.DAYS.between(resStartDate, resEndDate);
        }
        return 0;
    }

    private int calcActualRentalDays() {
        if (resStartDate != null && actualReturnDate != null) {
            return (int) ChronoUnit.DAYS.between(resStartDate, actualReturnDate);
        }
        return 0;
    }

    private void validateReservationDates(LocalDate resStartDate, LocalDate resEndDate) {
        if (resStartDate == null) {
            throw new IllegalArgumentException("Reservation start date cannot be null!");
        }
        if (resEndDate == null) {
            throw new IllegalArgumentException("Reservation end date cannot be null!");
        }
        if (resEndDate.isBefore(resStartDate)) {
            throw new IllegalArgumentException("Reservation end date cannot be before the start date!");
        }
    }

    private void validateActualReturnDate(LocalDate resStartDate, LocalDate resEndDate, LocalDate actualReturnDate) {
        if (actualReturnDate == null) {
            throw new IllegalArgumentException("Actual return date cannot be null!");
        }
        if (actualReturnDate.isBefore(resStartDate)) {
            throw new IllegalArgumentException("Actual return date cannot be before the reservation start date!");
        }
        if (actualReturnDate.isAfter(resEndDate)) {
            throw new IllegalArgumentException("Actual return date cannot be after the reservation end date!");
        }
    }
}
