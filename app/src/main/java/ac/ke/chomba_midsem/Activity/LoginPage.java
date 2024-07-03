package ac.ke.chomba_midsem.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import ac.ke.chomba_midsem.databinding.ActivityLoginPageBinding;

public class LoginPage extends BaseActivity {
    ActivityLoginPageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        setVariable();
    }
    private void setVariable () {
        binding.logIn.setOnClickListener(v -> {
            String email = binding.email.getText().toString();
            String password = binding.password.getText().toString();
            if (!email.isEmpty() && !password.isEmpty()) {
                mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(LoginPage.this, task -> {
                    if (task.isSuccessful()) {
                        startActivity(new Intent(LoginPage.this, MainActivity.class));
                        Toast.makeText(LoginPage.this, "Authentication has succeeded", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(LoginPage.this, "Authentication has failed", Toast.LENGTH_SHORT).show();
                    }
                });
            } else {
                Toast.makeText(LoginPage.this, "Please enter your email and password", Toast.LENGTH_SHORT).show();
            }
        });
    }
}