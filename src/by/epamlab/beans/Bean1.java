package by.epamlab.beans;

import by.epamlab.annotations.Equal;

public class Bean1 {
	@Equal(compareBy=Equal.DataType.VALUE)
	private String name;
	@Equal(compareBy=Equal.DataType.VALUE)
	private int anyNumber;

	public Bean1() {
		super();
	}

	public Bean1(String name, int anyNumber) {
		this.name = name;
		this.anyNumber = anyNumber;
	}

}
