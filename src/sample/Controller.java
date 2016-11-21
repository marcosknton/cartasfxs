package sample;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;

import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageViewBuilder;
import javafx.util.Callback;

import java.util.ArrayList;



public class Controller {

    public TextArea Tadescripcion;
    public ImageView Ivdescripcion;

    @FXML
    ListView<Ocarta> Lvcartas ;

    public void initialize() {

        CartasApi cartasapi=new CartasApi();
        ArrayList<Ocarta> listaocartas=cartasapi.getOcartas();

        Lvcartas.setCellFactory(new Callback<ListView<Ocarta>, ListCell<Ocarta>>() {

            @Override
            public ListCell<Ocarta> call(ListView<Ocarta> p) {

                ListCell<Ocarta> cell = new ListCell<Ocarta>() {

                    @Override
                    protected void updateItem(Ocarta t, boolean bln) {
                        super.updateItem(t, bln);
                        if (t != null) {
                            setText(t.getTitulo());
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

                        //System.out.println(newValue.getTitulo());
                        Tadescripcion.setText(newValue.getDescripcion());
                        Image image1 = new Image(newValue.getImageUrl());
                        Ivdescripcion.setImage(image1);

                    }
        });

    }

}
