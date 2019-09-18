package com.example.psique_mobile;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.google.firebase.database.core.view.View;

import java.util.List;

public class PessoaListAdapter extends ArrayAdapter<Pessoa> {

    private Activity context;
    private List<Pessoa> pessoaList;

    public PessoaListAdapter(Activity context, List<Pessoa> pessoaList) {

        super(context, R.layout.pessoa_item, pessoaList);
        this.context = context;
        this.pessoaList = pessoaList;
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
        // então usamos esse valor (position) para acessar o objeto "Pessoa" correto
        // dentro da lista pessoaList
        Pessoa pessoa = pessoaList.get(position);

        // finalmente, colocamos os valores do objeto pessoa recuperado
        // nas views que formam nosso item da lista
        textViewNome.setText(pessoa.getNome());
        textViewEmail.setText(pessoa.getEmail());
        textViewCpf.setText(pessoa.getCpf());
        textViewTelefone.setText(pessoa.getTelefone());

        // a view está pronta! É só devolver para quem pediu
        return listViewItem;
    }
}