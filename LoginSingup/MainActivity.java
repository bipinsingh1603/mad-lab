package com.example.signupandlogin;

import androidx.activity.ComponentActivity;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

import static android.opengl.ETC1.isValid;

public class MainActivity extends AppCompatActivity {
    private Button signup;
    private EditText usName, password;
    private String uname, pswd;
    private static final String PASSWORD_PATTERN= "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\\\d)(?=.*[@$!])[A-Zaz\\\\d@$!]{8,}$";

    Pattern psPattern= Pattern.compile(PASSWORD_PATTERN);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signup = findViewById((R.id.btnSignUp));
        usName = findViewById(R.id.usName);
        password = findViewById(R.id.password);


        signup.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                uname = usName.getText().toString();
                pswd = password.getText().toString();
                if (uname.isEmpty() || pswd.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Username/Password cannot be Empty!", Toast.LENGTH_SHORT).show();
                }

                if (isvalid()) {
                    Bundle bundle = new Bundle();
                    bundle.putString("Username",uname);
                    bundle.putString("Password", pswd);

                    Intent intent = new Intent(getApplicationContext(), Login.class);
                    intent.putExtras(bundle);

                    startActivity(intent);
                }
            }
        });
    }
       private boolean isvalid(){
           if(psPattern.matcher(pswd).matches()){
              Toast.makeText(MainActivity.this, "Password should be atleast 1 uppercase, 1 lowercase letters\n"+ "Passoword should contain one letter, number and special character.\n"+"Minimum length of password is 8.",Toast.LENGTH_LONG).show();
              return false;
           }
           else
               return true;
        }
    }