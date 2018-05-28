package com.example.nazar.lab1;

import android.graphics.Color;

public class MyColors {
    private String _name;
    private String _color;

    MyColors(String n, String c) {
        _name = n;
        _color = c;
    }

    public String GetName()
    {
        return _name;
    }

    public String GetColor()
    {
        return _color;
    }
}
