package com.recycup.recycup_cafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.davidmiguel.numberkeyboard.NumberKeyboard;
import com.davidmiguel.numberkeyboard.NumberKeyboardListener;

public class PhoneNumberLoginActivity extends AppCompatActivity {

    TextView phoneNumberTextView;
    NumberKeyboard numberKeyboard;
    Button nextButton;
    Button previousButton;
    String from;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_number_login);

        Intent intent = getIntent();

        if(intent.hasExtra("from")){
            from = intent.getStringExtra("from");

        }

        phoneNumberTextView = findViewById(R.id.phoneNumberTextView);
        numberKeyboard = findViewById(R.id.numberKeyBoard);
        numberKeyboard.setListener(new NumberKeyboardListener() {
            @Override
            public void onNumberClicked(int i) {
                phoneNumberTextView.append(String.valueOf(i));
            }

            @Override
            public void onLeftAuxButtonClicked() {

            }

            @Override
            public void onRightAuxButtonClicked() {
                if(phoneNumberTextView.getText().toString().length()>0){
                    String string = phoneNumberTextView.getText().toString().substring(0, phoneNumberTextView.getText().toString().length()-1);
                    phoneNumberTextView.setText(string);
                }

            }
        });

        nextButton = findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PhoneNumberPasswordActivity.class);
                intent.putExtra("phoneNumber", phoneNumberTextView.getText().toString());
                intent.putExtra("from", from);

                startActivity(intent);
            }
        });
        previousButton = findViewById(R.id.previousButton);
        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
