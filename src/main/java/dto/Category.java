package dto;

public class Category {
    private int id;
    private String name;
    
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + "]";
	}
}
