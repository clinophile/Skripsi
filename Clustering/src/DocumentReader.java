/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author User-pc
 */
public class DocumentReader {
    public String folderpath;
    public List<Document> lstDoc;
    public int nCategory;
    
    public DocumentReader(String folderpath){
        this.folderpath = folderpath;
        this.lstDoc = new ArrayList<Document>();
    }
    
    public int getNumberofCategory(){
        return nCategory;
    }
    
    public void readDocuments() throws FileNotFoundException, IOException{
        lstDoc.clear();
        File folders = new File(this.folderpath);
        System.out.println(this.folderpath);
        nCategory = folders.list().length;
        String[] folderNames = new String[folders.list().length];
        File[] files = folders.listFiles();
        folderNames = folders.list();
                int id=0;
                for (File f : files) {
                    if (f.isFile() && f.getName().endsWith(".txt")) {
                    
                    BufferedReader in = new BufferedReader(new FileReader(f));
                    //System.out.println(f.getAbsolutePath());
                    String isidokumen = new String();
                    String s = null;
                    while((s = in.readLine()) != null){
                        isidokumen = isidokumen + (s+"\n");
                    }
                    id++;
                    System.out.println(f.getAbsolutePath());
                    //Document myDoc = new Document(id, f.getAbsolutePath(), sb.toString());
                    Document myDoc = new Document(id, f.getAbsolutePath(), isidokumen);                   
                    System.out.println(myDoc);
                    //myDoc.setKategori(folderName);
                    this.lstDoc.add(myDoc);
                
                }
        }
        System.out.println("\n---------------tf idf------------------------\n");
    }
    
    public List<Document> getListDocuments(){
        return this.lstDoc;
    }
}
