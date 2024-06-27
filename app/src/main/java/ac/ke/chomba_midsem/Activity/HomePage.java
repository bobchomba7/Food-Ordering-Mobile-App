package ac.ke.chomba_midsem.Activity;

import android.os.Bundle;
import android.view.View;

import ac.ke.chomba_midsem.R;
import ac.ke.chomba_midsem.databinding.ActivityHomePageBinding;

public class HomePage extends BaseActivity {
    ActivityHomePageBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomePageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setVariable();
        getWindow().setNavigationBarColor(getResources().getColor(R.color.white));
    }

    private void setVariable() {
        binding.LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        binding.SignUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }

        });
    }

}