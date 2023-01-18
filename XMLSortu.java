package pkg5erronka;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XMLSortu {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();
            
            // Create the root element
            Element root = doc.createElement("salmenta_zerrenda");
            doc.appendChild(root);
            
            // Create the "salmenta" element
            Element salmenta = doc.createElement("salmenta");
            root.appendChild(salmenta);
            
            // Create the "ID_TICKET" element
            Element ID_TICKET = doc.createElement("ID_TICKET");
            ID_TICKET.setTextContent("005");
            salmenta.appendChild(ID_TICKET);
            
            // Create the "IZENA" element
            Element IZENA = doc.createElement("IZENA");
            IZENA.setTextContent("Ogia");
            salmenta.appendChild(IZENA);
            
            // Create the "NOIZ_ATERA_DA" element
            Element NOIZ_ATERA_DA = doc.createElement("NOIZ_ATERA_DA");
            NOIZ_ATERA_DA.setTextContent("2023/01/11");
            salmenta.appendChild(NOIZ_ATERA_DA);
            
            // Create the "KOPURUA" element
            Element KOPURUA = doc.createElement("KOPURUA");
            KOPURUA.setTextContent("5");
            salmenta.appendChild(KOPURUA);
            
            // Create the "PISUA" element
            Element PISUA = doc.createElement("PISUA");
            PISUA.setTextContent("2");
            salmenta.appendChild(PISUA);
            
            // Create the "PREZIOA_KILOKO" element
            Element PREZIOA_KILOKO = doc.createElement("PREZIOA_KILOKO");
            PREZIOA_KILOKO.setTextContent("10");
            salmenta.appendChild(PREZIOA_KILOKO);
            
            // Create the "PREZIO_TOTALA" element
            Element PREZIO_TOTALA = doc.createElement("PREZIO_TOTALA");
            PREZIO_TOTALA.setTextContent("30");
            salmenta.appendChild(PREZIO_TOTALA);
            // Create the "ID_LANGILEA" element
            Element ID_LANGILEA = doc.createElement("ID_LANGILEA");
            ID_LANGILEA.appendChild(doc.createTextNode("IGOR001"));
            salmenta.appendChild(ID_LANGILEA);
            // Create the "ID_DENDA" element
            Element ID_DENDA = doc.createElement("ID_DENDA");
            ID_DENDA.appendChild(doc.createTextNode("001"));
            salmenta.appendChild(ID_DENDA);


        } catch (Exception e) {
            
        }
    }
}
