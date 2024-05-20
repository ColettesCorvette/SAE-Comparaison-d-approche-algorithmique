/**
 * Classe principale de la SAÉ
 * @author Étienne André Sergueï Lenglet
 * @since 2021-11-04
 *
 */


public class Principale{

    private static final String[] ELEMENTS_DE_DEBUT
	= {"ABITEBOUL", "ADLEMAN", "AL-KINDI", "ALUR", "BERNERS-LEE",
	"BOOLE", "BUCHI", "BUTLER", "CLARKE", "CURRY"};
    private static final String[] ELEMENTS_DE_FIN
	= {"RABIN", "RIVEST", "SHAMIR", "SIFAKIS", "TORVALDS",
	"TURING", "ULLMAN", "VALIANT", "WIRTH", "YAO"};
    
    // NOTE: pour fichier 10 000
    // 	private static final String[] ELEMENTS_DE_DEBUT_SUPPR
    // = {"ABBADI", "ABERGEL", "ALIAS", "ALIOUI", "AKKUS", "ALAZARD",
    // "ALLA", "AIDARA", "ABRANTES", "AARAB"};
    // NOTE: pour fichier 1 000
    //private static final String[] ELEMENTS_DE_DEBUT_SUPPR
    // = {"ABADIE", "ABDALLAH", "ABRAHAM", "ADAM", "AFONSO",
    // "ALBERT", "ALEXANDRE", "ALI", "ALIX", "ALLAIN"};
    // NOTE: pour fichier 10 000
    //private static final String[] ELEMENTS_DE_FIN_SUPPR
    // = {"WEIS", "ZANIN", "WERQUIN", "YAGOUBI", "WERNERT",
    // "WAWRZYNIAK", "ZULIANI", "ZAIRE", "WAVRANT", "VILLAR"}; //
    // NOTE: pour fichier 1 000
    //private static final String[] ELEMENTS_DE_FIN_SUPPR
    //= {"WEBER", "WEISS", "WINTERSTEIN", "WOLFF", "YANG",
    //"YILDIRIM", "YILDIZ", "YILMAZ", "ZIEGLER", "ZIMMERMANN"}; //
	
    // Type des listes, peut etre utile pour factoriser les tests
    private static final int CONTIGUE	       = 1;
    private static final int CHAINEE	       = 2;
    private static final int CHAINEE_PLIBRES   = 3;
	
    // Exemple d'utilisation de LectureFichier et remplissage d'une liste
    public static void remplir_liste(ListeTriee liste, String nom_fichier){
	LectureFichier lf = new LectureFichier(nom_fichier);
	String[] liste_noms = lf.lireFichier();
	for (int i = 0; i < liste_noms.length; i++) {
	    liste.adjlisT(liste_noms[i]);
	}
    }


    

    public static double remplir_listeTempsExeDebut(ListeTriee liste, String nom_fichier){
        LectureFichier lf = new LectureFichier(nom_fichier);
        
        
        String[] liste_noms = lf.lireFichier();

        long debutD = System.nanoTime();

        for (int i = 0; i < ELEMENTS_DE_DEBUT.length; i++) {
            liste.adjlisT(ELEMENTS_DE_DEBUT[i]);
        }
        long finD = System.nanoTime();

        long dureeD = finD-debutD;

        return dureeD;
    
        }

        
    public static double remplir_listeTempsExeFin(ListeTriee liste, String nom_fichier){
        LectureFichier lf = new LectureFichier(nom_fichier);
        
        
        String[] liste_noms = lf.lireFichier();
        long debutF = System.nanoTime();
        for (int i = 0; i < ELEMENTS_DE_FIN.length; i++) {
            liste.adjlisT(ELEMENTS_DE_FIN[i]);
        }
        long finF = System.nanoTime();

        long dureeF= finF-debutF;

        return dureeF;
    
        }


        public static double vider_listeTempsExeDebut(ListeTriee liste, String nom_fichier){
            LectureFichier lf = new LectureFichier(nom_fichier);
            
            
            String[] liste_noms = lf.lireFichier();
            long debutD = System.nanoTime();
            for (int i = 0; i < ELEMENTS_DE_DEBUT.length; i++) {
                liste.suplisT(ELEMENTS_DE_DEBUT[i]);
            }
            long finD = System.nanoTime();
    
            long dureeD= finD-debutD;
    
            return dureeD;
        
            }
    
            
        public static double vider_listeTempsExeFin(ListeTriee liste, String nom_fichier){
            LectureFichier lf = new LectureFichier(nom_fichier);
            
            
            String[] liste_noms = lf.lireFichier();
            long debutF = System.nanoTime();
            for (int i = 0; i < ELEMENTS_DE_FIN.length; i++) {
                liste.suplisT(ELEMENTS_DE_FIN[i]);
            }
            long finF = System.nanoTime();
    
            long dureeF= finF-debutF;
    
            return dureeF;
        
        }

        public static double fois100AjDebut(ListeTriee liste, String nom_fichier){

            double moyenne=0;

            for(int i = 0;i<100;i++){
                
                moyenne+=remplir_listeTempsExeDebut(liste, nom_fichier);
                            
            }

            moyenne+=moyenne/100;
            return moyenne;
        }

        public static double fois100AjFin(ListeTriee liste, String nom_fichier){
            double moyenne=0;

            for(int i = 0;i<100;i++){
                
                moyenne+=remplir_listeTempsExeFin(liste, nom_fichier);
                            
            }

            moyenne+=moyenne/100;
            return moyenne;
        }

        public static double fois100SupDebut(ListeTriee liste, String nom_fichier){
            double moyenne=0;

            for(int i = 0;i<100;i++){
                
                moyenne+=vider_listeTempsExeDebut(liste, nom_fichier);
                            
            }

            moyenne+=moyenne/100;
            return moyenne;
        }

        public static double fois100SupFin(ListeTriee liste, String nom_fichier){
            double moyenne=0;

            for(int i = 0;i<100;i++){
                
                moyenne+=vider_listeTempsExeFin(liste, nom_fichier);
                            
            }

            moyenne+=moyenne/100;
            return moyenne;
        }


       
	
    public static void main(String [] args){
	System.out.println("Bienvenue !");
    
    ListeChainee lCee = new ListeChainee(10001);
    ListeContigue lC = new ListeContigue(10001);
    ListeChaineePlacesLibres lCeePl = new ListeChaineePlacesLibres(10001);

    ListeTriee lT1 = new ListeTriee(lCee);
    ListeTriee lT2 = new ListeTriee(lC);
    ListeTriee lT3 = new ListeTriee(lCeePl);
    
    //remplir_liste(lT1, "noms10000.txt");
    //remplir_liste(lT2, "noms10000.txt");
    //remplir_liste(lT3, "noms10000.txt");
    
    /* 
    System.out.println("AdjlisT debut d'alphabet :");
    System.out.println();
    System.out.println("Lecture de adjlisT sur une liste chainee  : "+remplir_listeTempsExeDebut(lT1, "noms10000.txt")+" ns");
    System.out.println("Lecture de adjlisT sur une liste contigue : "+remplir_listeTempsExeDebut(lT2, "noms10000.txt")+" ns");
    System.out.println("Lecture de adjlisT sur une liste chainee avec places libres : "+remplir_listeTempsExeDebut(lT3, "noms10000.txt")+" ns");
    
    System.out.println();
    System.out.println();

    System.out.println("AdjlisT fin d'alphabet : ");
    System.out.println();
    System.out.println("Lecture de adjlisT sur une liste chainee : "+remplir_listeTempsExeFin(lT1, "noms10000.txt")+" ns");
    System.out.println("Lecture de adjlisT sur une liste contigue : "+remplir_listeTempsExeFin(lT2, "noms10000.txt")+" ns");
    System.out.println("Lecture de adjlisT sur une liste chainee avec places libres : "+remplir_listeTempsExeFin(lT3, "noms10000.txt")+" ns");
    
    System.out.println();
    System.out.println();

    System.out.println("SuplisT debut d'alphabet :");
    System.out.println();
    System.out.println("Lecture de suplisT sur une liste chainee  : "+vider_listeTempsExeDebut(lT1, "noms10000.txt")+" ns");
    System.out.println("Lecture de suplisT sur une liste contigue : "+vider_listeTempsExeDebut(lT2, "noms10000.txt")+" ns");
    System.out.println("Lecture de suplisT sur une liste chainee avec places libres : "+vider_listeTempsExeDebut(lT3, "noms10000.txt")+" ns");
    
    System.out.println();
    System.out.println();

    System.out.println("SuplisT fin d'alphabet : ");
    System.out.println();
    System.out.println("Lecture de suplisT sur une liste chainee : "+vider_listeTempsExeFin(lT1, "noms10000.txt")+" ns");
    System.out.println("Lecture de suplisT sur une liste contigue : "+vider_listeTempsExeFin(lT2, "noms10000.txt")+" ns");
    System.out.println("Lecture de suplisT sur une liste chainee avec places libres : "+vider_listeTempsExeFin(lT3, "noms10000.txt")+" ns");
    */

    
    /* 
    for(int i = 0;i<1;i++){
        System.out.print(lCee);
        System.out.println();
        System.out.print(lC);
        System.out.println();
        System.out.print(lCeePl);
    }
    */
    
    String fichier = "noms10000.txt";

System.out.println("Chainee : "+fois100AjDebut(lT1, fichier)+" ns");
System.out.println("Contigue : "+fois100AjDebut(lT2, fichier)+" ns");
System.out.println("ChaineePL : "+fois100AjDebut(lT3, fichier)+" ns");

System.out.println("Chainee : "+fois100AjFin(lT1, fichier)+" ns");
System.out.println("Contigue : "+fois100AjFin(lT2, fichier)+" ns");
System.out.println("ChaineePL : "+fois100AjFin(lT3, fichier)+" ns");

System.out.println("Chainee : "+fois100SupDebut(lT1, fichier)+" ns");
System.out.println("Contigue : "+fois100SupDebut(lT2, fichier)+" ns");
System.out.println("ChaineePL : "+fois100SupDebut(lT3, fichier)+" ns");

System.out.println("Chainee : "+fois100SupFin(lT1, fichier)+" ns");
System.out.println("Contigue : "+fois100SupFin(lT2, fichier)+" ns");
System.out.println("ChaineePL : "+fois100SupFin(lT3, fichier)+" ns");

    /* 
	
	EcritureFichier fichier = new EcritureFichier("resultats.csv");
	fichier.ouvrirFichier();
	fichier.ecrireLigne("liste;operation;emplacement;duree");

    fichier.ecrireLigne("chainee;ajout;debut;"+remplir_listeTempsExeDebut(lT1, "noms10000.txt"));
    fichier.ecrireLigne("contigue;ajout;debut;"+remplir_listeTempsExeDebut(lT2, "noms10000.txt"));
    fichier.ecrireLigne("chaineePL;ajout;debut;"+remplir_listeTempsExeDebut(lT3, "noms10000.txt"));

    fichier.ecrireLigne("chainee;ajout;fin;"+remplir_listeTempsExeFin(lT1, "noms10000.txt"));
    fichier.ecrireLigne("contigue;ajout;fin;"+remplir_listeTempsExeFin(lT2, "noms10000.txt"));
    fichier.ecrireLigne("chaineePL;ajout;fin;"+remplir_listeTempsExeFin(lT3, "noms10000.txt"));

    fichier.ecrireLigne("chainee;suppression;debut;"+vider_listeTempsExeDebut(lT1, "noms10000.txt"));
    fichier.ecrireLigne("contigue;suppression;debut;"+vider_listeTempsExeDebut(lT2, "noms10000.txt"));
    fichier.ecrireLigne("chaineePL;suppression;debut;"+vider_listeTempsExeDebut(lT3, "noms10000.txt"));

    fichier.ecrireLigne("chainee;suppression;fin;"+vider_listeTempsExeFin(lT1, "noms10000.txt"));
    fichier.ecrireLigne("contigue;suppression;fin;"+vider_listeTempsExeFin(lT2, "noms10000.txt"));
    fichier.ecrireLigne("chaineePL;suppression;fin;"+vider_listeTempsExeFin(lT3, "noms10000.txt"));


	fichier.fermerFichier();
    */

    }
}
