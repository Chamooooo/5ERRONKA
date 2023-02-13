package pkg5erronka;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



    @XmlRootElement(name="EgunekoSalmentak")
    @XmlAccessorType(XmlAccessType.FIELD)
    public class EgunekoSalmentak {
    
        public EgunekoSalmentak(){

        }
    @XmlElement(name = "Salmenta")
    public Salmenta[]salmentak;
    
    public EgunekoSalmentak(ArrayList<Salmenta>sal){
        salmentak=new Salmenta[sal.size()];

        for(int i=0;i<sal.size();i++){
            salmentak[i]=sal.get(i);
        }
    }
}
