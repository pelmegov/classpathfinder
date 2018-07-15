package ru.pelmegov.classpathfinder;

import ru.pelmegov.classpathfinder.core.*;

import java.util.List;

class ClassFinder {

    public static void main(String[] args) {
        final ArgumentsReader argumentsReader = new ArgumentsReader(args);
        final FileLinesReader fileLinesReader = new FileLinesReader(argumentsReader.getFilePath());
        final SearchItemProvider searchItemProvider = new SearchItemProvider(fileLinesReader.getPreparedLines());
        final List<SearchItem> preparedSearchItems = searchItemProvider.getPreparedSearchItems();

        new DefaultClassFinder(preparedSearchItems).find(argumentsReader.getPattern());
    }

}
