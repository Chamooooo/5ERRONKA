package ariketi.erronki5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class kode1 {
    
    class Test {
    
            public static void main( String[] args ) {

                File archivo = null;
                FileReader fr = null;
                BufferedReader br = null;
                ArrayList<String>salmentak = new ArrayList<String>();
    
                String path = "C:/Users/ikaltamirapaag1/Desktop/baskulakofitxategiak";

                String[] files = getFiles( path );
                
                
    
                if ( files != null ) {
    
                    int size = files.length;
    
                    for ( int i = 0; i < size; i ++ ) {
                        try {
                            
                            fr = new FileReader (files[i]);
                            
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
                       
                        System.out.println(files[x].substring(54,files[x].indexOf('.')));

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
                    }
                }
            
           public static String[] getFiles( String dir_path ) {
    
                String[] arr_res = null;
    
                File f = new File( dir_path );
    
                if ( f.isDirectory( )) {
    
                    List<String> res   = new ArrayList<>();
                    File[] arr_content = f.listFiles();
    
                    int size = arr_content.length;
    
                    for ( int i = 0; i < size; i ++ ) {
    
                        if ( arr_content[ i ].isFile( )){
                            System.out.println(arr_content[i].getName());
                            res.add( arr_content[ i ].toString( ));
                        }
                        
                    }
    
                    arr_res = res.toArray( new String[ 0 ] );
    
                } else

                    System.err.println( "¡ Path NO válido !" );
    
                return arr_res;

            }
    } 


