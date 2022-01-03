package pagination;

import java.util.List;

public class Pagable<Element> {
	
	private List<Element> elements;
	
	private int totalPages;
	
	public Pagable() {
	}
	
	public Pagable(List<Element> elements, int totalPages) {
		this.elements = elements;
		this.totalPages = totalPages;
	}

	public List<Element> getElements() {
		return elements;
	}

	public void setElements(List<Element> elements) {
		this.elements = elements;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	
}
