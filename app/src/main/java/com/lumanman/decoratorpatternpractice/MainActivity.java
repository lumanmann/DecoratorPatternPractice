package com.lumanman.decoratorpatternpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

//        撰寫一程式來模擬字串附加效果
//
//        利用裝飾者模式&Android實現以下功能
//
//        1. 讓使用者輸入一字串
//
//        2. 使用者可以選擇按下任意按鈕添加字串效果
//
//                ---加密按鈕:利用hash Function將字串中的文字逐個%17 +65並存回
//
//                ---轉大寫按鈕:將字串中的文字轉為全大寫
//
//                ---轉小寫按鈕:將字串中的文字轉為全小寫
//
//                ---英文to數字按鈕:將字串中的英文ascii碼讀出並串接回字串 ex. AB => 6566
//
//                ---輸出按鈕: 按下後執行先前所點擊之所有效果(按點擊順序執行)，並輸出結果

public class MainActivity extends AppCompatActivity {

    Button btn_encryption;
    Button btn_uppercase;
    Button btn_lowercase;
    Button btn_toNum;
    Button btn_output;
    EditText editText;
    TextView textView;
    AbstractString str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_encryption = findViewById(R.id.button_encryption);
        btn_lowercase = findViewById(R.id.button_toLowercase);
        btn_output = findViewById(R.id.button_output);
        btn_toNum = findViewById(R.id.button_toNum);
        btn_uppercase = findViewById(R.id.button_toUppercase);
        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);

//        TextView.OnEditorActionListener writeListener = new TextView.OnEditorActionListener() {
//            @Override
//            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//
//                if (actionId == EditorInfo.IME_ACTION_DONE) {
//
//
//                    Log.d("test", str.getString());
//                }
//                return true;
//
//            }
//        };

        // editText.setOnEditorActionListener(writeListener);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                str = new StringText(editText.getText().toString());
            }
        });


        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (str == null) {
                    return;
                }
                switch (v.getId()){
                    case R.id.button_encryption:
                        str = new EncryptionDecorator(str);
                        break;
                    case R.id.button_toUppercase:
                        str = new UppercaseDecorator(str);
                        break;
                    case R.id.button_toLowercase:
                        str = new LowercaseDecorator(str);
                        break;
                    case R.id.button_toNum:
                        str = new toNumDecorator(str);
                        break;
                    case R.id.button_output:
                        textView.setText(str.getString());
                        break;
                }
            }
        };

        btn_encryption.setOnClickListener(onClickListener);
        btn_uppercase.setOnClickListener(onClickListener);
        btn_lowercase.setOnClickListener(onClickListener);
        btn_toNum.setOnClickListener(onClickListener);
        btn_output.setOnClickListener(onClickListener);

    }
}
