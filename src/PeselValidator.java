public class PeselValidator {
    public static boolean validatePesel(String pesel) {
        if (pesel.length() != 11) {
            return false;
        }

        int[] weights = {1, 3, 7, 9, 1, 3, 7, 9, 1, 3};
        int sum = 0;

        for (int i = 0; i < 10; i++) {
            sum += Character.getNumericValue(pesel.charAt(i)) * weights[i];
        }

        int calculatedChecksum = 10 - (sum % 10);
        if (calculatedChecksum == 10) {
            calculatedChecksum = 0;
        }

        int actualChecksum = Character.getNumericValue(pesel.charAt(10));

        return calculatedChecksum == actualChecksum;
    }
}