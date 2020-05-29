package com.example.onlineshopping.authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.onlineshopping.NavigationActivity;
import com.example.onlineshopping.R;

public class RegisterActivity extends AppCompatActivity {

    private EditText userName,emailReg,passwordReg;
    private Button registerButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        userName =  findViewById(R.id.user_name);
        emailReg = findViewById(R.id.regPassword);
        passwordReg = findViewById(R.id.regPassword);
        registerButton = findViewById(R.id.buttonRegister);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = userName.getText().toString();
                String email = emailReg.getText().toString();
                String password = passwordReg.getText().toString();

                if (TextUtils.isEmpty(user)) {
                    Toast.makeText(getApplicationContext(), "Enter user name!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if ( user.equals("sam") && email.equals("sam@gmail.com") && password.equals("123456")){
                    Intent intent = new Intent(RegisterActivity.this, NavigationActivity.class);
                   startActivity(intent);
                    finish();
                }
            }
        });
    }
}
