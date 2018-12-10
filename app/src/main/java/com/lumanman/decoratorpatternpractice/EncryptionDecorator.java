package com.lumanman.decoratorpatternpractice;

import android.util.Log;

public class EncryptionDecorator extends Decorator {

    public EncryptionDecorator(AbstractString string) {
        super(string);
    }

    @Override
    public String getString() {
        // 利用hash Function將字串中的文字逐個%17 +65並存回
        char[] tmpArray = string.getString().toCharArray();
        String tmp = "";
        for (char c: tmpArray) {
            int tmpNum = (int)c;
            tmpNum = tmpNum % 17 + 65;
            tmp += Integer.toString(tmpNum);
        }
        return tmp;
    }
}
