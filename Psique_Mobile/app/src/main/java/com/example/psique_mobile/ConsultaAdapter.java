package com.example.psique_mobile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ConsultaAdapter extends ArrayAdapter<Consulta> {

    private final Context context;
    private final ArrayList<Consulta> elementos;

    public ConsultaAdapter(Context context, ArrayList<Consulta> elementos) {
        super(context, R.layout.activity_consultas, elementos);
        this.context = context;
        this.elementos = elementos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.activity_consultas, parent, false);

        TextView nomeMedico = (TextView) rowView.findViewById(R.id.nameDoctor);
        TextView relatorioMedico = (TextView) rowView.findViewById(R.id.anaAvalie);
        //TextView registroMedico = (TextView) rowView.findViewById(R.id.idProfissao);
//        TextView dataConsulta = (TextView) rowView.findViewById(R.id.idDate);
//        TextView horaConsulta = (TextView) rowView.findViewById(R.id.idHour);


        //ImageView imagem = (ImageView) rowView.findViewById(R.id.imagem);

        nomeMedico.setText(elementos.get(position).getDoctorName());
        relatorioMedico.setText(elementos.get(position).getAnamnese());
        //registroMedico.setText(elementos.get(position).getDoctorID().getSpecialty());
//        dataConsulta.setText(elementos.get(position).getData());
//        horaConsulta.setText(elementos.get(position).getHour());
        //imagem.setImageResource(elementos.get(position).getImagem());

        return rowView;

    }


}
