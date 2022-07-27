package com.xtremecorp.xtremeapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TaeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TaeFragment extends Fragment {

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

    ImageButton TelcelBtn, MovistarBtn, VirginBtn, AttBtn, BaitBtn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_tae, container, false);
        TelcelBtn = root.findViewById(R.id.btn_telcel);
        MovistarBtn = root.findViewById(R.id.movistar);
        VirginBtn = root.findViewById(R.id.virgin);
        AttBtn = root.findViewById(R.id.att);
        BaitBtn = root.findViewById(R.id.bait);

        productSelection(TelcelBtn);
        productSelection(MovistarBtn);



        return root;
    }

    public void productSelection(ImageButton imageButton){
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "boton " , Toast.LENGTH_SHORT).show();
            }
        });
    }
}