package proyect_metodos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import proyect_clases.Boleto;
import proyect_clases.Pasajero;
import proyect_clases.Usuario;
import proyect_gui.GUI_Principal;

public class MetodoBoleto {
    Vector vPrincipal = new Vector();
    Boleto siguiente;
    String fecha,hr;
    int id,precio,cantidad,numero;
    int tam;
    Vector vUsuario = new Vector();
    Vector v1 = new Vector();
    
    
    public void crearBoleto(String fecha,String hora,int numero,int costo,int cantidad) {
        this.fecha=fecha;
        this.hr=hora;
        this.numero=numero;
        this.precio=costo;
        this.cantidad=cantidad;
      
        
        //FALTAb        
    }
    
    public void guardarBoleto(Boleto boleto) {
        vPrincipal.addElement(boleto);
    }
    
    //guardar archivo txt
    public void guardarArchivoBoleto(Boleto boleto){
        try {
            FileWriter fw = new FileWriter (".\\Boleto.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.print("|"+boleto.getNumero_boleto());
            pw.print("|"+boleto.getFecha_boleto());
            pw.print("|"+boleto.getHora_boleto());
            pw.print("|"+boleto.getCosto_boleto());
            pw.close();
        } catch (IOException e){
            JOptionPane.showMessageDialog(null, e);
        }
        //FALTA
        
    }

    public  Vector BuscarBoleto(String unIdUser){
      if (tam!=0)
        //FALTA
        try {
            FileReader fr = new FileReader(".\\Boleto.txt");
            BufferedReader br = new BufferedReader(fr);
            String d;
            while ((d=br.readLine())!=null){
                StringTokenizer dato = new StringTokenizer (d,"|");
                Vector x = new Vector();
                while (dato.hasMoreTokens()){
                    x.addElement(dato.nextToken());
                    }
                        String a = x.elementAt(0).toString();
                        if(a.equals(unIdUser)){
                            v1=x;
                            System.out.println(v1);     
                }
            }br.close();
            fr.close();
        }catch (Exception e){
        JOptionPane.showMessageDialog(null, e);
        }       
        return v1;
    }
    
}
