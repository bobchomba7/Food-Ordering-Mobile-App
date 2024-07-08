package ac.ke.chomba_midsem.Activity;

import android.os.Bundle;

import com.bumptech.glide.Glide;

import ac.ke.chomba_midsem.Domain.Foods;
import ac.ke.chomba_midsem.Helper.ManagmentCart;
import ac.ke.chomba_midsem.databinding.ActivityDetailBinding;

public class DetailActivity extends BaseActivity {
    ActivityDetailBinding binding;
    private Foods object;
    private int num = 1;

    private ManagmentCart managementCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getIntentExtra();
        setVariable();

    }

    private void setVariable() {
        managementCart=new ManagmentCart(this);
        binding.backBtn.setOnClickListener(v -> finish());

        Glide.with(DetailActivity.this)
                .load(object.getImagePath())
                .into(binding.pic);

        binding.priceTxt.setText("$" + object.getPrice());
        binding.titleTxt.setText(object.getTitle());
        binding.descriptionTxt.setText(object.getDescription());
        binding.rateTxt.setText(object.getStar() + " Rating");
        binding.ratingBar2.setRating((float) object.getStar());
        binding.totalTxt.setText((num * object.getPrice() + "$"));

        binding.plusBtn.setOnClickListener(v -> {
            num=num+1;
            binding.numTxt.setText(num+" ");
            binding.totalTxt.setText((num * object.getPrice() + "$"));
        });
        binding.minusBtn.setOnClickListener(v -> {
            if(num>1){
                num=num-1;
                binding.numTxt.setText(num+" ");
                binding.totalTxt.setText((num * object.getPrice() + "$"));
            }
        });


        binding.addBtn.setOnClickListener(v -> {
            object.setNumberInCart(num);
            managementCart.insertFood(object);
        });
    }

    private void getIntentExtra() {
        object=(Foods) getIntent().getSerializableExtra("object");


    }
}