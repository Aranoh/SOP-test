/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Domain.Bier;
import java.util.ArrayList;
import javax.ejb.Stateless;

/**
 *
 * @author Mark van Drimmelen
 */
@Stateless
public class BierDAO {

    private ArrayList<Bier> bierList = new ArrayList<Bier>();

    public ArrayList<Bier> getAllBier() {
        return this.bierList;
    }
}
