package controller;

import db.dbConnection;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import model.item;

public class InventoryAddItemController {
    public TextField txtItemCode;
    public TextField txtItemName;
    public TextField txtItemPrice;
    public Spinner spinnerItemQty;
    public TextField txtItemQty;

    private boolean addItem(){
        return dbConnection.getInstance().getItemList().add(new item(
                Integer.parseInt(txtItemCode.getText()),
                txtItemName.getText(),
                Integer.parseInt(txtItemQty.getText()),
                Double.parseDouble(txtItemPrice.getText())
        ));

    }

    public void btnAddOnAction(ActionEvent actionEvent) {
        if(addItem()){
            txtItemCode.setText("");
            txtItemName.setText("");
            txtItemQty.setText("");
            txtItemPrice.setText("");
        }else{
            new Alert(Alert.AlertType.ERROR,"Something went wrong").show();
        }
    }
}
