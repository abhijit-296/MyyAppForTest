package com.example.myyappfortest.model;

import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableArrayMap;
import androidx.databinding.ObservableField;

public class MyUnClass {

    public final ObservableField<String> un = new ObservableField<>();
    public ObservableArrayMap<String,String> mp = new ObservableArrayMap<>();
    public ObservableArrayList<Integer> al = new ObservableArrayList<>();

}
