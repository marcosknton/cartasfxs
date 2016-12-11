package sample;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageViewBuilder;
import javafx.scene.text.Font;
import javafx.util.Callback;

import java.util.ArrayList;



public class Controller {

    public TextArea Tadescripcion;
    public ImageView Ivdescripcion;
    public Label Tftitulo;
    public Label Tfrareza;
    public Label Tfcolor;
    String vcolor="white";
    String vrareza="Common";




    @FXML
    ListView<Ocarta> Lvcartas ;

    public void Empty (ActionEvent actionEvent){
        vrareza="Empty";
        initialize();
    }

    public void Common (ActionEvent actionEvent){
        vrareza="Common";
        initialize();
    }

    public void Uncommon (ActionEvent actionEvent){
        vrareza="Uncommon";
        initialize();
    }

    public void Rare (ActionEvent actionEvent){
        vrareza="Rare";
        initialize();
    }

    public void Mythic_Rare (ActionEvent actionEvent){
        vrareza="Mythic Rare";
        initialize();
    }

    public void Special (ActionEvent actionEvent){
        vrareza="Special";
        initialize();
    }
    public void Basic_Land (ActionEvent actionEvent){
        vrareza="Basic Land";
        initialize();
    }
    public void azul (ActionEvent actionEvent) {
        vcolor = "blue";
        initialize();
    }
    public void negro (ActionEvent actionEvent) {
        vcolor = "black";
        initialize();
    }
    public void blanco (ActionEvent actionEvent) {
        vcolor = "white";
        initialize();
    }
    public void verde (ActionEvent actionEvent) {
        vcolor = "green";
        initialize();
    }
    public void rojo (ActionEvent actionEvent) {
        vcolor = "red";
        initialize();
    }

    public void initialize() {

        CartasApi cartasapi=new CartasApi();
        ArrayList<Ocarta> listaocartas=cartasapi.getOcartas(vrareza,vcolor);

        Lvcartas.setCellFactory(new Callback<ListView<Ocarta>, ListCell<Ocarta>>() {

            @Override
            public ListCell<Ocarta> call(ListView<Ocarta> p) {

                ListCell<Ocarta> cell = new ListCell<Ocarta>() {

                    @Override
                    protected void updateItem(Ocarta t, boolean bln) {
                        super.updateItem(t, bln);
                        if (t != null) {
                            String titulo="titulo: "+t.getTitulo();
                            String rareza="rareza: "+t.getRarity();
                            String color="color: "+t.getColors();
                            String texto=titulo+"\n"+rareza+"\n"+color;
                            setText(texto);
                        }
                    }
                };
                return cell;
            }
        });
        ObservableList<Ocarta> items = FXCollections.observableArrayList (
             listaocartas);
        Lvcartas.setItems(items);

        if (items.size()==0){
            Tadescripcion.setText("elige otra combinación");
            Image image = new Image((getClass().getResourceAsStream("image/no_disponible.png")));;

            Ivdescripcion.setImage(image);
            Tftitulo.setText("...");
            Tfrareza.setText("...");
            Tfcolor.setText("...");
        }
        else {
            Tadescripcion.setText(items.get(0).getDescripcion());
            Image image = new Image(items.get(0).getImageUrl());
            Ivdescripcion.setImage(image);
            Tftitulo.setText(items.get(0).getTitulo());
            Tfrareza.setText(items.get(0).getRarity());
            Tfcolor.setText(items.get(0).getColors());
        }

        Lvcartas.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            Tadescripcion.setText(newValue.getDescripcion());
            Image image1 = new Image(newValue.getImageUrl());
            Ivdescripcion.setImage(image1);
            Tftitulo.setText(newValue.getTitulo());
            Tfrareza.setText(newValue.getRarity());
            Tfcolor.setText(newValue.getColors());

        });

    }
    public void informacio(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("sobre l'editor");
        alert.setHeaderText(null);
        alert.setContentText("En el margen izquierdo dispones de 2 filtros un por rareza y otro por color, una vez seleccionados automaticamente te mostrará " +
                "el grupo de cartas que cumplen esas 2 condiciones, selecciona una carta de la lista para obtener más detalles. " +
                " Si el espacio del texto de la carta es pequeño puede agrandarlo estirando la ventana, por una de sus esquinas :)");

        alert.showAndWait();
    }

}
