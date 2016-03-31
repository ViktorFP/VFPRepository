package by.epamlab.beans;

import by.epamlab.annotations.Equal;

public class Bean2 {
	private int notCompare;
	@Equal(compareBy=Equal.DataType.REFERENCE)
	private String name;
	@Equal(compareBy = Equal.DataType.VALUE)
	private double anyNumber;

	public Bean2() {
		super();
	}

	public Bean2(int notCompare, String name, double anyNumber) {
		this.notCompare = notCompare;
		this.name = name;
		this.anyNumber = anyNumber;
	}	
}
