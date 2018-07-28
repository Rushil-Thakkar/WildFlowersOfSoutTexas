package com.example.rushil.wildflowersofsouthtexas;

import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.rushil.wildflowersofsouthtexas.R.id.Image1;

/**
 * Created by Rushil on 09-Feb-17.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    ArrayList<Country>arrayList=new ArrayList<>();
    Context ctx;

    public RecyclerAdapter(ArrayList<Country> arrayList, Context ctx)
    {
        this.arrayList=arrayList;
        this.ctx=ctx;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view,ctx,arrayList);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.c_flag.setImageResource(arrayList.get(position).getFalg_id());
        holder.c_name.setText(arrayList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        ImageView c_flag;
        TextView c_name;
        ArrayList<Country>country=new ArrayList<Country>();
        Context ctx;

        public MyViewHolder(View itemView, Context ctx, ArrayList<Country>country)
        {
            super(itemView);
            this.country=country;
            this.ctx=ctx;
            itemView.setOnClickListener(this);
            c_flag=(ImageView)itemView.findViewById(R.id.flag);
            c_name=(TextView)itemView.findViewById(R.id.name);
        }

        @Override
        public void onClick(View v)
        {
            int position = getAdapterPosition();
            Country country=this.country.get(position);
            if(country.getFalg_id()==Image1);
            {
                Intent intent = new Intent(this.ctx, Details.class);
               // intent.putExtra("img_id", country.getFalg_id());
               // intent.putExtra("name", country.getName());
                this.ctx.startActivity(intent);
            }
        }
    }
    public void setFilter(ArrayList<Country>newList)
    {
        arrayList = new ArrayList<>();
        arrayList.addAll(newList);
        notifyDataSetChanged();

    }
}
