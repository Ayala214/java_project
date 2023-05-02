package server;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;


/**
 *
 * @author student
 */
public class Place implements Serializable{
    Integer i;
    Integer j;
    Boolean ifcatch;

    String player;

    public Place() {
    }

    public Place(Integer i, Integer j, Boolean ifcatch) {
        this.i = i;
        this.j = j;
        this.ifcatch = ifcatch;
    }

    public Integer getI() {
        return i;
    }

    public Integer getJ() {
        return j;
    }

    public Boolean isIfcatch() {
        return ifcatch;
    }

    public String getPlayer(){return  player;};

    public void setI(Integer i) {
        this.i = i;
    }

    public void setJ(Integer j) {
        this.j = j;
    }

    public void setIfcatch(Boolean ifcatch) {
        this.ifcatch = ifcatch;
    }

    public void setPlayer(String player) {this.player=player;}

    @Override
    public String toString() {
        return "server.Place{" + "i=" + i + ", j=" + j + ", ifcatch=" + ifcatch + '}';
    }




}

