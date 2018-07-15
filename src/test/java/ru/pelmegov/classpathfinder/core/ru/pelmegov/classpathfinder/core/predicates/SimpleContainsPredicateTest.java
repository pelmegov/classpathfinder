package ru.pelmegov.classpathfinder.core.ru.pelmegov.classpathfinder.core.predicates;

import org.junit.Test;
import ru.pelmegov.classpathfinder.core.SearchItem;
import ru.pelmegov.classpathfinder.core.predicates.SimpleContainsPredicate;

import static org.junit.Assert.*;

public class SimpleContainsPredicateTest {

    @Test
    public void test1() {
        final SimpleContainsPredicate ucp = new SimpleContainsPredicate("FooBar");

        assertTrue(ucp.test(new SearchItem("AbsoluteFooBarPlease", "a.b")));
        assertTrue(ucp.test(new SearchItem("FooBar", "a.b")));
        assertTrue(ucp.test(new SearchItem("AbsoluteFooOoooBar", "a.b")));

        assertFalse(ucp.test(new SearchItem("BarFoo", "a.b")));
    }
}