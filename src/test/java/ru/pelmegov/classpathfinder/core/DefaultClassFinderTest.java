package ru.pelmegov.classpathfinder.core;

import org.junit.Test;
import ru.pelmegov.classpathfinder.core.DefaultClassFinder;
import ru.pelmegov.classpathfinder.core.SearchItem;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.*;

public class DefaultClassFinderTest {

    @Test
    public void findByContainsClassName() {

        final SearchItem searchItem1 = new SearchItem("OneClassNameItem", "abc.bcd");
        final SearchItem searchItem2 = new SearchItem("SecondClassNameItem", "abc.bcd");

        final DefaultClassFinder classFinder = new DefaultClassFinder(Arrays.asList(searchItem1, searchItem2));

        final List<SearchItem> foundSearchItems = classFinder.find("ClassName");

        assertThat(foundSearchItems, hasSize(2));
    }

    @Test
    public void findByContainsStars() {

        final SearchItem searchItem1 = new SearchItem("CasesNameItem", "abc.bcd");
        final SearchItem searchItem2 = new SearchItem("ClassNameItem", "abc.bcd");

        final DefaultClassFinder classFinder = new DefaultClassFinder(Arrays.asList(searchItem1, searchItem2));

        final List<SearchItem> foundSearchItems = classFinder.find("C*sName");

        assertThat(foundSearchItems, hasSize(2));
    }

    @Test
    public void findByContainsEndWithSpace() {

        final SearchItem searchItem1 = new SearchItem("CasesNameItem1", "abc.bcd");
        final SearchItem searchItem2 = new SearchItem("ClassNameItem2", "abc.bcd");
        final SearchItem searchItem3 = new SearchItem("ClassNameItem", "abc.bcd");

        final DefaultClassFinder classFinder = new DefaultClassFinder(Arrays.asList(searchItem1, searchItem2, searchItem3));

        final List<SearchItem> foundSearchItems = classFinder.find("ClassNameItem ");

        assertThat(foundSearchItems, hasSize(1));
    }

}