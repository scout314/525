package Service;

public class Page {
	
	private int totalRecord;//总记录
	
	private int currentpageNo;//当前的页码
	
	private int pageSize;//每页记录数

	public Page(int totalRecord, int currentpageNo, int pageSize) {
		super();
		this.totalRecord = totalRecord;
		this.currentpageNo = currentpageNo;
		this.pageSize = pageSize;
	}

	public int getFirst() {
		return 1;
	}
	
	public int getPrev() {
		if(this.currentpageNo > 1) {
			return this.currentpageNo - 1;
		}else {
			return this.currentpageNo;
		}
	}
	
	public int getLast() {
		return this.getTotalPage();
	}
	
	public int getTotalPage() {
		return this.totalRecord/this.pageSize+1;
	}
	
	public int getNext() {
		if(this.currentpageNo < this.getTotalPage()) {
			return this.currentpageNo+1;
		}else {
			return this.currentpageNo;
		}
		
	}
	
	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getCurrentpageNo() {
		return currentpageNo;
	}

	public void setCurrentpageNo(int currentpageNo) {
		this.currentpageNo = currentpageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	

}
