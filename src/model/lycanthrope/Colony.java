package model.lycanthrope;

import model.character.*;

import java.util.ArrayList;
import java.util.List;

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
    }
}
