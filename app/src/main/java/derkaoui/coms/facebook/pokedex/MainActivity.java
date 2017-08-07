package derkaoui.coms.facebook.pokedex;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CursorAdapter;
import android.widget.GridView;

import java.util.ArrayList;

import me.sargunvohra.lib.pokekotlin.client.PokeApi;
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient;
import me.sargunvohra.lib.pokekotlin.model.PokemonSpecies;

public class MainActivity extends AppCompatActivity {

    ArrayList<Pokemon> pokees;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        pokees = new ArrayList<Pokemon>();
        PokeApi pokeApi = new PokeApiClient();


        for (int i=1; i<10;i++){
            pokees.add(new Pokemon(i,pokeApi.getPokemonSpecies(i).getName(), "dd ", "http://www.pokepedia.fr/images/thumb/a/a0/Pikachu_SSB4.png/300px-Pikachu_SSB4.png" ));
            Log.d(" pokemon added ", pokees.get(i-1).getName());
        }


        GridView grid = (GridView) findViewById(R.id.grid);
        GridAdapter gAdapter = new GridAdapter(this,pokees);
        grid.setAdapter(gAdapter);


        Log.d("poke to string"," " );

    }
}
