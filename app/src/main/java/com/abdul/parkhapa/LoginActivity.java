package com.abdul.parkhapa;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.login.widget.LoginButton;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    EditText inputEmail;
    EditText inputPassword;
    Button btn_login;
    ProgressDialog progressDialog;
    LoginButton loginButton;
    TextView txtforgot ,txtSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initializeViews();
        txtSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent(getApplicationContext(), SignupActivity.class ));
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.show();
                String email = inputEmail.getText().toString().trim();
                final String password = inputPassword.getText().toString();

                if (TextUtils.isEmpty(email)) {
                    inputEmail.setError("Enter valid email !");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    inputPassword.setError(" Enter password !");
                    return;
                }
                startActivity( new Intent( getApplicationContext() , MainActivity.class));
            }

        });
    }

    private void initializeViews() {
        inputEmail = (EditText) findViewById(R.id.input_email);
        inputPassword = (EditText)findViewById(R.id.input_password);
        btn_login = (Button)findViewById(R.id.btn_login);
        txtforgot = (TextView)findViewById(R.id.link_forgot);
        txtSignup = (TextView)findViewById(R.id.link_signup);
        progressDialog = new ProgressDialog(LoginActivity.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Creating Account...");
    }


}
