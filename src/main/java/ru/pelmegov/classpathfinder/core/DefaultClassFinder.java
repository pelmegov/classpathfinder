package ru.pelmegov.classpathfinder.core;

import ru.pelmegov.classpathfinder.core.predicates.EndWithSpaceContainsPredicate;
import ru.pelmegov.classpathfinder.core.predicates.SimpleContainsPredicate;
import ru.pelmegov.classpathfinder.core.predicates.StarContainsPredicate;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

public class DefaultClassFinder {

    private final List<SearchItem> searchItems;

    public DefaultClassFinder(List<SearchItem> preparedSearchItems) {
        this.searchItems = preparedSearchItems;
    }

    public List<SearchItem> find(String pattern) {
        return searchItems.stream()
                .filter(getPredicate(pattern))
                .sorted(Comparator.comparing(SearchItem::getClassName))
                .collect(toList());
    }

    private Predicate<SearchItem> getPredicate(String pattern) {
        if (pattern.endsWith(" ")) {
            return new EndWithSpaceContainsPredicate(pattern);
        }
        if (pattern.contains("*")) {
            return new StarContainsPredicate(pattern);
        }
        return new SimpleContainsPredicate(pattern);
    }
}
