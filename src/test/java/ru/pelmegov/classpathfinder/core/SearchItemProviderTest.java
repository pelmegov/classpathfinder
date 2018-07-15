package ru.pelmegov.classpathfinder.core;

import org.junit.Test;
import ru.pelmegov.classpathfinder.core.SearchItem;
import ru.pelmegov.classpathfinder.core.SearchItemProvider;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.junit.Assert.assertThat;

public class SearchItemProviderTest {

    @Test
    public void createSearchItems() {
        final List<String> strings = new ArrayList<>();
        strings.add("abc.ClassName");
        strings.add("bcd.ClassName2");
        strings.add("ClassNameWithoutClassPath");

        final SearchItemProvider searchItemProvider = new SearchItemProvider(strings);

        final List<SearchItem> preparedSearchItems = searchItemProvider.getPreparedSearchItems();

        // elements have class path
        assertThat(preparedSearchItems, hasItem(new SearchItem("ClassName", "abc")));
        assertThat(preparedSearchItems, hasItem(new SearchItem("ClassName2", "bcd")));

        // empty class path
        assertThat(preparedSearchItems, hasItem(new SearchItem("ClassNameWithoutClassPath", "")));
    }

}