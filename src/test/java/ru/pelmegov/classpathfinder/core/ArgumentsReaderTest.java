package ru.pelmegov.classpathfinder.core;

import org.junit.Test;
import ru.pelmegov.classpathfinder.core.ArgumentsReader;

import static org.junit.Assert.*;

public class ArgumentsReaderTest {

    @Test
    public void tryReadLegalProperties() {
        final String filePath = "src/test/resources/classes.txt";
        final String pattern = "'pattern'";

        final ArgumentsReader argumentsReader = new ArgumentsReader(new String[]{filePath, pattern});

        assertEquals(filePath, argumentsReader.getFilePath());
        assertEquals(pattern, argumentsReader.getPattern());
    }

    @Test(expected = IllegalArgumentException.class)
    public void tryReadIllegalProperties() {
        new ArgumentsReader(new String[]{});

        fail();
    }
}