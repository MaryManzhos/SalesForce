package utils;

import java.util.List;

public class Utils {

    private Utils() {
    }

    public static String convertAddress(String city, String state, String code) {
        return String.format(city + ", " + state + " " + code);
    }

    public static boolean isExistElementInList(List<String> list, String str) {

        for (int i = 0; i < list.size(); i++) {
            if (str.equals(list.get(i))) {
                return true;
            }
        }
        return false;
    }

    public static String convertName(String salutation, String firstName, String middleName, String lastName, String suffix) {
        return String.format(salutation + " " + firstName + " " + middleName + " " + lastName + " " + suffix);
    }

}
