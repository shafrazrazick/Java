package Cliente;

import java.io.*;

class threadCliente extends Thread{
    DataInputStream entrada;
    VentCliente vcli;
    public threadCliente (DataInputStream entrada,VentCliente vcli) throws IOException{
        this.entrada=entrada;
        this.vcli=vcli;
    }
    public void run(){
        String menser="",amigo="";
        int opcion=0;
        while(true){
            try{
                opcion=entrada.readInt();
                switch(opcion){
                    case 1://mensage enviado
                        menser=entrada.readUTF();
                        System.out.println("ECO del servidor:"+menser);
                        vcli.mostrarMsg(menser);            
                        break;
                    case 2://se agrega
                        menser=entrada.readUTF();
                        vcli.agregarUser(menser);                  
                        break;
                    case 3://mensage de amigo
                        amigo=entrada.readUTF();
                        menser=entrada.readUTF();
                        vcli.mensageAmigo(amigo,menser);
                        System.out.println("ECO del servidor:"+menser);
                        break;
                }
            }catch (IOException e){
                System.out.println("Error en la comunicaci�n "+"Informaci�n para el usuario");
                break;
            }
        }
        System.out.println("se desconecto el servidor");
    }
}