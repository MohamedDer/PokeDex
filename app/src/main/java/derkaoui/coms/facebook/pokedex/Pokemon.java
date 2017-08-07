package derkaoui.coms.facebook.pokedex;

/**
 * Created by Mohamed Derkaoui on 17/07/2017.
 */

public class Pokemon {
    private int id;
    private String name;
    private String description;
    private String link;

    public Pokemon(int id, String name, String description, String link){
        this.id=id;
        this.name=name;
        this.description=description;
        this.link=link;
    }



    public String getName(){return  this.name;  }
    public String getDescription(){return  this.description;  }
    public String getLink(){return  this.link;  }




}
