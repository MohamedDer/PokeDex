package layout.p;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import derkaoui.coms.facebook.pokedex.R;

public class PokeDetail extends AppCompatActivity {

    ImageView image;
    TextView name, desc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poke_detail);

        image = (ImageView)  findViewById(R.id.image);
        name = (TextView) findViewById(R.id.name);
        desc = (TextView)  findViewById(R.id.description);

        name.setText(getIntent().getStringExtra("name").toString());
        desc.setText(getIntent().getStringExtra("description").toString());

        Picasso.with(this).load(getIntent().getStringExtra("link")).into(image);


    }
}
