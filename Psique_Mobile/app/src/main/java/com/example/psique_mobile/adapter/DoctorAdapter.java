package com.example.psique_mobile.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.psique_mobile.model.Doctor;
import com.example.psique_mobile.R;

import java.util.ArrayList;

public class DoctorAdapter extends ArrayAdapter<Doctor> {
    private final Context context;
    private final ArrayList<Doctor> elementos;

    public DoctorAdapter(Context context, ArrayList<Doctor> elementos) {
        super(context, R.layout.activity_doctor_list_ok, elementos);
        this.context = context;
        this.elementos = elementos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.activity_doctor_list_ok,parent, false);

        TextView nome = rowView.findViewById(R.id.Nome);
        TextView endereco = rowView.findViewById(R.id.Endereco);
        TextView profissao = rowView.findViewById(R.id.Profissao);
        ImageView imagem = rowView.findViewById(R.id.imagem);

        nome.setText(elementos.get(position).getNome());
       // endereco.setText(elementos.get(position).getEndereco());
        profissao.setText(elementos.get(position).getProfissao());
        //imagem.setImageResource(elementos.get(position).getImagem());
        return rowView;
    }

}
