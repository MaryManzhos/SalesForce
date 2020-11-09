package utils;

import java.util.List;

public class Utils {

    public String convertAddress(String city, String state, String code) {
        return String.format(city + ", " + state + " " + code);
    }

    public boolean isExistElementInList(List<String> list, String str) {

        for (int i = 0; i < list.size(); i++) {
            if (str.equals(list.get(i))) {
                return true;
            }
        }
        return false;
    }

    public String convertName(String salutation, String firstName, String middleName, String lastName, String suffix) {
        return String.format(salutation + " " + firstName + " " + middleName + " " + lastName + " " + suffix);
    }

}
