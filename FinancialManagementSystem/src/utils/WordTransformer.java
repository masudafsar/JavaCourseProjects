package utils;

import java.util.Arrays;
import java.util.stream.Collectors;

public class WordTransformer {
    private static final String WORD_SEPARATOR = " ";

    public static String toTitleCase(String str) {
        if (str == null) return null;
        if (str.isEmpty()) return str;

        var words = str.split(WORD_SEPARATOR);
        var wordsStream = Arrays.stream(words).map(
                word -> word.isEmpty()
                        ? word
                        : capitalFirst(word)
        );
        return wordsStream.collect(Collectors.joining(WORD_SEPARATOR));
    }

    public static String capitalFirst(String str) {
        return Character.toTitleCase(str.charAt(0)) +
                str.substring(1).toLowerCase();
    }
}
