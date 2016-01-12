package com.kowal.dao;

import java.util.ArrayList;

/**
 * Created by JK on 2016-01-11.
 */
public class ProductDao {
    private ArrayList<String> arrayList;

    public ArrayList<String> getArrayList() {
        return arrayList;
    }

    public void setArrayList() {
        arrayList.add(1, "45");
        arrayList.add(2, "64");
    }
}
