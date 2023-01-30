package pkg5erronka;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.JAXBException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class Main2 {
    public static void main(String[] args) throws JAXBException, IOException {
        String fitxeroIzena;
        //Harategiko Karpeta irakurri
        String dir_path = "C:/Users/IKALTAMIRAPAAG1.ALTAMIRA/Desktop/harategia/Tiketak";
        //Okindegiko karpeta irakurri
        String dir_path2 = "C:/Users/IKALTAMIRAPAAG1.ALTAMIRA/Desktop/okindegia/Tiketak";
        //Frutategiko karpeta irakurri
        String dir_path3 = "C:/Users/IKALTAMIRAPAAG1.ALTAMIRA/Desktop/frutategia/Tiketak";
        //Txarkutegiko karpeta irakurri
        String dir_path4 = "C:/Users/IKALTAMIRAPAAG1.ALTAMIRA/Desktop/txarkutegia/Tiketak";
     
        ArrayList<Salmenta> tiketakHarategia = karpetakIrakurri(dir_path,"Harategia");
        ArrayList<Salmenta> tiketakOkindegia= karpetakIrakurri(dir_path2, "Okindegia");
        ArrayList<Salmenta> tiketakFrutategia = karpetakIrakurri(dir_path3, "Frutategia");
        ArrayList<Salmenta> tiketakTxarkutegia = karpetakIrakurri(dir_path4, "Txarkutegia");
        
        ArrayList<Salmenta> egunekoSalmentak = new ArrayList<>();
        egunekoSalmentak.addAll(tiketakHarategia);
        egunekoSalmentak.addAll(tiketakOkindegia);
        egunekoSalmentak.addAll(tiketakFrutategia);
        egunekoSalmentak.addAll(tiketakTxarkutegia);

        EgunekoSalmentak salmentaZerrenda = new EgunekoSalmentak(egunekoSalmentak);

        JAXBContext contexto = JAXBContext.newInstance(EgunekoSalmentak.class);
        Marshaller m = contexto.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        m.marshal(salmentaZerrenda, new FileWriter("Salmenta.xml"));
    }
    //Karpetaren helbide jaso eta fitxero guztien helbidea bueltatu
    public static ArrayList<Salmenta> karpetakIrakurri(String dir_path, String idDenda){

            ArrayList<String> karpeta = new ArrayList<String>();
            ArrayList<Salmenta> salmentaZerrenda = new ArrayList<Salmenta>();
            String fitxeroIzena;

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
            Salmenta salmenta;
            for(int x=0;x<karpeta.size();x++){
                fitxeroIzena=karpeta.get(x);
                //fitxeroIzena = fitxeroIzena.substring(fitxeroIzena.lastIndexOf('\\')+1,fitxeroIzena.lastIndexOf('.'));
                salmenta = datuakatera(fitxeroIzena);
                salmenta.setIdDenda(idDenda);
                salmentaZerrenda.add(salmenta);
            }
        return salmentaZerrenda;
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
            
        }

        
        dokumentuIzena = dokumentuIzena.substring(dokumentuIzena.lastIndexOf('\\')+1,dokumentuIzena.lastIndexOf('.'));
        s.setIdTicket(dokumentuIzena);

        String izena;
        izena = lerroa.substring(0,lerroa.indexOf('$'));
        s.setIzena(izena);
        
        String urtea;
        urtea = dokumentuIzena.substring(0,4);
        String hilabetea;
        hilabetea = dokumentuIzena.substring(4,6);
        String eguna;
        eguna = dokumentuIzena.substring(6,8);
        String noizAteraDa;
        noizAteraDa = urtea+"/"+hilabetea+"/"+eguna;
        s.setNoizAteraDa(noizAteraDa);

        
        String ordua;
        ordua = dokumentuIzena.substring(8, 10);
        String minutuak;
        minutuak = dokumentuIzena.substring(10, 12);
        String segunduak;
        segunduak = dokumentuIzena.substring(12,14);
        String orduaOsoa;
        orduaOsoa = ordua+":"+minutuak+":"+segunduak;
        s.setOrdua(orduaOsoa);
        
        String idLangileaTemp;
        idLangileaTemp = lerroa.substring(0,lerroa.length());
        String idLangileaTemp2;
        idLangileaTemp2 = idLangileaTemp.substring(idLangileaTemp.indexOf('$')+1,idLangileaTemp.length());
        String idLangilea;
        idLangilea = idLangileaTemp2.substring(0, idLangileaTemp2.indexOf('$'));
        s.setIdLangilea(idLangilea);

        String prezioaKilokoTemp;
        prezioaKilokoTemp = idLangileaTemp2.substring(idLangileaTemp2.indexOf('$')+1, idLangileaTemp2.length());
        String prezioaKiloko;
        prezioaKiloko = prezioaKilokoTemp.substring(0, prezioaKilokoTemp.indexOf('$'));
        s.setPrezioaKiloko(prezioaKiloko);

        String pisuaTemp;
        pisuaTemp = prezioaKilokoTemp.substring(prezioaKilokoTemp.indexOf('$')+1, prezioaKilokoTemp.length());
        String pisua;
        pisua = pisuaTemp.substring(0,pisuaTemp.indexOf('$'));
        s.setPisua(pisua);

        String prezioTotalaTemp;
        prezioTotalaTemp = pisuaTemp.substring(pisuaTemp.indexOf('$')+1, pisuaTemp.length());
        String prezioTotala;
        prezioTotala = prezioTotalaTemp.substring(0, prezioTotalaTemp.length());
        s.setPrezioTotala(prezioTotala);
        return s;
    }
}