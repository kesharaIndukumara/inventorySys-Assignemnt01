package controller;

import db.dbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.item;

public class InventoryViewItemController {

    public TableColumn colItemCode;
    public TableColumn colItemName;
    public TableColumn colItemQty;
    public TableColumn colItemPrice;
    public TableView tblItemView;

    public void btnReloadOnAction(ActionEvent actionEvent) {
        colItemCode.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        colItemName.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        colItemQty.setCellValueFactory(new PropertyValueFactory<>("itemQty"));
        colItemPrice.setCellValueFactory(new PropertyValueFactory<>("itemPrice"));

        ObservableList<item> itemObservableList = FXCollections.observableArrayList();

        dbConnection.getInstance().getItemList().forEach(item ->{
            itemObservableList.add(item);
        });

        tblItemView.setItems(itemObservableList);
    }
}
