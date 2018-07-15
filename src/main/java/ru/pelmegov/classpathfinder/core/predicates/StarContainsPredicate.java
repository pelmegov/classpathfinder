package ru.pelmegov.classpathfinder.core.predicates;

import ru.pelmegov.classpathfinder.core.SearchItem;

import java.util.function.Predicate;

public class StarContainsPredicate implements Predicate<SearchItem> {
    private final String pattern;

    public StarContainsPredicate(String pattern) {
        this.pattern = pattern.trim();
    }

    @Override
    public boolean test(SearchItem searchItem) {
        String className = searchItem.getClassName();

        int offset = 0;
        final char[] patternChars = pattern.replace("*", "").toCharArray();
        final char[] inputWordChars = className.toCharArray();

        for (char currentChar : inputWordChars) {
            if (offset < patternChars.length
                    && patternChars[offset] == currentChar) {
                offset++;
            }
        }

        return offset == patternChars.length;
    }
}
