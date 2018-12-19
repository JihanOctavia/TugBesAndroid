package com.example.verenca.tubesandroid.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.verenca.tubesandroid.Model.DetailDietPlan;
import com.example.verenca.tubesandroid.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by WINDOWS 10 on 09/12/2018.
 */

//adapter untuk mengedit / mengganti tampilan dari isi recycler view
public class DetailDietPlanAdapter extends RecyclerView.Adapter<DetailDietPlanAdapter.DetailDietPlanHolder> {
    List<DetailDietPlan> listDetailDietPlan;
    Context context;

    //digunakan untuk konstruktor
    public DetailDietPlanAdapter(List<DetailDietPlan> listDetailDietPlan,Context context) {
        this.listDetailDietPlan = listDetailDietPlan;
        this.context = context;
    }

    //mengambil layout dari listDetailDietPlan
    @NonNull
    @Override
    public DetailDietPlanHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.list_detaildietplan,viewGroup,false);
        DetailDietPlanHolder viewHolder = new DetailDietPlanHolder(view);
        return viewHolder;
    }

    //mengganti tulisan dari recycler view
    @Override
    public void onBindViewHolder(@NonNull DetailDietPlanHolder detailDietPlanHolder, int i) {
        detailDietPlanHolder.ddp_judul.setText(i+1+" "+listDetailDietPlan.get(i).getJudul());
//        detailDietPlanHolder.ddp_imgGambar.setImageResource(listDetailDietPlan.get(i).getGambar_url());

        //menambahkan gambar picasso
        Picasso.with(context).load(listDetailDietPlan.get(i).getGambar_url())
                .placeholder(R.drawable.load) //ketika loading maka tampil ic_launcher
                .error(R.drawable.eror) //ketika gambar gagal di load maka tampil ic_launcher
                .into(detailDietPlanHolder.ddp_imgGambar); //tujuan gambar
    }

    //mengambil jumlah item listDetailPlan
    @Override
    public int getItemCount() {
        return listDetailDietPlan.size();
    }

    //membuat class holder
    public class DetailDietPlanHolder extends RecyclerView.ViewHolder {
        TextView ddp_judul;
        ImageView ddp_imgGambar;
        public DetailDietPlanHolder(@NonNull View itemView) {
            super(itemView);

            //mengambil objek dari layout sesuai id
            ddp_imgGambar = itemView.findViewById(R.id.ddp_imgGambar);
            ddp_judul = itemView.findViewById(R.id.ddp_judul);
        }
    }
}
