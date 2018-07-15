package ru.pelmegov.classpathfinder.core.predicates;

import ru.pelmegov.classpathfinder.core.SearchItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class EndWithSpaceContainsPredicate implements Predicate<SearchItem> {

    private final String pattern;

    public EndWithSpaceContainsPredicate(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public boolean test(SearchItem searchItem) {
        String className = searchItem.getClassName();

        if (new SimpleContainsPredicate(pattern).test(searchItem)) {
            final char[] chars = className.toCharArray();
            final List<Character> lastWordStartsUppercase = new ArrayList<>();

            for (int i = chars.length - 1; i > 0; i--) {
                final char currentChar = chars[i];
                lastWordStartsUppercase.add(currentChar);
                if (Character.isUpperCase(currentChar)) {
                    break;
                }
            }

            Collections.reverse(lastWordStartsUppercase);

            StringBuilder lastWord = new StringBuilder();
            for (char letter : lastWordStartsUppercase) {
                lastWord.append(letter);
            }
            return pattern.trim().endsWith(lastWord.toString());
        }

        return false;
    }
}
