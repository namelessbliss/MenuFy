package com.app.nb.menufy.fragments;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.app.nb.menufy.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class EmailFragment extends Fragment implements View.OnClickListener, DialogInterface.OnClickListener {

    private FloatingActionButton fab;
    private TextView tvTitle;

    AlertDialog.Builder builder;
    private EditText etMail;

    public EmailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_email, container, false);

        fab = view.findViewById(R.id.fab);
        fab.setOnClickListener(this);

        tvTitle = view.findViewById(R.id.tvTitle);

        return view;
    }

    @Override
    public void onClick(View view) {

        builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Email");
        builder.setMessage("Ingresa tu direccion de email para mostrarlo");

        //Establecer input
        etMail = new EditText(getContext());
        etMail.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
        builder.setView(etMail);

        //Establecer botones
        builder.setPositiveButton("Ok", this);
        builder.setNegativeButton("Cancelar", this);
        builder.show();

    }

    @Override
    public void onClick(DialogInterface dialogInterface, int wich) {
        if (wich == DialogInterface.BUTTON_POSITIVE) {
            String email = etMail.getText().toString();
            if (!email.isEmpty()) {
                tvTitle.setText(email);
            }
        } else if (wich == DialogInterface.BUTTON_NEGATIVE) {
            dialogInterface.cancel();
        }
    }
}
