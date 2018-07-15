package ru.pelmegov.classpathfinder.core;

import lombok.Value;

@Value
public class SearchItem {

    private final String className;
    private final String classPath;

    public String getAbsolutePath() {
        return classPath.equals("") ? className : classPath + "." + className;
    }

}
