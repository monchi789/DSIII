package com.example.tarea_cristianmonzonguzman.Sound;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.tarea_cristianmonzonguzman.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SoundFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SoundFragment extends Fragment {

    // Define the Variables
    ImageButton btnRaro;
    ImageButton btnBones;
    ImageButton btnImagination;
    ImageButton btnSweater;
    ImageButton btnPum;
    ImageButton btnWalk;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SoundFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SoundFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SoundFragment newInstance(String param1, String param2) {
        SoundFragment fragment = new SoundFragment();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_sound, container, false);

        // Find the Views
        btnRaro = view.findViewById(R.id.btnRaro);
        btnBones = view.findViewById(R.id.btnBones);
        btnImagination = view.findViewById(R.id.btnImagination);
        btnSweater = view.findViewById(R.id.btnSweater);
        btnPum = view.findViewById(R.id.btnPum);
        btnWalk = view.findViewById(R.id.btnWalk);

        // Set the OnClickListener
        // Raro
        btnRaro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer mediaPlayer = MediaPlayer.create(getContext(), R.raw.hoy_estoy_raro);
                mediaPlayer.start();
            }
        });

        // Bones
        btnBones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer mediaPlayer = MediaPlayer.create(getContext(), R.raw.bones);
                mediaPlayer.start();
            }
        });

        // Imagination
        btnImagination.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer mediaPlayer = MediaPlayer.create(getContext(), R.raw.imagination);
                mediaPlayer.start();
            }
        });

        // Sweater
        btnSweater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer mediaPlayer = MediaPlayer.create(getContext(), R.raw.sweater_weather);
                mediaPlayer.start();
            }
        });

        // Pum
        btnPum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer mediaPlayer = MediaPlayer.create(getContext(), R.raw.pum_pum_pum);
                mediaPlayer.start();
            }
        });

        // Walk
        btnWalk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer mediaPlayer = MediaPlayer.create(getContext(), R.raw.walk);
                mediaPlayer.start();
            }
        });

        // Inflate the layout for this fragment
        return view;
    }
}