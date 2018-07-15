package ru.pelmegov.classpathfinder.core;

import lombok.NonNull;

import java.io.IOException;
import java.util.List;

import static java.nio.file.Files.readAllLines;
import static java.nio.file.Paths.get;
import static java.util.stream.Collectors.toList;

public class FileLinesReader {

    private final List<String> lines;

    public FileLinesReader(@NonNull String filePath) {
        this.lines = readLines(filePath);
    }

    public List<String> getPreparedLines() {
        return lines.stream()
                .filter(e -> !e.isEmpty())
                .map(String::trim)
                .collect(toList());
    }

    private List<String> readLines(@NonNull String filePath) {
        try {
            return readAllLines(get(filePath));
        } catch (IOException e) {
            throw new IllegalArgumentException("File " + filePath + " doesn't exists.");
        }
    }
}
