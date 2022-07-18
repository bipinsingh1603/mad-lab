package com.example.signupandlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    private Button btnLogin;
    private EditText usName,password;
    private String strname,strpswd;
    private int counter=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usName=findViewById(R.id.usNameLog);
        password = findViewById(R.id.passwordLog);
        btnLogin = findViewById(R.id.btnLogin);

        Bundle bundle = getIntent().getExtras();
        strname=bundle.getString("Username");
        strpswd=bundle.getString("Password");
        Intent intent = new Intent(getApplicationContext(),LoginSuccess.class);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(counter!=2){
                    if(usName.getText().toString().equals(strname) && password.getText().toString().equals(strpswd)){
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(Login.this,  "Username Password Invalid!",Toast.LENGTH_SHORT).show();
                        counter++;
                        usName.setText(null);
                        password.setText(null);
                    }
                }
                else{
                    Toast.makeText(Login.this, "MAximum Attempt reached",Toast.LENGTH_SHORT).show();
                    btnLogin.setEnabled(false);
                }
            }
        });
    }
}