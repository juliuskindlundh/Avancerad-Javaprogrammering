package inlupp_streams_julius_kindlundh;

public class MyObject {

	private String name;
	private int value;
	private boolean bool;
	
	MyObject(String name, int value, boolean bool){
		this.name = name;
		this.value = value;
		this.bool = bool;
	}
	
	public String toString() {
		return name + " "+ value + " "+ bool;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public boolean getBool() {
		return bool;
	}

	public void setBool(boolean bool) {
		this.bool = bool;
	}
}
