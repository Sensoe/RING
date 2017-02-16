package Sauvegarde;

import java.io.*;

public class Sauvegarde {

	private static String pathSauvegarde;
    public static final String REPERTOIRE_SAUVEGARDE = "sauvegardes/";
    public static final String COMBATTANTS = "combattants/";
    
    public Sauvegarde() throws FileNotFoundException, IOException{
        File repertoire =  new File("fichiers");
        if(!repertoire.exists()){
            repertoire.mkdir();
            File fichier = new File("fichiers/path.path");
            pathSauvegarde = repertoire.getAbsolutePath().replace("fichiers", REPERTOIRE_SAUVEGARDE);
            Writer write = new FileWriter(fichier);
            write.write(pathSauvegarde);
            write.flush();
            write.close();
        }
        else{
            pathSauvegarde = this.chargerPathSauvegarde();
        }
        File sauvegarde = new File(pathSauvegarde);
        if(!sauvegarde.exists()){
            sauvegarde.mkdir();
            File sauvegardeCombattants = new File(pathSauvegarde+COMBATTANTS);
            sauvegardeCombattants.mkdir();
        }
    }
    
    private String chargerPathSauvegarde() throws FileNotFoundException, IOException{
        File path = new File("fichiers/path.path");
        BufferedReader buff=new BufferedReader(new InputStreamReader(new FileInputStream(path)));
        String ligne = buff.readLine();
        buff.close();
        return ligne;
    }
    
    public static String getPathSauvegarde(){
        return pathSauvegarde;
    }
    
    public static String getPathSauvegardeCombattants(){
        return pathSauvegarde+COMBATTANTS;
    }
    
}
