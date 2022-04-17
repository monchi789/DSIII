package com.example.tarea_cristianmonzonguzman.Pokemon.PokeApi;

import com.example.tarea_cristianmonzonguzman.Pokemon.Models.PokemonAnswers;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PokeApiService {

    @GET("pokemon")
    Call<PokemonAnswers> GetPokemonList(@Query("limit") int limit, @Query("offset") int offset);

}
