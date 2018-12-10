package com.lumanman.decoratorpatternpractice;

public abstract class AbstractString {
    protected String string;

    public AbstractString(String str){
        this.string = str;
    }

    public abstract String getString();
}
