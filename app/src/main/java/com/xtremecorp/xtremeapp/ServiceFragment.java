package com.xtremecorp.xtremeapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ServiceFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ServiceFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ServiceFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ServiceFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ServiceFragment newInstance(String param1, String param2) {
        ServiceFragment fragment = new ServiceFragment();
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

    ImageButton TelmexBtn, InfonavitBtn, NaturaBtn, CfeBtn, SkyBtn,
            IzziBtn, TotalPlayBtn, DishBtn, JafraBtn, AvonBtn,
            PaseBtn, NaturgyBtn;
    private List<ImageButton> buttons;
    private static final int[] Buttons_ID = {
            R.id.telmex,     //0
            R.id.infonavit,  //1
            R.id.natura,     //2
            R.id.cfe,        //3
            R.id.sky,        //4
            R.id.izzi,       //5
            R.id.totalplay,  //6
            R.id.dish,       //7
            R.id.jafra,      //8
            R.id.avon,       //9
            R.id.pase,       //10
            R.id.naturgy     //11
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        buttons = new ArrayList<ImageButton>();
        View root = inflater.inflate(R.layout.fragment_service, container, false);

        for(int id : Buttons_ID){
            ImageButton imageButton = root.findViewById(id);
            imageButton.setOnClickListener(this);
            buttons.add(imageButton);
        }

        TelmexBtn = buttons.get(0);
        InfonavitBtn = buttons.get(1);
        NaturaBtn = buttons.get(2);
        CfeBtn = buttons.get(3);
        SkyBtn = buttons.get(4);
        IzziBtn = buttons.get(5);
        TotalPlayBtn = buttons.get(6);
        DishBtn = buttons.get(7);
        JafraBtn = buttons.get(8);
        AvonBtn = buttons.get(9);
        PaseBtn = buttons.get(10);
        NaturgyBtn = buttons.get(11);
        return root;
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.telmex:
                Toast.makeText(getContext(), "Telmex", Toast.LENGTH_SHORT).show();
                break;
            case R.id.infonavit:
                Toast.makeText(getContext(), "Infonavit", Toast.LENGTH_SHORT).show();
                break;
            case R.id.natura:
                Toast.makeText(getContext(), "Natura", Toast.LENGTH_SHORT).show();
                break;
            case R.id.cfe:
                Toast.makeText(getContext(), "Cfe", Toast.LENGTH_SHORT).show();
                break;
            case R.id.sky:
                Toast.makeText(getContext(), "SKY", Toast.LENGTH_SHORT).show();
                break;
            case R.id.izzi:
                Toast.makeText(getContext(), "IZZI", Toast.LENGTH_SHORT).show();
                break;
            case R.id.totalplay:
                Toast.makeText(getContext(), "Total Play", Toast.LENGTH_SHORT).show();
                break;
            case R.id.dish:
                Toast.makeText(getContext(), "Dish", Toast.LENGTH_SHORT).show();
                break;
            case R.id.jafra:
                Toast.makeText(getContext(), "Jafra", Toast.LENGTH_SHORT).show();
                break;
            case R.id.avon:
                Toast.makeText(getContext(), "Avon", Toast.LENGTH_SHORT).show();
                break;
            case R.id.pase:
                Toast.makeText(getContext(), "Telepase", Toast.LENGTH_SHORT).show();
                break;
            case R.id.naturgy:
                Toast.makeText(getContext(), "Naturgy", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}