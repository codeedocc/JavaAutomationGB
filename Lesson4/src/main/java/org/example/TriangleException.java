package org.example;

import org.opentest4j.AssertionFailedError;

public class TriangleException extends org.opentest4j.AssertionFailedError{
    public TriangleException(AssertionFailedError error) {
        super(error.getMessage());

    }
}
