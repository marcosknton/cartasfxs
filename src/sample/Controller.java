package sample;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageViewBuilder;
import javafx.util.Callback;

import java.util.ArrayList;



public class Controller {

    public TextArea Tadescripcion;
    public ImageView Ivdescripcion;
    public Label Tftitulo;
    public Label Tfrareza;
    public Label Tfcolor;

    @FXML
    ListView<Ocarta> Lvcartas ;

    public void initialize() {
        String vrareza="Common";
        String vcolor="Blue";
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


        Lvcartas.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Ocarta>() {
                    @Override
                    public void changed(ObservableValue<? extends Ocarta> observable, Ocarta oldValue, Ocarta newValue) {


                        Tadescripcion.setText(newValue.getDescripcion());
                        Image image1 = new Image(newValue.getImageUrl());
                        Ivdescripcion.setImage(image1);
                        Tftitulo.setText(newValue.getTitulo());
                        Tfrareza.setText(newValue.getRarity());
                        Tfcolor.setText(newValue.getColors());

                    }
        });

    }

}
