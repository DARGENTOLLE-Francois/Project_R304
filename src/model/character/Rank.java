package model.character;

public enum Rank {
	ALPHA(10),
	BETA(9),
	GAMMA(8),
	DELTA(7),
	EPSILON(6),
	ZETA(5),
	ETA(4),
	KAPPA(3),
	LAMBDA(2),
	SIGMA(1),
	OMEGA(0);
	
	private int value;

	Rank(int i) {
		this.value = i;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Rank next() {
    	int nextValue = this.value + 1;
    	for (Rank r : Rank.values()) {
        	if (r.value == nextValue) {
            	return r;
        	}
    	}
    	return this;
	}

	public Rank previous() {
		int previousValue = this.value - 1;
		for (Rank r : Rank.values()) {
			if (r.value == previousValue) {
				return r;
			}
		}
		return this;
	}

}
