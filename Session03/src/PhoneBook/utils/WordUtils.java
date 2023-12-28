package PhoneBook.utils;

import java.util.Arrays;
import java.util.stream.Collectors;

public class WordUtils {
    private static final String WORD_SEPARATOR = " ";

    public static String convertToTitleCase(String str) {
        if (str == null) return null;
        if (str.isEmpty()) return str;

        var wordArrayStream = Arrays.stream(str.split(WORD_SEPARATOR));
        return wordArrayStream.map(word -> word.isEmpty()
                ? word :
                Character.toTitleCase(word.charAt(0)) + word.substring(1).toLowerCase()
        ).collect(Collectors.joining(WORD_SEPARATOR));
    }
}
