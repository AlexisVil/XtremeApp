package com.xtremecorp.xtremeapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TaeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TaeFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TaeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TaeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TaeFragment newInstance(String param1, String param2) {
        TaeFragment fragment = new TaeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    ImageButton TelcelBtn, MovistarBtn, VirginBtn, AttBtn, BaitBtn,
            DiriBtn, JrMovilBtn, MayaMovilBtn, MiMovilBtn, OuiBtn,
            PilloFonBtn, SpaceBtn, ValorBTn, DiveracyBtn;

    private List<ImageButton> buttons;
    private static final int[] Buttons_Id = {
            R.id.btn_telcel,//0
            R.id.movistar, //1
            R.id.att,      //2
            R.id.virgin,   //3
            R.id.bait,     //4
            R.id.diri,     //5
            R.id.jrmovil,  //6
            R.id.maya,     //7
            R.id.mimovil,  //8
            R.id.oui,      //9
            R.id.pillofon, //10
            R.id.space,    //11
            R.id.valor,    //12
            R.id.diveracy  //13
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Crear un areray list y llenar dinamicamente
        buttons = new ArrayList<ImageButton>();

        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_tae, container, false);

        for (int id : Buttons_Id) {
            ImageButton imageButton = root.findViewById(id);
            imageButton.setOnClickListener(this);
            buttons.add(imageButton);
        }

        TelcelBtn = buttons.get(0);
        MovistarBtn = buttons.get(1);
        AttBtn = buttons.get(2);
        VirginBtn = buttons.get(3);
        BaitBtn = buttons.get(4);
        DiriBtn = buttons.get(5);
        JrMovilBtn = buttons.get(6);
        MayaMovilBtn = buttons.get(7);
        MiMovilBtn = buttons.get(8);
        OuiBtn = buttons.get(9);
        PilloFonBtn = buttons.get(10);
        SpaceBtn = buttons.get(11);
        ValorBTn = buttons.get(12);
        DiveracyBtn = buttons.get(13);

        return root;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_telcel:
                Toast.makeText(getContext(), "Telcel", Toast.LENGTH_SHORT).show();
                break;
            case R.id.movistar:
                Toast.makeText(getContext(), "Movistar", Toast.LENGTH_SHORT).show();
                break;
            case R.id.att:
                Toast.makeText(getContext(), "Att", Toast.LENGTH_SHORT).show();
                break;
            case R.id.virgin:
                Toast.makeText(getContext(), "virgin", Toast.LENGTH_SHORT).show();
                break;
            case R.id.bait:
                Toast.makeText(getContext(), "Bait", Toast.LENGTH_SHORT).show();
                break;
            case R.id.diri:
                Toast.makeText(getContext(), "Diri", Toast.LENGTH_SHORT).show();
                break;
            case R.id.jrmovil:
                Toast.makeText(getContext(), "jrMovil", Toast.LENGTH_SHORT).show();
                break;
            case R.id.maya:
                Toast.makeText(getContext(), "Maya Movil", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mimovil:
                Toast.makeText(getContext(), "Mi movil", Toast.LENGTH_SHORT).show();
                break;
            case R.id.oui:
                Toast.makeText(getContext(), "Oui Movil", Toast.LENGTH_SHORT).show();
                break;
            case R.id.pillofon:
                Toast.makeText(getContext(), "Pillofon", Toast.LENGTH_SHORT).show();
                break;
            case R.id.space:
                Toast.makeText(getContext(), "Space Movil", Toast.LENGTH_SHORT).show();
                break;
            case R.id.diveracy:
                Toast.makeText(getContext(), "Diveracy", Toast.LENGTH_SHORT).show();
                break;
            case R.id.valor:
                Toast.makeText(getContext(), "Valor Movil", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}