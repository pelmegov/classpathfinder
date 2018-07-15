package ru.pelmegov.classpathfinder.core;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.*;

public class FileLinesReaderTest {

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalFilePath() {
        new FileLinesReader("123/123/path.txt");

        fail();
    }

    @Test
    public void readAllPreparedLines() {
        final FileLinesReader fileLinesReader = new FileLinesReader("src/test/resources/classes.txt");

        final List<String> preparedLines = fileLinesReader.getPreparedLines();

        assertThat(preparedLines, hasSize(9));
    }

}