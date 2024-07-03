package ac.ke.chomba_midsem.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import ac.ke.chomba_midsem.databinding.ActivityRegisterPageBinding;

public class RegisterPage extends BaseActivity {
    ActivityRegisterPageBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setVariable();

    }

    private void setVariable() {
        binding.signUp.setOnClickListener(v -> {
            String email = binding.email.getText().toString();
            String password = binding.password.getText().toString();

            if (password.length() < 6) {
                Toast.makeText(RegisterPage.this, "Password must be at least 6 characters", Toast.LENGTH_SHORT).show();
                return;
            }
            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(RegisterPage.this, task -> {
                if (task.isComplete()) {
                    Log.i(TAG, "onComplete:");
                    startActivity(new Intent(RegisterPage.this,LoginPage.class));
                    Toast.makeText(RegisterPage.this, "Authentication successful.", Toast.LENGTH_SHORT).show();

                } else {
                    Log.i(TAG, "failure" + task.getException());
                    Toast.makeText(RegisterPage.this, "Authentication failed.",
                            Toast.LENGTH_SHORT).show();
                }
            });

        });
    }
}