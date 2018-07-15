package ru.pelmegov.classpathfinder.core;

import lombok.NonNull;

import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class SearchItemProvider {

    private final List<SearchItem> searchItems;

    public SearchItemProvider(@NonNull List<String> preparedLines) {
        final List<SearchItem> preparedList = preparedLines.stream()
                .map(e -> new SearchItem(prepareClassName(e), prepareClassPath(e)))
                .collect(toList());

        searchItems = Collections.unmodifiableList(preparedList);
    }

    public List<SearchItem> getPreparedSearchItems() {
        return searchItems;
    }

    private String prepareClassPath(String inputString) {
        if (!inputString.contains(".")) {
            return "";
        }
        return inputString.substring(0, inputString.lastIndexOf("."));
    }

    private String prepareClassName(String inputString) {
        if (!inputString.contains(".")) {
            return inputString;
        }
        return inputString.substring(inputString.lastIndexOf(".") + 1);
    }
}
