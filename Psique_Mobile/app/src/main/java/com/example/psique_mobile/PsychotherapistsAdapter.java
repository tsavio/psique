package com.example.psique_mobile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PsychotherapistsAdapter extends ArrayAdapter<Psychotherapist> {
    private final Context context;
    private final ArrayList<Psychotherapist> elementos;

    public PsychotherapistsAdapter(Context context, ArrayList<Psychotherapist> elementos) {
        super(context, R.layout.activity_psychotherapist_list_ok, elementos);
        this.context = context;
        this.elementos = elementos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.activity_psychotherapist_list_ok,parent, false);

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
