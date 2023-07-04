package com.example.newprojectretro;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MyCustomAdapter extends RecyclerView.Adapter<MyCustomAdapter.MyViewHolder> {

    List<UserModel> dataList;
    Context context;

    public MyCustomAdapter(List<UserModel> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.single_row_main,parent,false);
        MyViewHolder viewHolder= new MyViewHolder(view);
        return viewHolder;

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.title.setText(dataList.get(position).getTitle());
        holder.linear_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Cliqued",Toast.LENGTH_LONG).show();
            }
        });
        Glide.with(context).load(dataList.get(position).getUrl()).into(holder.img);

    }



    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView title;
        ImageView img;
        LinearLayout linear_layout;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            title= itemView.findViewById(R.id.title);
            linear_layout=itemView.findViewById(R.id.llayout);
            img=itemView.findViewById(R.id.imageview);


        }
    }
}
