/**
 * The class DummyTel.
 */
public class DummyTel {
    /**
     * The constant messages.
     */
    public static final String TIME_INVALID = "Time is invalid";
    public static final String MINUS_CALLING_INVALID = "Minus calling is invalid";


    /**
     * Calculate cost of calling
     *
     * @param hourStart    hour of start calling
     * @param minusStart   minus of start calling
     * @param minusCalling total minus of calling
     * @return cost of calling
     */
    public static double calc(int hourStart, int minusStart, int minusCalling) {
        //check time is valid
        if (hourStart < 0 || hourStart > 23 || minusStart < 0 || minusStart > 59) {
            throw new IllegalArgumentException(TIME_INVALID);
        }

        //check minus calling is valid
        if (minusCalling < 0) {
            throw new IllegalArgumentException(MINUS_CALLING_INVALID);
        }

        double ratio = 1;
        double tax = 0.05;
        double priceEachMinus = 0.5;

        //check if time start after 18:00 and before 8:00
        if (hourStart >= 18 || hourStart < 8) {
            ratio *= 0.5;
        }

        // check if minus calling is more than 60
        if (minusCalling > 60) {
            ratio *= 0.75;
        }

        // totalPrice round to 2 decimal places
        return Math.round((priceEachMinus * minusCalling * ratio * (1 + tax)) * 100.0) / 100.0;
    }
}
