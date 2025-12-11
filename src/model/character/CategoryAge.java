package model.character;

public enum CategoryAge {
	YOUNG(1),
	ADULT(2),
	OLD(3);

	private int value;
	
	CategoryAge(int i) {
		this.value = i;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public CategoryAge next() {
        CategoryAge[] vals = CategoryAge.values();
        int nextIndex = this.ordinal() + 1;
        
        if (nextIndex < vals.length) {
            return vals[nextIndex];
        }
        //si il est deja vieux, on fout la variable a null et on le dégageras dans la simulation
        return null;
	}
	
	public CategoryAge previous() {
        CategoryAge[] vals = CategoryAge.values();
        int prevIndex = this.ordinal() - 1;

        if (prevIndex >= 0) {
            return vals[prevIndex];
        }
        return this;
    }
}