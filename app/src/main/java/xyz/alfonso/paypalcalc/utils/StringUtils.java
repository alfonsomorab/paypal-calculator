package xyz.alfonso.paypalcalc.utils;

import java.util.Random;

/**
 * Created by icrea on 11/08/17.
 */

public class StringUtils {

    public static String toTitleCase(String input) {
        StringBuilder titleCase = new StringBuilder();
        boolean nextTitleCase = true;

        for (char c : input.toCharArray()) {
            if (Character.isSpaceChar(c)) {
                nextTitleCase = true;
            } else if (nextTitleCase) {
                c = Character.toTitleCase(c);
                nextTitleCase = false;
            }

            titleCase.append(c);
        }

        return titleCase.toString();
    }

    public static String generateRandomString(){
//        Random generator = new Random();
//        StringBuilder randomStringBuilder = new StringBuilder();
//        int randomLength = generator.nextInt(7);
//        char tempChar;
//        for (int i = 0; i < randomLength; i++){
//            tempChar = (char) (generator.nextInt(96) + 32);
//            randomStringBuilder.append(tempChar);
//        }
//        return "iF$" + randomStringBuilder.toString();
//
//        StringBuilder sb = new StringBuilder(len);

        int len = 7;
        String DATA = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random RANDOM = new Random();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append(DATA.charAt(RANDOM.nextInt(DATA.length())));
        }

        return "iF$" + sb.toString();
    }
}
