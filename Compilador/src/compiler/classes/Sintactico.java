/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package compiler.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;

/**
 *
 * @author Administrador
 */
public class Sintactico {

    public void addWords(String code, JComboBox c1, JComboBox c2,
            JComboBox c3, JComboBox c4){
        c1.removeAllItems();
        c1.addItem("     --Palabras--     ");
        c2.removeAllItems();
        c2.addItem("     --Palabras Simples--     ");
        c3.removeAllItems();
        c3.addItem("     --Palabras Compuestas--     ");
        c4.removeAllItems();
        c4.addItem("     --Errores Sintacticos--     ");
        String []words = ProcessString(code);
        Word wordAux = null;
        for(String w: words){
            c1.addItem(w);
            try {
                wordAux = searchWord(w);
            } catch (SQLException ex) {
                Logger.getLogger(Sintactico.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(wordAux == null){
                c4.addItem("Error palabra no existe: "+w);
            } else {
                if(wordAux.getClase() == 'S'){
                    c2.addItem(w);
                }
                if(wordAux.getClase() == 'C'){
                    c3.addItem(w);
                    try {
                        Word wo = searchWord(w);
                        Compuesta c = new Compuesta();
                        c.setPalabra(wo.getPalabra());
                        c.setPalabra1(wo.getPalabra1());
                        c.setPalabra2(wo.getPalabra2());
                        verifyWords(words,c,c4);
                    } catch (SQLException ex) {
                        Logger.getLogger(Sintactico.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }

    }

    private void verifyWords(String [] words, Compuesta word, JComboBox errores){
        String p1 = word.getPalabra1();
        String p2 = word.getPalabra2();
        String p = word.getPalabra();
        int count1 = 0;
        int count2 = 0;
        for(String w: words){
            if(!w.equals("Prg") && !w.equals("Vent")){
            if(!p1.equals(w)){
                count1++;
                if(count1 == words.length)
                errores.addItem("Error: "+p1+" falta en el editor");
            } else{
                count1 = -1;
            }
            if(p2 != null)
            if(!p2.equals(w)){
                count2++;
                if(count2 == words.length)
                errores.addItem("Error: "+p2+" falta en el editor");
            } else {
                count2 = -1;
            }
            }
        }
    }

    public Word searchWord(String word) throws SQLException{
        Word w = null;
        PreparedStatement stmt = null;
        Connection con = null;
        try {
            Class.forName(SQLQuery.Call.DRIVER);
            con = DataBase.bdConnection();
            stmt = con.prepareStatement("SELECT * FROM SINTACTICO WHERE Palabra = ?");
            stmt.setString(1, String.valueOf(word));
            ResultSet rs = stmt.executeQuery();
            if (rs != null && rs.next()) {
                w = processWordResultSet(rs);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Sintactico.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Sintactico.class.getName()).log(Level.SEVERE, null, ex);
        }
        stmt.close();
        con.close();
        return w;

    }

    private static Word processWordResultSet(ResultSet rs) throws SQLException {
        Word word = new Word();
        word.setPalabra(rs.getString(1));
        word.setClase(rs.getString(2).charAt(0));
        word.setPalabra1(rs.getString(3));
        word.setPalabra2(rs.getString(4));
        word.setSignificado(rs.getString(5));
        return word;
    }

    private static String[] ProcessString(String text) {
        text = text.replace("             ", ":");
        text = text.replace("            ", ":");
        text = text.replace("           ", ":");
        text = text.replace("          ", ":");
        text = text.replace("         ", ":");
        text = text.replace("        ", ":");
        text = text.replace("       ", ":");
        text = text.replace("      ", ":");
        text = text.replace("     ", ":");
        text = text.replace("    ", ":");
        text = text.replace("   ", ":");
        text = text.replace("  ", ":");
        text = text.replace(" ", ":");
        return text.split(":");

    }

    public String getMathExpression(String code){
        if(code.contains("IEX") && code.contains("FEX")){
            return code.substring(code.indexOf("IEX")+3,code.lastIndexOf("FEX"));
        }else
            return "";
    }
}
