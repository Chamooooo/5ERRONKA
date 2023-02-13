package pkg5erronka;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.xml.bind.JAXBException;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;


import org.xml.sax.SAXException;




public class Main {

    public static void main(String[] args) throws JAXBException, IOException, SQLException{
        String fitxeroIzena;
        //Harategiko Karpeta irakurri
        String dir_path = "\\\\192.168.100.7\\Users\\ADMIN\\Desktop\\harategia\\Tiketak";
        //Okindegiko karpeta irakurri
        String dir_path2 = "\\\\192.168.100.8\\Users\\OKINDEGIA\\Desktop\\okindegia\\Tiketak";
        //Frutategiko karpeta irakurri
        String dir_path3 = "\\\\192.168.100.6\\Users\\ADMIN\\Desktop\\frutategia\\Tiketak";
        //Txarkutegiko karpeta irakurri
        String dir_path4 = "\\\\192.168.100.9\\Users\\ADMIN\\Desktop\\txarkutegia\\Tiketak";
     
        ArrayList<Salmenta> tiketakHarategia = karpetakIrakurri(dir_path,"1");
        ArrayList<Salmenta> tiketakOkindegia= karpetakIrakurri(dir_path2, "2");
        ArrayList<Salmenta> tiketakFrutategia = karpetakIrakurri(dir_path3, "3");
        ArrayList<Salmenta> tiketakTxarkutegia = karpetakIrakurri(dir_path4, "4");

        ArrayList<Salmenta> egunekoSalmentak = new ArrayList<>();
        egunekoSalmentak.addAll(tiketakHarategia);
        egunekoSalmentak.addAll(tiketakOkindegia);
        egunekoSalmentak.addAll(tiketakFrutategia);
        egunekoSalmentak.addAll(tiketakTxarkutegia);

        //XML SORTZEKO ETA BALIDATZEKO
        XML(egunekoSalmentak);
       
        //BackUpKarpetaraBialdu
        BackUpKarpetaraBialdu();

        LocalDate gaurkoData = LocalDate.now();
        //Backup karpetak helbideak
            //Harategia
            String harategia = "C:/Users/IKALTAMIRAPAAG1.ALTAMIRA/Documents/NetBeansProjects/5ERRONKA/BackUpKarpeta/"+gaurkoData+"/Harategia";
            //Arraindegia
            String okindegia = "C:/Users/IKALTAMIRAPAAG1.ALTAMIRA/Documents/NetBeansProjects/5ERRONKA/BackUpKarpeta/"+gaurkoData+"/Okindegia";
            //Txarkutegia
            String frutategia = "C:/Users/IKALTAMIRAPAAG1.ALTAMIRA/Documents/NetBeansProjects/5ERRONKA/BackUpKarpeta/"+gaurkoData+"/Frutategia";
            //Fruitategia
            String txarkutegia = "C:/Users/IKALTAMIRAPAAG1.ALTAMIRA/Documents/NetBeansProjects/5ERRONKA/BackUpKarpeta/"+gaurkoData+"/Txarkutegia";

       salmentakgorde(dir_path, gaurkoData,harategia);
       salmentakgorde(dir_path2, gaurkoData,okindegia);
       salmentakgorde(dir_path3, gaurkoData,frutategia);
       salmentakgorde(dir_path4, gaurkoData,txarkutegia);

        //MYSQL KONEXIOA
        MySQLStatements(egunekoSalmentak);
        
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
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
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
        prezioaKiloko = prezioaKiloko.replace(",", ".");
        s.setPrezioaKiloko(prezioaKiloko);

        String pisuaTemp;
        pisuaTemp = prezioaKilokoTemp.substring(prezioaKilokoTemp.indexOf('$')+1, prezioaKilokoTemp.length());
        String pisua;
        pisua = pisuaTemp.substring(0,pisuaTemp.indexOf('$'));
        pisua = pisua.replace(",", ".");
        s.setPisua(pisua);

        String prezioTotalaTemp;
        prezioTotalaTemp = pisuaTemp.substring(pisuaTemp.indexOf('$')+1, pisuaTemp.length());
        String prezioTotala;
        prezioTotala = prezioTotalaTemp.substring(0, prezioTotalaTemp.length());
        prezioTotala = prezioTotala.replace(",",".");
        s.setPrezioTotala(prezioTotala);

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return s;
    }

    public static void XML(ArrayList<Salmenta> egunekoSalmentak) throws JAXBException, IOException{
        try {
            EgunekoSalmentak salmentaZerrenda = new EgunekoSalmentak(egunekoSalmentak);

            JAXBContext contexto = JAXBContext.newInstance(EgunekoSalmentak.class);
            Marshaller m = contexto.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            m.marshal(salmentaZerrenda, new FileWriter("Salmenta.xml"));

            System.out.println("ONDO SORTU DA XML-a");
        } catch (Exception e) {
            e.printStackTrace();
        }
        

        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

            Source schemaFile = new StreamSource(new File("5ERRONKA.xsd"));
            Schema schema = factory.newSchema(schemaFile);

            Validator validator = schema.newValidator();

            Source source = new StreamSource("Salmenta.xml");
            validator.validate(source);
            System.out.println("ONDO BALIDATUTA DAGO");
            System.out.println("BACKUP KARPETARA BIALDUKO DET");
        } catch (SAXException  ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static void BackUpKarpetaraBialdu(){

        LocalDate gaurkoData = LocalDate.now();

        try {
            
        File carpeta = new File("BackUpKarpeta");
        carpeta.mkdir();

        File GaurkoKarpeta = new File("BackUpKarpeta/" + gaurkoData);
        GaurkoKarpeta.mkdirs();

        File Harategia = new File(GaurkoKarpeta, "Harategia");
        Harategia.mkdirs();
       

        File Okindegia = new File(GaurkoKarpeta, "Okindegia");
        Okindegia.mkdirs();

        File Frutategia = new File(GaurkoKarpeta, "Frutategia");
        Frutategia.mkdirs();

        File Txarkutegia = new File(GaurkoKarpeta, "Txarkutegia");
        Txarkutegia.mkdirs(); 

        System.out.println("ONDO SORTU DIRA EGUNEKO KARPETAK");
        } catch (Exception e) {
            e.printStackTrace();
        }

        

    }

    public static void salmentakgorde(String dir_path, LocalDate GaurkoData, String karpeta) throws IOException{
        
        Path sourceDir = Paths.get(dir_path);
        Path targetDir = Paths.get(karpeta + "/");
        Files.list(sourceDir).forEach(sourcePath -> {
            String strSoucePath = sourcePath.toString();
            int x = strSoucePath.lastIndexOf("\\");
            strSoucePath= strSoucePath.substring(strSoucePath.lastIndexOf("\\")+1);
            Path targetDir2 = Paths.get(targetDir+"/"+strSoucePath);   
            try {
                Files.move(sourcePath, targetDir2,  StandardCopyOption.REPLACE_EXISTING);
                System.out.println("ONDO MUGITU DIRA ARTXIBOAK");
         } catch (IOException e) {
             e.printStackTrace();
         }
     });
    }

    public static void MySQLStatements(ArrayList<Salmenta> egunekoSalmentak) throws SQLException{



        Connection connection = null;
        PreparedStatement insertStatement = null;
        String  izena, data, ordua, pisua, prezioaKiloko, prezioTotala, langileKodea, dendaIzena, insertSql;

        try {
            // Konektatu egiten da
            connection = mySQLkonexioa.getConnection();

            for (int i = 0; i < egunekoSalmentak.size(); i++) {


                 izena = egunekoSalmentak.get(i).getIzena();
                 data = egunekoSalmentak.get(i).getNoizAteraDa();
                 ordua = egunekoSalmentak.get(i).getOrdua();
                 pisua = egunekoSalmentak.get(i).getPisua();
                 prezioaKiloko = egunekoSalmentak.get(i).getPrezioaKiloko();
                 prezioTotala = egunekoSalmentak.get(i).getPrezioTotala();
                 langileKodea = egunekoSalmentak.get(i).getIdLangilea();
                 if (langileKodea.equals("autosalmenta")) {
                    langileKodea = "0";
                 }
                 dendaIzena = egunekoSalmentak.get(i).getIdDenda();
                 
                
                    // Sortu preparedStatement bat inserta egiteko
                    insertSql = "INSERT INTO ticket (IZENA, NOIZ_ATERA_DA, ORDUA, PISUA, PREZIOA_KILOKO, PREZIO_TOTALA, ID_LANGILEA, ID_DENDA)" + 
                     "VALUES ('"+izena+"','"+data+"','"+ordua+"','"+pisua+"','"+prezioaKiloko+"','"+prezioTotala+"','"+langileKodea+"','"+dendaIzena+"')";
                    insertStatement = connection.prepareStatement(insertSql);
            
                    // Inserta exekutatzen du
                    insertStatement.executeUpdate();

            }
    
        } catch (SQLException e) {
            // Errorea inserta exekutatzerakuan
            System.out.println("Error inserting data into the ticket table");
            e.printStackTrace();
        } finally {
            // Konexioa itxi eta statementa
            try {
                if (insertStatement != null) {
                    insertStatement.close();
                    System.out.println("ONDO ITXI DA STATEMENTA");
                }
                if (connection != null) {
                    connection.close();
                    System.out.println("ONDO ITXI DA KONEXIOA");
                }
            } catch (SQLException e) {
                // Errorea gauzak ixten badago
                System.out.println("Error closing the PreparedStatement or Connection");
                e.printStackTrace();
            }
        }
    }
}