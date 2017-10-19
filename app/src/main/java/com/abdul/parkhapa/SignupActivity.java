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

import com.google.firebase.auth.FirebaseAuth;

public class SignupActivity extends AppCompatActivity {
    EditText editName , editEmail, editPassword , editPassword2;
    ProgressDialog progressDialog;
    TextView txtHaveAnAccount;
    Button btn_signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        initializeViews();

        txtHaveAnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent(getApplicationContext() ,LoginActivity.class));
            }
        });

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.show();

                String name = editName.getText().toString().trim();
                String email = editEmail.getText().toString().trim();
                String password = editPassword.getText().toString();
                String password2 = editPassword2.getText().toString();

                if (TextUtils.isEmpty(name)) {
                    editName.setError("Enter Name !");
                    return;
                }
                if (TextUtils.isEmpty(email)) {
                    editEmail.setError("Invalid email address ! ");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    editPassword.setError("Enter password ");
                    return;
                }
                if (!password2.equals(password2)) {
                    editPassword2.setError("Password mismatch");
                    return;
                }
                startActivity( new Intent( getApplicationContext() , MainActivity.class));
            }
        });
    }

    private void initializeViews() {
        editName = (EditText)findViewById(R.id.input_name);
        editEmail = (EditText)findViewById(R.id.input_email);
        editPassword = (EditText)findViewById(R.id.input_password);
        editPassword2 = (EditText)findViewById(R.id.input_password2);
        txtHaveAnAccount = (TextView)findViewById(R.id.link_login);
        btn_signup = (Button)findViewById(R.id.btn_signup);

        progressDialog = new ProgressDialog(getApplicationContext(),
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Creating Account...");
    }
}
