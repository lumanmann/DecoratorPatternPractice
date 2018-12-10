package com.lumanman.decoratorpatternpractice;

public class StringText extends AbstractString {

    public StringText(String str){
        super(str);
    }

    public String getString() {
        return this.string;
    }


}
