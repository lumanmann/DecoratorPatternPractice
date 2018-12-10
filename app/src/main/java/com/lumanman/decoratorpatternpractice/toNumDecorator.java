package com.lumanman.decoratorpatternpractice;

public class toNumDecorator extends Decorator {

    public toNumDecorator(AbstractString string) {
        super(string);
    }

    @Override
    public String getString() {
        // 將字串中的英文ascii碼讀出並串接回字串 ex. AB => 6566
        char[] tmpArray = string.getString().toCharArray();
        String tmp = "";
        for (char c: tmpArray) {

            int tmpNum = (int)c;

            if(tmpNum >= 65 && tmpNum <= 90 || tmpNum >= 97 && tmpNum <= 122) {
                tmp += Integer.toString(tmpNum);
            } else {
                tmp += c;
            }

        }
        return tmp;
    }
}
