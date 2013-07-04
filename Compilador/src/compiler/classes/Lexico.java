/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package compiler.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;

/**
 *
 * @author Administrador
 */
public class Lexico {
    private char[] divideString(String code){
        char[] tokens = new char[code.length()];
        for (int i = 0; i < tokens.length; i++) {
            tokens[i] = code.charAt(i);

        }
        return tokens;
    }

    public ArrayList<String> getComents(String code){
        char[] tokensAux = this.divideString(code);
        int firstPosition = -1;
        int secondPosition = -1;
        String comment = "";
        ArrayList comments = new ArrayList();
        for (int i = 0; i < tokensAux.length; i++) {
            if(tokensAux[i] == '@'){
                if(firstPosition == -1){
                    firstPosition = i;
                    continue;
                } else {
                    secondPosition = i;
                
                for (int j = firstPosition; j < secondPosition+1; j++) {
                    comment += tokensAux[j];
                }
                if (!comment.equals("")) {
                    comments.add(comment);
                    firstPosition = -1;
                    comment = "";
                }
                }
            }

        }
        return comments;
    }

    public int getSpacesNumber(String code){
        int numberSpaces = 0;
        for (int i = 0; i < code.length(); i++) {
            if(String.valueOf(code.charAt(i)).equals(" ") ||
                    String.valueOf(code.charAt(i)).equals("\n")){
                numberSpaces++;
            }
        }
        return numberSpaces;
    }

    public String deleteSpaces(String code){
        return code.replaceAll(" ", "").replaceAll("\t", "").replaceAll("\n", "");
    }

    public void verifyCharacters(String code, JComboBox c1, JComboBox c2,
            JComboBox c3, JComboBox c4, JComboBox c5){
        c1.removeAllItems();
        c1.addItem("--Letras--");
        c2.removeAllItems();
        c2.addItem("--Numeros--");
        c3.removeAllItems();
        c3.addItem("--Operadores--");
        c4.removeAllItems();
        c4.addItem("--Separadores--");
        c5.removeAllItems();
        c5.addItem("--Errores--");
        int tipeChar = 0;
        try {
            Class.forName(SQLQuery.Call.DRIVER);
            Connection con = DataBase.bdConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM Lexico WHERE token = ?");
            ArrayList<Caracter> arrayCharacters = new ArrayList<Caracter>();
            for (int i = 0; i < code.length(); i++) {
                char string = code.charAt(i);
                stmt.setString(1, String.valueOf(string).toUpperCase());
                ResultSet rs = stmt.executeQuery();
                Caracter caracter = null;
                if (rs != null && rs.next()) {
                    caracter = processCharacterResultSet(rs);
                    tipeChar = caracter.getTipe();
                    if(tipeChar == 1){
                        c1.addItem(String.valueOf(caracter.getCaracter()));
                    }
                    if(tipeChar == 2){
                        c2.addItem(String.valueOf(caracter.getCaracter()));
                    }
                    if(tipeChar == 3){
                        c3.addItem(String.valueOf(caracter.getCaracter()));
                    }
                    if(tipeChar == 4){
                        c4.addItem(String.valueOf(caracter.getCaracter()));
                    }

                } else {
                    if(!String.valueOf(string).equals(" ") &&
                            !String.valueOf(string).equals("\t") &&
                            !String.valueOf(string).equals("\r") &&
                            !String.valueOf(string).equals("\n")){
                        c5.addItem(String.valueOf(string));
                    }
                    
                }
            }
            stmt.close();
            con.close();
        } catch (SQLException ex) {
                Logger.getLogger(Lexico.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Lexico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static Caracter processCharacterResultSet(ResultSet rs) throws SQLException {
        Caracter caracter = new Caracter();
        caracter.setCaracter(rs.getString(1).charAt(0));
        caracter.setTipe(rs.getInt(2));
        return caracter;
    }

}
