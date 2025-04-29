package controller;

import db.dbConnection;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.item;

public class InventoryRemoveItemController {

    public TextField txtSearch;
    public TextField txtItemName;
    public TextField txtItemQty;
    public TextField txtItemPrice;

    private int index;

    private int searchIndex(int value){
        int size = dbConnection.getInstance().getItemList().size();
        for(int i=0; i<size; i++) {
            item itemObj = dbConnection.getInstance().getItemList().get(i);
            if(itemObj.getItemCode() == value){
                return i;
            }
        }
        return -1;
    }

    public void btnSearchOnAction(ActionEvent actionEvent) {
        int index = searchIndex(Integer.parseInt(txtSearch.getText()));
        if(index == -1){
            new Alert(Alert.AlertType.ERROR,"Error").show();
        }else {
            item itemObj = dbConnection.getInstance().getItemList().get(index);
            txtItemName.setText(itemObj.getItemName());
        }
    }

    public void btnRemoveOnAction(ActionEvent actionEvent) {
        dbConnection.getInstance().getItemList().remove(index);
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        item updateItem = dbConnection.getInstance().getItemList().get(index);
        updateItem.setItemName(txtItemName.getText());
        updateItem.setItemQty(Integer.parseInt(txtItemQty.getText()));
        updateItem.setItemPrice(Double.parseDouble(txtItemPrice.getText()));

    }
}
