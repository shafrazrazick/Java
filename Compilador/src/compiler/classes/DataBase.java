/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package compiler.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Administrador
 */
public class DataBase {

    public static Connection bdConnection() throws SQLException{
        String urlCad = "jdbc:derby:" + "Compilador" + ";create=true";
        Connection conec = DriverManager.getConnection(urlCad, "jesus", "sql");
        return conec;
    }
}
