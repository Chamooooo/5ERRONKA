package pkg5erronka;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Main {

public static void main( String[] args ) { 

    ArrayList<String>salmentak = readFiles();

            }

public static ArrayList<String> readFiles(){

                File archivo = null;
                FileReader fr = null;
                BufferedReader br = null;
                ArrayList<String>salmentak = new ArrayList<String>();
    
                String path = "C:/Users/IKALTAMIRAPAAG1.ALTAMIRA/Desktop/baskulakofitxategiak";

                ArrayList<String> files = getFiles();
                
                
    
                if ( files != null ) {
    
                    int size = files.size();
    
                    for ( int i = 0; i < size; i ++ ) {
                        try {
                            
                            fr = new FileReader (files.get(i));
                            
                            br = new BufferedReader(fr);
                            String linea;
                            while((linea=br.readLine())!=null)
                            salmentak.add(linea);
                              
                         }
                         catch(Exception e){
                            e.printStackTrace();
                         }finally{
                           
                            try{                    
                               if( null != fr ){   
                                  fr.close();     
                               }                  
                            }catch (Exception e2){ 
                               e2.printStackTrace();
                            }
                         }
                         
                      }

                   }
                      int letra1=0;
                   
                      System.out.println("--------------------------------------");
                      for(int x=0;x<salmentak.size();x++){
                       
                        String listaTemp = salmentak.get(x);
                        File f = new File( path );
                        File[] arr_content = f.listFiles();
                        String idtemp = arr_content[x].getName();
                        System.out.println(idtemp.substring(0,idtemp.indexOf('.')));

                        for(int q=0;q<5;q++){
                           
                            try {
                                
                                System.out.println(listaTemp.substring(letra1,listaTemp.indexOf('$')));

                            } catch (Exception e) {

                                System.out.println(listaTemp);

                                System.out.println("--------------------------------------");

                            }
                    
                            listaTemp = listaTemp.substring(listaTemp.indexOf("$")+1);

                        }
                      }
                    return files;
                    
                    }
            
                
            
public static ArrayList<String> getFiles() {
    
                String dir_path = "C:/Users/IKALTAMIRAPAAG1.ALTAMIRA/Desktop/baskulakofitxategiak";

                String[] arr_res = null;

                ArrayList<String> res   = new ArrayList<>();
    
                File f = new File( dir_path );
    
                if ( f.isDirectory( )) {
    
                   
                    File[] arr_content = f.listFiles();
    
                    int size = arr_content.length;
    
                    for ( int i = 0; i < size; i ++ ) {
    
                        if ( arr_content[ i ].isFile( )){
                            System.out.println(arr_content[i].getName());
                            res.add( arr_content[ i ].toString( ));
                            
                        }
                        
                    }
    
                    arr_res = res.toArray( new String[ 0 ] );
    
                } else{

                }

                    
                return res;
            }
}
