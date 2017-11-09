package bank.account.recordInfo;

import java.util.Map;

public class RecordInfo {
	private Map<Integer, String> map;
	private int count = 0;

	public RecordInfo(Map<Integer, String> map) {
		// TODO Auto-generated constructor stub
		this.map = map;
	}

	public Map<Integer, String> getMap() {
		return this.map;
	}
	
	public void add(String value){
		map.put(++count, value);
	}
	
	public int getCount() {
		return count;
	}
}
