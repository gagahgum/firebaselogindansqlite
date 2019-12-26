package com.gagum.firebaselogindansqlite.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.annotation.NonNull;
import com.gagum.firebaselogindansqlite.R;
import com.gagum.firebaselogindansqlite.model.Kontak;

import java.util.List;

public class KontakAdapter extends RecyclerView.Adapter<KontakAdapter.MyViewHolder> {
    Context context;
    List<Kontak> kontaks;


    public KontakAdapter(Context context, List<Kontak> kontaks) {
        this.context = context;
        this.kontaks = kontaks;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_kontak, parent,false);
        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.tvNo.setText(Integer.toString(kontaks.get(position).getNo_kontak()));
        holder.tvNama.setText(kontaks.get(position).getNama());
        holder.tvNomor.setText(kontaks.get(position).getNomor());
//        final int id = kategoris.get(position).getNo_kategori();


//        holder.cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(context, PertanyaanActivity.class);
//                intent.putExtra("keyId",kategoris.get(position).getNo_kategori());
//                intent.putExtra("keyKategori", kategoris.get(position).getNama_kategori());
//                context.startActivity(intent);
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return kontaks.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        TextView tvNama;
        TextView tvNomor;
        TextView tvNo;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardview_kontak);
            tvNo = itemView.findViewById(R.id.tvNo);
            tvNomor = itemView.findViewById(R.id.tvNomor);
            tvNama = itemView.findViewById(R.id.tvNama);

        }
    }
}
