package com.samplemaven.jagacy.fields;

public class LabelField {
	
	private int row;
	
	private int column;
	
	private String labelText;
	
	public LabelField() {
		// Default Constructor
	}
	
	/**
	 * @param row
	 * @param column
	 * @param labelText
	 */
	public LabelField(int row, int column) {
		this.row = row;
		this.column = column;
	}

	/**
	 * @param row
	 * @param column
	 * @param labelText
	 */
	public LabelField(int row, int column, String labelText) {
		this.row = row;
		this.column = column;
		this.labelText = labelText;
	}

	/**
	 * @return the row
	 */
	public int getRow() {
		return row;
	}

	/**
	 * @param row the row to set
	 */
	public void setRow(int row) {
		this.row = row;
	}

	/**
	 * @return the column
	 */
	public int getColumn() {
		return column;
	}

	/**
	 * @param column the column to set
	 */
	public void setColumn(int column) {
		this.column = column;
	}

	/**
	 * @return the labelText
	 */
	public String getLabelText() {
		return labelText;
	}

	/**
	 * @param labelText the labelText to set
	 */
	public void setLabelText(String labelText) {
		this.labelText = labelText;
	}

}
