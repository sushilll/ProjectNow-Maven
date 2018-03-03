package shop.pagination;

import java.util.List;

import shop.dto.ProductDto;

public class Pagination {
	private int currentPage;
	private List<ProductDto> list;
	private int maxResult;
	private int totalPages;
	private int maxNavigationPage;
	private List<Integer> navigationPages;
	
	public Pagination(int currentPage, List<ProductDto> list, int maxResult, int totalPages,
			int maxNavigationPage, List<Integer> navigationPages) {
		this.currentPage = currentPage;
		this.list = list;
		this.maxResult = maxResult;
		this.totalPages = totalPages;
		this.maxNavigationPage = maxNavigationPage;
		this.navigationPages = navigationPages;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public List<ProductDto> getList() {
		return list;
	}

	public void setList(List<ProductDto> list) {
		this.list = list;
	}

	public int getMaxResult() {
		return maxResult;
	}

	public void setMaxResult(int maxResult) {
		this.maxResult = maxResult;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getMaxNavigationPage() {
		return maxNavigationPage;
	}

	public void setMaxNavigationPage(int maxNavigationPage) {
		this.maxNavigationPage = maxNavigationPage;
	}

	public List<Integer> getNavigationPages() {
		return navigationPages;
	}

	public void setNavigationPages(List<Integer> navigationPages) {
		this.navigationPages = navigationPages;
	}
	
	
}
