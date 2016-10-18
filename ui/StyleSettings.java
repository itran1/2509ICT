package ui;

public class StyleSettings {
	
	private String defaultFont;
	private int defaultSize;
	
	public StyleSettings() {
		this.defaultFont = "Calibri";
		this.defaultSize = 14;
	}
	
	public String getDefaultFont() {
		return new String(this.defaultFont);
	}
	
	public int getDefaultSize() {
		return this.defaultSize;
	}

}
