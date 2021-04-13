package ru.vbolokhov.collections;

/**
 * @author Vadim Bolokhov
 */
public class NotImplementedException extends RuntimeException {
    public NotImplementedException() {
        super("Implement me");
    }
}
