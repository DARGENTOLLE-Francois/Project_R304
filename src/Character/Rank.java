package Character;

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
}
