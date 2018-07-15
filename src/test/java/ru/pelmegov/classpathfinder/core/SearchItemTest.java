package ru.pelmegov.classpathfinder.core;

import org.junit.Test;
import ru.pelmegov.classpathfinder.core.SearchItem;

import static org.junit.Assert.*;

public class SearchItemTest {

    @Test
    public void getAbsolutePathWithClassPath() {
        final SearchItem actualSearchItem = new SearchItem("ClassName", "abc.bcd");

        assertEquals("abc.bcd.ClassName", actualSearchItem.getAbsolutePath());
    }

    @Test
    public void getAbsolutePathWithoutClassPath() {
        final SearchItem actualSearchItem = new SearchItem("ClassName", "");

        assertEquals("ClassName", actualSearchItem.getAbsolutePath());
    }
}