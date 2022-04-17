package com.example.tarea_cristianmonzonguzman.Apps;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.tarea_cristianmonzonguzman.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AppsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AppsFragment extends Fragment {

    // Define the variables
    private ImageButton btnFacebook;
    private ImageButton btnInstagram;
    private ImageButton btnTwitter;
    private ImageButton btnYouTube;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AppsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MapsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AppsFragment newInstance(String param1, String param2) {
        AppsFragment fragment = new AppsFragment();
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

    private void OpenApp(String packageName) {
        Intent launchIntent = getActivity().getPackageManager().
                getLaunchIntentForPackage(packageName);

        if (launchIntent != null) {
            startActivity(launchIntent);
        } else {
            Toast.makeText(getActivity(), "App no encontrada", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_apps, container, false);

        btnFacebook = view.findViewById(R.id.btnFacebook);
        btnInstagram = view.findViewById(R.id.btnInstagram);
        btnTwitter = view.findViewById(R.id.btnTwitter);
        btnYouTube = view.findViewById(R.id.btnYouTube);

        // Facebook
        btnFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenApp("com.google.android.apps.facebook");
            }
        });

        // Instagram
        btnInstagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenApp("com.instagram.android");
            }
        });

        // Twitter
        btnTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenApp("com.twitter.android");

            }
        });

        // YouTube
        btnYouTube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenApp("com.youtube.android");

            }
        });

        // Inflate the layout for this fragment
        return view;
    }
}