package com.lumanman.decoratorpatternpractice;

public class LowercaseDecorator extends Decorator {
    public LowercaseDecorator(AbstractString string) {
        super(string);
    }

    @Override
    public String getString() {
        return string.getString().toLowerCase();
    }
}
