/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.util.ArrayList;

/**
 *
 * @author Mark van Drimmelen
 */
public class Bier {

    private String name;
    private String merk;
    private ArrayList<String> verkoopPunten;

    public Bier(String name, String merk) {
        this.name = name;
        this.merk = merk;
        this.verkoopPunten = new ArrayList<String>();
    }

    public void AddVerkoopPunt(String verkoopPunt) {
        this.verkoopPunten.add(verkoopPunt);
    }
}
