package com.example.gothrakhando;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class hadapter extends BaseAdapter {

    public Context context;
    List<hmodel> hmodelList;
    LayoutInflater hinflater;
    ArrayList<hmodel> hmodelArrayList;
    ArrayList<String> gothram_full;

    public hadapter(Context context, List<hmodel> hmodelList, ArrayList<String> gothram_full) {
        this.context = context;
        this.hmodelList = hmodelList;
        this.hmodelArrayList = new ArrayList<>();
        this.hmodelArrayList.addAll(hmodelList);
        hinflater = LayoutInflater.from(context);
        this.gothram_full = gothram_full;
    }

    public static class hviewholder{
        ImageView himage;
        TextView hname,hgothram;
    }

    @Override
    public int getCount() {
        return hmodelList.size();
    }

    @Override
    public Object getItem(int position) {
        return hmodelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("InflateParams")
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        hviewholder holder;
        if(convertView==null){
            holder = new hviewholder();
            convertView = hinflater.inflate(R.layout.hcard,null);
            holder.hname = convertView.findViewById(R.id.hname);
            holder.hgothram = convertView.findViewById(R.id.hgothram);
            holder.himage = convertView.findViewById(R.id.himage);
            convertView.setTag(holder);
        }
        else{
            holder = (hviewholder) convertView.getTag();
        }
        holder.hname.setText(hmodelList.get(position).getHname());
        holder.hgothram.setText(hmodelList.get(position).getHgothram());
        holder.himage.setImageResource(hmodelList.get(position).getHimage());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,pdf.class);
                intent.putExtra("name", gothram_full.indexOf(hmodelList.get(position).getHgothram()));
                context.startActivity(intent);
            }
        });

        return convertView;
    }

    public void filter(String searchtxt){
        searchtxt.toLowerCase().trim();
        hmodelList.clear();
        if(searchtxt==null || searchtxt.length()==0){
            hmodelList.addAll(hmodelArrayList);
        }else {
            for(hmodel hmodel :hmodelArrayList){
                if(hmodel.getHname().toLowerCase().trim().contains(searchtxt)){
                    hmodelList.add(hmodel);
                }
            }
        }
        notifyDataSetChanged();
    }

}
