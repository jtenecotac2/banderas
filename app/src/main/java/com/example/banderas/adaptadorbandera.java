package com.example.banderas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class adaptadorbandera extends ArrayAdapter<banderaecua> {
    public adaptadorbandera(Context context, ArrayList<banderaecua> datos) {
        super(context, R.layout.banderas, datos);
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.banderas, null);
        TextView lblNombre = (TextView) item.findViewById(R.id.lblNombre);
        lblNombre.setText(getItem(position).getNombre());
        ImageView imageView = (ImageView)item.findViewById(R.id.imgLogo);
        Glide.with(this.getContext())
                .load(getItem(position).getUrlLogo())
                .into(imageView);
        return (item);
    }
}
