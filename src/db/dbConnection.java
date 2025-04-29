package db;

import model.item;

import java.util.ArrayList;
import java.util.List;

public class dbConnection {
    private static dbConnection instance;

    List<item> itemList;

    private dbConnection(){
        itemList = new ArrayList<>();
        itemList.add(new item(100, "pen", 2, (double) 120.0));
        itemList.add(new item(101, "pen01", 2, (double) 120.0));
        itemList.add(new item(102, "pen02", 2, (double) 120.0));
        itemList.add(new item(103, "pen03", 2, (double) 120.0));
    }

    public List<item> getItemList(){
        return itemList;
    }

    public static dbConnection getInstance(){
        return instance == null ? instance = new dbConnection():instance;
    }
}
