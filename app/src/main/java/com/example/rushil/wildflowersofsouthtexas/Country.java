package com.example.rushil.wildflowersofsouthtexas;

/**
 * Created by Rushil on 09-Feb-17.
 */

public class Country
{

    public String name;
    private int falg_id;

    public Country(String name,int falg_id)
    {
        this.setName(name);
        this.setFalg_id(falg_id);

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFalg_id() {
        return falg_id;
    }

    public void setFalg_id(int falg_id) {
        this.falg_id = falg_id;
    }

}
