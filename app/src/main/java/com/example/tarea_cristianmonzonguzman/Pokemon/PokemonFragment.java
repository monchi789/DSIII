package com.example.tarea_cristianmonzonguzman.Pokemon;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tarea_cristianmonzonguzman.Pokemon.Models.Pokemon;
import com.example.tarea_cristianmonzonguzman.Pokemon.Models.PokemonAnswers;
import com.example.tarea_cristianmonzonguzman.Pokemon.PokeApi.PokeApiService;
import com.example.tarea_cristianmonzonguzman.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PokemonFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PokemonFragment extends Fragment {

    // Define the variables
    private Retrofit retrofit;
    private static final String TAG = "POKEDEX";

    private RecyclerView recyclerView;
    private ListPokemonAdapter listPokemonAdapter;

    private int offset;
    private boolean readyForCharge;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PokemonFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PokemonFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PokemonFragment newInstance(String param1, String param2) {
        PokemonFragment fragment = new PokemonFragment();
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

    // Method to get data
    private void GetData(int offset) {
        PokeApiService service = retrofit.create(PokeApiService.class);
        Call<PokemonAnswers> pokemonAnswersCall = service.GetPokemonList(20, offset);

        pokemonAnswersCall.enqueue(new Callback<PokemonAnswers>() {
            @Override
            public void onResponse(Call<PokemonAnswers> call, Response<PokemonAnswers> response) {
                readyForCharge = true;
                if (response.isSuccessful()) {
                    PokemonAnswers pokemonAnswers = response.body();
                    ArrayList<Pokemon> listPokemon = pokemonAnswers.getResults();

                    listPokemonAdapter.AddListPokemon(listPokemon);

                }
            }

            @Override
            public void onFailure(Call<PokemonAnswers> call, Throwable t) {
                readyForCharge = true;
                Log.e(TAG, " onFailure: " + t.getMessage());
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_pokemon, container, false);
        // Inflate the layout for this fragment

        recyclerView = view.findViewById(R.id.recyclerView);
        listPokemonAdapter = new ListPokemonAdapter(getActivity());
        recyclerView.setAdapter(listPokemonAdapter);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 3);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if (dy > 0) {

                    int visibleItemCount = layoutManager.getChildCount();
                    int totalItemCount = layoutManager.getItemCount();
                    int pastVisibleCount = layoutManager.findFirstVisibleItemPosition();


                    if (readyForCharge) {
                        if((visibleItemCount + pastVisibleCount) >= totalItemCount){
                            Log.i(TAG, " Arrived at the end.");

                            readyForCharge = false;
                            offset += 20;
                            GetData(offset);
                        }
                    }
                }
            }
        });

        retrofit = new Retrofit.Builder().baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        readyForCharge = true;
        offset = 0;

        // Call the method to get data
        GetData(offset);


        return view;
    }
}