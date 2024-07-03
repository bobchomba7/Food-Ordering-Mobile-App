package ac.ke.chomba_midsem.Activity;


import android.content.Intent;
import android.os.Bundle;

import ac.ke.chomba_midsem.databinding.ActivityHomePageBinding;


public class HomePage extends BaseActivity {
    ActivityHomePageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityHomePageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setVariable();

    }

    private void setVariable() {
        binding.LoginBtn.setOnClickListener(v -> {
            if(mAuth.getCurrentUser()!=null){
                startActivity(new Intent(HomePage.this,MainActivity.class));
            }else{
                startActivity(new Intent(HomePage.this,LoginPage.class));

            }

        });

        binding.SignUpBtn.setOnClickListener(v -> startActivity(new Intent(HomePage.this,RegisterPage.class)));

    }
}