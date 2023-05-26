package com.android.letsgo.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.letsgo.R;
import com.android.letsgo.db.Driver;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DriverAdapter extends RecyclerView.Adapter<DriverAdapter.LabelHolder> {

    private Context context;
    private List<Driver> data;

    public DriverAdapter(Context context, List<Driver> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public LabelHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.driver_item, parent, false);
        return new LabelHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LabelHolder holder, int position) {
        holder.name.setText(data.get(position).getName() +" " +data.get(position).getSurname().substring(0,1)+". ");
        holder.phone.setText(data.get(position).getPhone());
        holder.cityFrom.setText("Откуда: "+data.get(position).getCityFrom());
        holder.cityTo.setText("Куда: "+ data.get(position).getCityTo());
        holder.price.setText("Цена: " + data.get(position).getPrice());
        holder.date.setText(": " + data.get(position).getDate());
        holder.car.setText(": " + data.get(position).getCar());
        holder.countPassenger.setText(": " + data.get(position).getCountPassenger());
        Picasso.get().load(data.get(position).getImgUrl()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class LabelHolder extends RecyclerView.ViewHolder{

        ImageView img;
        TextView  price,  name, phone, cityFrom, cityTo, car, date, countPassenger;

        public LabelHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name_user);
            phone = itemView.findViewById(R.id.num_user);
            img = itemView.findViewById(R.id.img);
            cityFrom = itemView.findViewById(R.id.from);
            cityTo = itemView.findViewById(R.id.to);
            price = itemView.findViewById(R.id.price);
            date = itemView.findViewById(R.id.date);
            car = itemView.findViewById(R.id.car);
            countPassenger = itemView.findViewById(R.id.countPassenger);
        }
    }
}
