package com.lumanman.decoratorpatternpractice;

public abstract class Decorator extends AbstractString {
    protected AbstractString string;

    public Decorator(AbstractString string){
        super(string.getString());
        this.string = string;
    }

    public abstract String getString();


}
