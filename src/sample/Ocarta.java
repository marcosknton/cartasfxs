package sample;

/**
 * Created by michus on 19/10/2016.
 */

public class Ocarta {

    private String titulo,rarity,imageUrl,types,colors,descripcion;


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Ocarta(String titulo, String types, String imageUrl, String rarity, String colors, String descripcion) {
        this.titulo = titulo;
        this.types = types;
        this.imageUrl = imageUrl;
        this.rarity = rarity;
        this.colors=colors;
        this.descripcion=descripcion;

    }


    public void setColors(String colors){this.colors=colors;}
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public void setTypes(String types) {
        this.types = types;
    }
    public void setTitulo(String titulo) {
       this.titulo=titulo;
    }
    public void setRarity(String rarity) {this.rarity = rarity;}

    public String getRarity() {return rarity;}
    public String getColors() {
        return colors;
    }
    public String getTypes() {
        return types;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public String getTitulo() {
        return this.titulo;
    }

    @Override
    public String toString() {
        return "Carta{"+"titulo="+titulo+"}";
    }
}
