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

    public void search(int value){
        int size = dbConnection.getInstance().getItemList().size();//get size of arrayList
        for(int i=0; i<size; i++){
            System.out.println("in For loop");
            this.index = i;
            item itemRef = dbConnection.getInstance().getItemList().get(i);
            System.out.println(itemRef);
            if(itemRef.getItemCode() == value){
                System.out.println(dbConnection.getInstance().getItemList().get(i));
                txtItemName.setText(itemRef.getItemName());
                txtItemQty.setText(itemRef.getItemQty()+"");
                txtItemPrice.setText(itemRef.getItemPrice()+"");
                break;
            }else{
                new Alert(Alert.AlertType.ERROR,"Enter valid Item code..!").show();
                break;
            }
        }
    }

    public void btnSearchOnAction(ActionEvent actionEvent) {
        int seachNum = Integer.parseInt(txtSearch.getText());
        search(seachNum);

        //dbConnection.getInstance().getItemList().
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
