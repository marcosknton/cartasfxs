package sample;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;

import javafx.util.Callback;

import java.util.ArrayList;

public class Controller {

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
    }
}
