/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Domain.Bier;
import dao.BierDAO;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author Mark van Drimmelen
 */
@ManagedBean(name = "bierBean")
@SessionScoped
public class BierBean {

    @Inject
    BierDAO bd;

    public ArrayList<Bier> getAllBier() {
        return bd.getAllBier();
    }
}
