/**
 * Classe ListeTriee
 * @author Étienne André
 * @since 2021-11-12
 *
 */



public class ListeTriee{

    // Attribut de liste sous-jacente
    private Liste liste;
    
    public ListeTriee(Liste listevide){
	  // Affectation de la liste vide à l'attribut privé
	    liste = listevide;
    }
    
    /**
     * retourne la premiere place de la liste
     * @return tete de liste
     */
    public int tete(){

		  return this.liste.tete();

    }
	
    /**
     * permet de connaitre la place suivante dans la liste
     * @param p place en cours
     * @return place derriere p dans la liste
     */
    public int suc(int p){
		
		  return this.liste.suc(p);
		
    }
    
    /**
     * retourne la valeur associee a la place p
     * @param p place de la liste
     * @return la valeur associee  p
     */
    public String val(int p){
		  
      return this.liste.val(p);
      
    }
 
    /**
     * indique si la place p est a la fin de la liste ou non
     * @param p place de la liste
     * @return vrai si p est a la fin de la liste, faux sinon
     */   
    public boolean finliste(int p){

		  return this.liste.finliste(p);

    }
	
    
    /**
     * ajoute un element au bon endroit dans la liste triee
     * @param chaine element a inserer
     */
    
    public void adjlisT(String chaine){

        int p = tete();
        int precedent = -1;
        
        if (finliste(p)) {
            this.liste.adjtlis(chaine);
        }
        else{
          while (!finliste(p) && val(p).compareTo(chaine) < 0) {
            precedent = p;
            p = suc(p);
          }
          if (precedent == -1) {
            //On ajoute en tete de liste
            this.liste.adjtlis(chaine);
          }else {
            //On insere apres precedent
            this.liste.adjlis(precedent, chaine);
          }
        }  
      }

    /**
     * permet de supprimer un element d'une liste. Supprime le premier element dont la valeur est egale a "chaine" ; ne fait rien si "chaine" n'appartient pas a la liste.
     * @param chaine l'element a supprimer 
     */
    
    public void suplisT(String chaine){
      
      int p = tete();
      boolean sup=false;
      
      if(finliste(p)){
        return;
      }
      else{
        while(!finliste(p)&&!sup){
          if(val(p).equals(chaine)){
            this.liste.suplis(p);
            sup=true;
          }
          else{
            p=suc(p); 
          }
        }
      }
    }
}
