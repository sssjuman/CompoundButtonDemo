package com.example.compoundbuttondemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private TextView tv_text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private void findViews() {
        tv_text = (TextView) findViewById(R.id.tv_text);

        //第一個引數: 被點擊的RadioGroup
        //第二個引數: 被選取的RadioButton的ID
        //呼叫findViewById()取得該元件
        RadioGroup rg_gender = (RadioGroup) findViewById(R.id.rg_gender);
        rg_gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton radioButton = (RadioButton) radioGroup.findViewById(i);
                tv_text.setText(radioButton.getText());

            }
        });


        //OnCheckedChangeListener所屬的外部類別與RadioGroup不一樣
        //第一個引數: 被點擊的Switch
        //第二個引數: 是否被開啟(is Checked)的資訊
        Switch sw_wifi = (Switch) findViewById(R.id.sw_wifi);
        sw_wifi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Switch switch1 = (Switch) compoundButton;
                String switch1Name = switch1.getText().toString();

                String message = "";
                if (b) {
                    //顯示Switch上的文字與在layout檔的textOn的文字
                    message = switch1Name + " " + switch1.getTextOn();
                } else {
                    //顯示Switch上的文字與在layout檔的textOff的文字
                    message = switch1Name + " " + switch1.getTextOff();
                }
                tv_text.setText(message);
            }
        });
    }

    public void onPlace(View v) {
        CheckBox checkBox = (CheckBox) v;    //透過傳入的參數取得CheckBox，不透過(CheckBox) findViewById(R.id.cb_place)
        String checkBoxName = checkBox.getText().toString();

        String message = "";
        if (checkBox.isChecked()) {
            message = getString(R.string.checked) + " " + checkBoxName;
        } else {
            message = getString(R.string.unchecked) + " " + checkBoxName;
        }
        tv_text.setText(message);
    }

    public void onToggle(View v) {
        ToggleButton toggleButton = (ToggleButton) v;
        tv_text.setText(toggleButton.getText());     //顯示ToggleButton上的文字

    }

}