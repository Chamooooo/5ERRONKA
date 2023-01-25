package ariketi.erronki5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;




public class main2 {
    public static void main(String[] args) {
        String fitxeroIzena;
        String dokumentuIzena;
        //Harategiko Karpeta irakurri
        String dir_path = "C:/Users/ikaltamirapaag1/Desktop/baskulakofitxategiak";
        ArrayList<String> fitxeroak = karpetakIrakurri(dir_path);
        for(int x=0;x<fitxeroak.size();x++){
            fitxeroIzena=fitxeroak.get(x);
            fitxeroIzena = fitxeroIzena.substring(fitxeroIzena.lastIndexOf('/'),fitxeroIzena.lastIndexOf('.'));
            datuakatera(fitxeroIzena);
            
        }

        
        

    }
    //Karpetaren helbide jaso eta fitxero guztien helbidea bueltatu
    public static ArrayList<String> karpetakIrakurri(String dir_path){

            ArrayList<String> karpeta = new ArrayList<String>();
           

            File f = new File( dir_path );

            if ( f.isDirectory( )) {

               
                File[] arr_content = f.listFiles();

                int size = arr_content.length;

                for ( int i = 0; i < size; i ++ ) {

                    if ( arr_content[ i ].isFile( )){
                       
                        karpeta.add( arr_content[ i ].toString( ));
                        
                    }
                    
                }
            }

        return karpeta;
    }


public static Salmenta datuakatera(String dokumentuIzena){

   
    Salmenta s = new Salmenta();
    FileReader fr=null;
    BufferedReader br=null;
    String lerroa = "";
    try {
        fr = new FileReader(dokumentuIzena);
        br = new BufferedReader(fr);
        lerroa = br.readLine();
    } catch (Exception e) {
        // TODO: handle exception
    }

    
    dokumentuIzena = dokumentuIzena.substring(0,dokumentuIzena.indexOf('.'));
    s.setIdTicket(dokumentuIzena);

    String izena;
    izena = lerroa.substring(0,lerroa.indexOf('$'));
    s.setIzena(izena);
    
    String urtea;
    urtea = dokumentuIzena.substring(0,3);
    String hilabetea;
    hilabetea = dokumentuIzena.substring(3,5);
    String eguna;
    eguna = dokumentuIzena.substring(5,7);
    String noizAteraDa;
    noizAteraDa = urtea+hilabetea+eguna;
    s.setNoizAteraDa(noizAteraDa);
    


   






    return s;  
}

}

    




