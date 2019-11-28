package com.example.psique_mobile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class    MedicosAdapter extends ArrayAdapter<Medico> {
    private final Context context;
    private final ArrayList<Medico> elementos;

    public MedicosAdapter(Context context, ArrayList<Medico> elementos) {
        super(context, R.layout.listade_medicos_certa, elementos);
        this.context = context;
        this.elementos = elementos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.listade_medicos_certa,parent, false);

        TextView nome = rowView.findViewById(R.id.txtNameDoctor);
        TextView endereco = rowView.findViewById(R.id.txtHour);
        TextView profissao = rowView.findViewById(R.id.txtDate);
        ImageView imagem = rowView.findViewById(R.id.imagemDoctor);

        nome.setText(elementos.get(position).getNome());
       // endereco.setText(elementos.get(position).getEndereco());
        profissao.setText(elementos.get(position).getProfissao());
        //imagem.setImageResource(elementos.get(position).getImagem());
        return rowView;
    }

}
