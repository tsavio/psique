package com.example.psique_mobile.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.psique_mobile.model.Person;
import com.example.psique_mobile.R;
import com.google.firebase.database.core.view.View;

import java.util.List;

public class PersonListAdapter extends ArrayAdapter<Person> {

    private Activity context;
    private List<Person> personList;

    public PersonListAdapter(Activity context, List<Person> personList) {

        super(context, R.layout.pessoa_item, personList);
        this.context = context;
        this.personList = personList;
    }


    public android.view.View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();

        android.view.View listViewItem = inflater.inflate(R.layout.pessoa_item, null, true);

        // pegando referências para as views que definimos dentro do item da lista,
        // isto é, os 2 textviews
        TextView textViewNome = listViewItem.findViewById(R.id.textViewNome);
        TextView textViewEmail = listViewItem.findViewById(R.id.textViewEmail);
        TextView textViewCpf = listViewItem.findViewById(R.id.textViewCpf);
        TextView textViewTelefone = listViewItem.findViewById(R.id.textViewTelefone);

        // a posição do medico na lista (armazenamento) é a mesma na lista (listview)
        // então usamos esse valor (position) para acessar o objeto "Person" correto
        // dentro da lista personList
        Person person = personList.get(position);

        // finalmente, colocamos os valores do objeto person recuperado
        // nas views que formam nosso item da lista
        textViewNome.setText(person.getNome());
        textViewEmail.setText(person.getEmail());
        textViewCpf.setText(person.getCpf());
        textViewTelefone.setText(person.getTelefone());

        // a view está pronta! É só devolver para quem pediu
        return listViewItem;
    }
}