package com.app.nb.menufy.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import com.app.nb.menufy.R;


public class AlertFragment extends Fragment implements View.OnClickListener, DialogInterface.OnClickListener {

    private FloatingActionButton fab;
    private TextView tvTitle;

    AlertDialog.Builder builder;
    private Switch switchBtn;


    public AlertFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_alert, container, false);

        fab = view.findViewById(R.id.fab);
        fab.setOnClickListener(this);

        tvTitle = view.findViewById(R.id.tvTitle);

        return view;
    }


    @Override
    public void onClick(View view) {

        builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Email");
        builder.setMessage("Hola mundo");

        //Obtenerl l Layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_fragment_dialog, null);

        switchBtn = dialogView.findViewById(R.id.switchDialog);

        builder.setView(dialogView);

        //Establcer los botones
        builder.setPositiveButton("OK", this);
        builder.setNegativeButton("Cancelar", this);
        builder.show();
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int which) {
        if (which == DialogInterface.BUTTON_POSITIVE) {
            if (switchBtn.isChecked()) {
                tvTitle.setText("Alertas Actividas");
            } else {
                tvTitle.setText("Alertas Desactivadas");
            }
        } else if (which == DialogInterface.BUTTON_NEGATIVE) {
            dialogInterface.cancel();
        }
    }
}
