package com.example.gothrakhando;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class adapter extends BaseAdapter {

    public Context context;
    List<model> modelList;
    ArrayList<model> arrayList;
    LayoutInflater inflater;
    ArrayList<String> gothram_full;


    public adapter(Context context, List<model> modelList, ArrayList<String> gothram_full) {
        this.context = context;
        this.modelList = modelList;
        inflater = LayoutInflater.from(context);
        this.arrayList = new ArrayList<>();
        this.arrayList.addAll(modelList);
        this.gothram_full = gothram_full;

    }

    public static class viewHolder{
        TextView textView;
        ImageView imageView;
    }

    @Override
    public int getCount() {
        return modelList.size();
    }

    @Override
    public Object getItem(int position) {
        return modelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }



    @SuppressLint("InflateParams")
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        viewHolder holder;
        if(convertView == null){
            holder = new viewHolder();
            convertView = inflater.inflate(R.layout.card,null);

            holder.textView = convertView.findViewById(R.id.textview);
            holder.imageView = convertView.findViewById(R.id.imageview);

            convertView.setTag(holder);
        }
        else{
            holder = (viewHolder)convertView.getTag();
        }

        holder.textView.setText(modelList.get(position).getTextview());
        holder.imageView.setImageResource(modelList.get(position).getImage());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,pdf.class);
                Log.d("name", "onClick: " + modelList.get(position).getTextview());
                Log.d("index", "onClick: " + gothram_full.indexOf(modelList.get(position).getTextview()));
                intent.putExtra("name",gothram_full.indexOf(modelList.get(position).getTextview()));
                context.startActivity(intent);
            }
        });

        return convertView;
    }

    public void filter(String searchtxt){
        searchtxt.toLowerCase().trim();
        modelList.clear();
        if(searchtxt == null || searchtxt.length() == 0){
            modelList.addAll(arrayList);
        }
        else{
            for (model model:arrayList){
                if(model.getTextview().toLowerCase().contains(searchtxt)){
                    modelList.add(model);
                }
            }
        }
        notifyDataSetChanged();
    }



}
