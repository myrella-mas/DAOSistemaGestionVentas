/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.ds.BDNoSqlDAOFactory;
import dao.ds.BDRelacionalDAOFactory;
import dao.component.BDRelacionalProductoDAO;
import dao.component.BDNoSqlProductoDAO;
/**
 *
 * @author oscar
 */

//clase abstracta DAOFactory
public abstract class DAOFactory {
    //lista de los tipos DAO soportados por la factoria
    public static final int Relacional=1;
    public static final int NoSql=2;
    
    //Metodo para cada DAO
    
    public abstract BDRelacionalProductoDAO getProductoDAO();
    public abstract BDNoSqlProductoDAO getProductoDAO2();
    
    public static DAOFactory getDAOFactoria(int queFactoria){
        switch(queFactoria){
            case Relacional:
                return new BDRelacionalDAOFactory();
            case NoSql:
                return new BDNoSqlDAOFactory();
            default:
                return null;
        }
    }
    
}
