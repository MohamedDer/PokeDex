package derkaoui.coms.facebook.pokedex;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import layout.p.PokeDetail;

/**
 * Created by Mohamed Derkaoui on 17/07/2017.
 */

public class GridAdapter extends BaseAdapter {

    Context context;
    ArrayList<Pokemon> pokemons;

    public GridAdapter(Context ctx , ArrayList<Pokemon> pokemons){
        this.context=ctx;
        this.pokemons=pokemons;
        this.context=ctx;
    }



    @Override
    public int getCount() {
        return pokemons.size();
    }

    @Override
    public Object getItem(int position) {
        return pokemons.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class Holder
    {
        TextView poke_name;
        ImageView poke_img;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Holder holder=new Holder();
        LayoutInflater inflater = ( LayoutInflater )context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView;
        rowView = inflater.inflate(R.layout.poke_item, null);
        holder.poke_name =(TextView) rowView.findViewById(R.id.name);
        holder.poke_img =(ImageView) rowView.findViewById(R.id.image);

        holder.poke_name.setText(pokemons.get(position).getName());
        Picasso.with(context).load(pokemons.get(position).getLink()).resize(400,420).into(holder.poke_img);

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent details =new Intent(context, PokeDetail.class);
                details.putExtra("name",pokemons.get(position).getName() );
                details.putExtra("description",pokemons.get(position).getDescription() );
                details.putExtra("link",pokemons.get(position).getLink() );
                context.startActivity(details);


            }
        });





        return rowView;
    }
}
