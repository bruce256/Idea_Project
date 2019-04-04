package fel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 儒尊
 * @date 2017/05/18
 */
public class Foo {

	private int          size = 10;
	private String       name = "lvsheng";
	private List<String> list = new ArrayList<>();
	private Integer itemType;

	public Integer getItemType() {
		return itemType;
	}

	public Foo setItemType(Integer itemType) {
		this.itemType = itemType;
		return this;
	}

	public List<String> getList() {
		return list;
	}

	public Foo setList(List<String> list) {
		this.list = list;
		return this;
	}

	public int getSize() {
		return size;
	}

	public Foo setSize(int size) {
		this.size = size;
		return this;
	}

	public String getName() {
		return name;
	}

	public Foo setName(String name) {
		this.name = name;
		return this;
	}
}
