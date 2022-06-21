/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.barang.webservices;

import com.barang.controller.BarangController;
import com.barang.model.Barang;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Gian
 */
@WebService(serviceName = "BarangWS")
public class BarangWS {

    /**
     * This is a sample web service operation
     */
//    @WebMethod(operationName = "hello")
//    public String hello(@WebParam(name = "name") String txt) {
//        return "Hello " + txt + " !";
//    }
    /**
     * Web service operation
     */
    @WebMethod(operationName = "getAllBarang")
    public List<Barang> getAllBarang() {
        //TODO write your implementation code here:
        BarangController bc = BarangController.getKoneksi();
        return bc.getAllBarang();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteBarang")
    public void deleteBarang(@WebParam(name = "id") long id) {
        //TODO write your implementation code here:
        BarangController bc = BarangController.getKoneksi();
        bc.deleteBarang(id);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getBarang")
    public Barang getBarang(@WebParam(name = "id") long id) {
        BarangController bc = BarangController.getKoneksi();
        return bc.getBarang(id);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "updateBarang")
    public void updateBarang(@WebParam(name = "barang") Barang barang) {
        //TODO write your implementation code here:
        BarangController bc = BarangController.getKoneksi();
        bc.updateBarang(barang);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "insertBarang")
    public void insertBarang(@WebParam(name = "barang") Barang barang) {
        //TODO write your implementation code here:
        BarangController bc = BarangController.getKoneksi();
        bc.insertBarang(barang);
    }
}
