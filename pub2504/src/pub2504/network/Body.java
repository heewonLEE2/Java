package pub2504.network;

import java.util.List;

public class Body {
	
	private String dataType;
	private Items items;
	
	public Body() {
	}
	public Body(String dataType, Items items) {
		this.dataType = dataType;
		this.items = items;
	}
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public Items getItems() {
		return items;
	}
	public void setItems(Items items) {
		this.items = items;
	}
	@Override
	public String toString() {
		return "Body [dataType=" + dataType + ", items=" + items + "]";
	}
	
	
}
