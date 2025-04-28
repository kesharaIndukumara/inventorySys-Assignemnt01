package controller;

import db.dbConnection;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.item;

public class InventoryRemoveItemController {
    public Label lblItemPrice;
    public Label lblItemQty;
    public Label lblItemName;
    public TextField txtSearch;

    private int index;

    public void search(int value){
        int size = dbConnection.getInstance().getItemList().size();
        for(int i=0; i<size; i++){
            this.index = i;
            item itemRef = dbConnection.getInstance().getItemList().get(i);
            if(itemRef.getItemCode() == value){
                lblItemName.setText(itemRef.getItemName());
                lblItemQty.setText(itemRef.getItemQty()+"");
                lblItemPrice.setText(itemRef.getItemPrice()+"");
                break;
            }else{
                new Alert(Alert.AlertType.ERROR,"Enter valid Item code..!").show();
                break;
            }
        }

    }

    public void btnSearchOnAction(ActionEvent actionEvent) {
        Integer seachNum = Integer.parseInt(txtSearch.getText());
        search(seachNum);


    }

    public void btnRemoveOnAction(ActionEvent actionEvent) {
        dbConnection.getInstance().getItemList().remove(index);
    }
}
