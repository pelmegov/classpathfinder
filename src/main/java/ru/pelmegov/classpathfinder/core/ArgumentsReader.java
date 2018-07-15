package ru.pelmegov.classpathfinder.core;

import lombok.Getter;
import lombok.NonNull;

@Getter
public class ArgumentsReader {

    private final String filePath;
    private final String pattern;

    public ArgumentsReader(@NonNull String[] args) {

        if (args.length < 2) {
            throw new IllegalArgumentException("Arguments don't exists. " +
                    "Try use next syntax for run application: ./class-finder <filename> '<pattern>'");
        }

        this.filePath = args[0];
        this.pattern = args[1];
    }
}
