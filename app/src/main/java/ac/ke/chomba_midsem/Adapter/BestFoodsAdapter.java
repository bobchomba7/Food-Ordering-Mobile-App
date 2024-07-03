package ac.ke.chomba_midsem.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;

import java.util.ArrayList;

import ac.ke.chomba_midsem.Domain.Foods;
import ac.ke.chomba_midsem.R;

public class BestFoodsAdapter extends RecyclerView.Adapter<BestFoodsAdapter.ViewHolder> {
    ArrayList<Foods> items;
    Context context;

    public BestFoodsAdapter(ArrayList<Foods> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public BestFoodsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context= parent.getContext();
        View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_best_deal,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull BestFoodsAdapter.ViewHolder holder, int position) {
        holder.title.setText(items.get(position).getTitle());
        holder.price.setText("KSH " + items.get(position).getPrice());
        holder.timing.setText(items.get(position).getTimeValue() + "min");
        holder.star.setText(""+items.get(position).getStar());

        Glide.with(context).load(items.get(position).getImagePath())
                .transform(new CenterCrop(),new RoundedCorners(30))
                .into(holder.burger);


    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title,price,star,timing;
        ImageView burger;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title);
            price=itemView.findViewById(R.id.price);
            star=itemView.findViewById(R.id.star);
            timing=itemView.findViewById(R.id.timing);
            burger=itemView.findViewById(R.id.burger);
        }
    }
}
