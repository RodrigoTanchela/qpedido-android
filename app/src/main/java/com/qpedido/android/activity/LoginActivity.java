package com.qpedido.android.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.qpedido.android.R;
import com.qpedido.android.fragment.LoginFragment;
import com.qpedido.android.fragment.RegisterFragment;

import static java.security.AccessController.getContext;

public class LoginActivity extends AppCompatActivity {

    TextView title;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        title = findViewById(R.id.textViewTitle);
        title.setText(R.string.user_login);
        loadLoginFragment();
    }

    private void loadLoginFragment() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragmentLogin, new LoginFragment());
        fragmentTransaction.commit();
    }

    public void onClickReturn(View view) {
        finish();
    }

    public void onClickSwitchRegister(View view) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragmentLogin, new RegisterFragment());
        fragmentTransaction.commit();
        title.setText(R.string.user_registration);
    }

    public void onClickSwitchLogin(View view) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragmentLogin, new LoginFragment());
        fragmentTransaction.commit();
        title.setText(R.string.user_login);
    }

    public void onClickLogin(View view) {
        //TODO Adicionar fluxo de verificação de credencias.
        Intent intent = new Intent(this, QRCodeActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void onClickRegister(View view) {
        //TODO Adicionar fluxo de criação de usuário.
        Intent intent = new Intent(this, QRCodeActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}