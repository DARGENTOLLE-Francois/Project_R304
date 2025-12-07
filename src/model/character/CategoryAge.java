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
	
}
