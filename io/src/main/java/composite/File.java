package composite;

public class File extends Node{
	private long size;
	
	public File(String name, long size) {
		super(name);
		this.size = size;
	}

	@Override
	public long getSize() {
		return this.size;
	}

	@Override
	public boolean isFolder() {
		return false;
	}
	
	
}
