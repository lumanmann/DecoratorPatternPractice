package com.lumanman.decoratorpatternpractice;

public class UppercaseDecorator extends Decorator {

    public UppercaseDecorator(AbstractString string) {
        super(string);
    }

    @Override
    public String getString() {
        return string.getString().toUpperCase();
    }
}
