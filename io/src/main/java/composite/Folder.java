package composite;

import java.util.ArrayList;
import java.util.List;

public class Folder extends Node{
	private List<Node> nodes; // Folder는 Node를 여러개 가진다.
	
	public Folder(String name) {
		super(name);
		nodes = new ArrayList<>();
	}
	
	public void add(File file) {
		nodes.add(file);
	}
	
	public void add(Folder folder) {
		nodes.add(folder);
	}

	@Override
	public long getSize() {
		long total = 0L;
		for(int i = 0; i < nodes.size(); i++) {
			total = total + nodes.get(i).getSize();
		}
		return total;
	}

	@Override
	public boolean isFolder() {
		return false;
	}
	
	
	
}
