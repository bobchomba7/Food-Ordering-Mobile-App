package ac.ke.chomba_midsem.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import ac.ke.chomba_midsem.Activity.ListFoodsActivity;
import ac.ke.chomba_midsem.Domain.Categories;
import ac.ke.chomba_midsem.R;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.viewholder> {
    ArrayList<Categories> items;
    Context context;

    public CategoryAdapter(ArrayList<Categories> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public CategoryAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context= parent.getContext();
        View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_category,parent,false);
        return new viewholder (inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.viewholder holder, int position) {


        holder.title.setText(items.get(position).getName());
        switch(position) {
            case 0:{
                holder.burger.setBackgroundResource(R.drawable.orange);
                break;
            }
            case 1:{
                holder.burger.setBackgroundResource(R.drawable.orange);
                break;
            }
            case 2:{
                holder.burger.setBackgroundResource(R.drawable.orange);
                break;
            }
            case 3:{
                holder.burger.setBackgroundResource(R.drawable.orange);
                break;
            }
            case 4:{
                holder.burger.setBackgroundResource(R.drawable.orange);
                break;
            }
            case 5:{
                holder.burger.setBackgroundResource(R.drawable.orange);
                break;
            }
            case 6:{
                holder.burger.setBackgroundResource(R.drawable.orange);
                break;
            }
            case 7:{
            holder.burger.setBackgroundResource(R.drawable.orange);
            break;
            }
        }
        int drawableResourceId = context.getResources().getIdentifier(items.get(position).getImagePath(),
                "drawable",holder.itemView.getContext().getPackageName());

        Glide.with(context).load(drawableResourceId)
                .load(drawableResourceId)

                .into(holder.burger);

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, ListFoodsActivity.class);
            intent.putExtra("CategoryId",items.get(position).getId());
            intent.putExtra("CategoryName",items.get(position).getName());
            context.startActivity(intent);
        });


    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class viewholder extends RecyclerView.ViewHolder{
        TextView title;
        ImageView burger;
        public viewholder (@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.catNametxt);
            burger=itemView.findViewById(R.id.imgCat);
        }
    }
}
