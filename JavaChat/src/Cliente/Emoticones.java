package Cliente;

import java.awt.GridLayout;
import java.io.File;
import java.util.regex.Matcher;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

public class Emoticones extends JFrame{
    private String[] nomb;
    public Emoticones() {
        super("Emoticos");
        setLayout(new GridLayout(6, 6));
        setSize(300, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        try {
            File dir = new File(getClass().getResource("/emoticos").toURI());
            File[] emo = dir.listFiles();
            nomb = new String[emo.length];
            for(int i=0;i<emo.length;i++){
                JLabel l = new JLabel();
                nomb[i] = emo[i].getName();
                l.setIcon(new ImageIcon(getClass().getResource("/emoticos/"+emo[i].getName())));
                this.add(l);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void getEmo(String msj,JTextPane chat) throws BadLocationException{
        String noEmo = "";
        String t="";
        boolean aux=false;
        Document doc = chat.getDocument();
        int i;
        //for(int j=0;j<msj.length();j++){
        while(msj.length()>0){
            //t+=msj.charAt(j);
            msj = msj.trim();
            t = msj.indexOf(" ") > -1 ? msj.substring(0, msj.indexOf(" ")+1) : 
                    msj.indexOf("\n") > -1 ? msj.substring(0, msj.indexOf("\n")): msj.substring(0, msj.length());
            //t = t.trim();
            for(i=0;i<nomb.length;i++){
                if(t.contains(nomb[i].substring(0, nomb[i].indexOf("."))) && t.trim().length() <= nomb[i].substring(0, nomb[i].indexOf(".")).length()){
                    aux=true;
                    break;
                }
            }
            if(aux){
                aux = false;
                int p = msj.indexOf(nomb[i].substring(0, nomb[i].indexOf(".")));
                noEmo = msj.substring(0,p);
                doc.insertString(doc.getLength(), noEmo, null);
                chat.setCaretPosition(chat.getDocument().getLength());
                chat.insertIcon(new ImageIcon(getClass().getResource("/emoticos/"+nomb[i])));
            }else{
                doc.insertString(doc.getLength(), t, null);
            }
            System.out.println("Para remplazar: \""+t+"\"\nmsj: \""+msj+"\"");
            //msj = msj.replaceFirst(t.trim(), "");
            msj = msj.substring(t.length());
            System.out.println("Queda: \""+msj+"\"");
            t="";
        }
    }
    public boolean hayEmoticos(String msj){
        for(int i=0;i<nomb.length;i++){
            if(msj.contains(nomb[i].substring(0, nomb[i].indexOf("."))));
                return true;
        }
        return false;
    }
}
