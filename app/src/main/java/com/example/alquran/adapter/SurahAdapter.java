package com.example.alquran.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alquran.MainActivity;
import com.example.alquran.R;
import com.example.alquran.SurahDetailActivity;
import com.example.alquran.model.Surah;
import java.util.List;

public class SurahAdapter extends RecyclerView.Adapter<SurahAdapter.ViewHolder> {
    private List<Surah> surahList;
    private Context context;

    public SurahAdapter(Context context, List<Surah> surahList) {
        this.context = context;
        this.surahList = surahList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_surah, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Surah surah = surahList.get(position);
        holder.tvSurahNumber.setText(String.valueOf(surah.getNumber()));
        holder.tvSurahName.setText(surah.getEnglishName());
        holder.tvSurahNameArabic.setText(surah.getName());
        holder.tvSurahVerses.setText("Ayat: " + surah.getNumberOfAyahs());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, SurahDetailActivity.class);
            intent.putExtra("SURAH_NUMBER", surah.getNumber());
            context.startActivity(intent);
            // Tambahkan animasi transisi
            ((MainActivity) context).overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        });
    }

    @Override
    public int getItemCount() {
        return surahList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvSurahNumber, tvSurahName, tvSurahNameArabic, tvSurahVerses;

        public ViewHolder(View itemView) {
            super(itemView);
            tvSurahNumber = itemView.findViewById(R.id.tv_surah_number);
            tvSurahName = itemView.findViewById(R.id.tv_surah_name);
            tvSurahNameArabic = itemView.findViewById(R.id.tv_surah_name_arabic);
            tvSurahVerses = itemView.findViewById(R.id.tv_surah_verses);
        }
    }
}