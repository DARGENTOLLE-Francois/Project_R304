package model.lycanthrope;

import model.character.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Colony {
	private List<Pack> packs;
	private List<FantasticCreaturesLycanthropes> solitaries; // j'ai un doute sur celle la

	public Colony() {
        this.packs = new ArrayList<>();
        this.solitaries = new ArrayList<>();
    }
	public void addPack(Pack p) {
        this.packs.add(p);
    }
	public void manageSolitaries() {
		//TODO
		//Il s'agit du maitre de zoo fantastique qui peut bouger les solitaires (chef de clan)
    }
	public List<Pack> getPacks() {
        return packs;
    }

    public void fastForwardTime(int years) {
        // ToDo : avancer le temps dans la colinie pour faire vieillir les lycanthropes , à voir avec la simulation du controleur
    	//vieillir les loups/ réévaluer la hiérarchie/ générer hurlement au pif/ transformer en humain
    	
    	//penser a faire un thread pour le temps
    	Random rand = new Random();
    	for (Pack packs : getPacks()) {
    		for (FantasticCreaturesLycanthropes member : packs.getMembers()){
    			// vieillir
    			if(rand.nextInt(50) < 20) {
    				member.setCategoryAge(member.getCategoryAge().next());
    			}
    			// générer hurlement (changer les hurlements et/ou la fonction howl)
    			if(rand.nextInt(50) < 20) {
    				member.howl(null);
    			}
    			// changer en humain
    			if(rand.nextInt(50) < 5) {
    				member.transformationHuman();
    				packs.removeMember(member);
    			}
    		}
    		packs.recalculateHierarchy();
    	}
    }
}