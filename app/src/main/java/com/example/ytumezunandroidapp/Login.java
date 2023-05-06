package com.example.ytumezunandroidapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.Window;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

    EditText email, password;
    Button login, register;
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);

        email = (EditText) findViewById(R.id.login_et_email);
        password = (EditText) findViewById(R.id.login_et_password);

        login = (Button) findViewById(R.id.login_bt_login);
        register = (Button) findViewById(R.id.login_bt_register);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(email.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {
                    Toast.makeText(Login.this, "Giriş başarılı.", Toast.LENGTH_SHORT).show();
                    //Intent intent = new Intent(getApplicationContext(), Profile.class);
                    //startActivity(intent);
                }
                else if(!email.getText().toString().equals("admin")){
                    Toast.makeText(Login.this, "Kullanıcı adı hatalı!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(Login.this, "Şifre hatalı!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Register.class);
                startActivity(intent);
            }
        });

        mAuth = FirebaseAuth.getInstance();
    }

    public void login_user(View view){
        if(!TextUtils.isEmpty(email.getText().toString()) &&  !TextUtils.isEmpty(password.getText().toString())){
            mAuth.signInWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                    .addOnSuccessListener(this, new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            mUser = mAuth.getCurrentUser();


                        }
                    }).addOnFailureListener(this, new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(Login.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
        }
        else{
            Toast.makeText(this, "Email ve Şifre Alanlar Boş Bırakılamaz!", Toast.LENGTH_SHORT).show();
        }
    }
}