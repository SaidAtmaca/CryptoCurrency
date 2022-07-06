package com.said.cryptocurrency.adapter;

import android.graphics.Color;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.said.cryptocurrency.R;
import com.said.cryptocurrency.model.CryptoModel;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RowHolder> {

    private ArrayList<CryptoModel> cryptoList;

    private String[] colors={"#ffc112","#009ab9" ,"#9900aa","#7289da","#c51f5d","#100604","#ff7321","#004962"};

    public RecyclerViewAdapter(ArrayList<CryptoModel> cryptoList) {
        this.cryptoList = cryptoList;
    }

    @NonNull
    @Override
    public RowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view= layoutInflater.inflate(R.layout.row_layout,parent,false);

        return new RowHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RowHolder holder, int position) {

        holder.bind(cryptoList.get(position),colors,position);

    }

    @Override
    public int getItemCount() {
        return cryptoList.size();
    }

    public class RowHolder extends RecyclerView.ViewHolder {

        TextView textName;
        TextView textPrice;
        public RowHolder(@NonNull View itemView) {
            super(itemView);



        }


        public void bind(CryptoModel cryptoModel, String[] colors, Integer position){

            itemView.setBackgroundColor(Color.parseColor(colors[position %8 ]));
            textName=itemView.findViewById(R.id.text_name);
            textPrice=itemView.findViewById(R.id.text_price);
            textName.setText(cryptoModel.currency);
            textPrice.setText(cryptoModel.price+" $");
        }
    }
}
