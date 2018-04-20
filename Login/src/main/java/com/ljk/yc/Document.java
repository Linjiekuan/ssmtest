package com.ljk.yc;

public class Document  {

	private int id; //
	private String title; //
	private String filename; //
	//private MultipartFile file; //
	private String remark; //
	private java.util.Date createDate; //
	//private String username;
	private String user_id;
	/*public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
*/
	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	//
	public Document() {
		super();
		// TODO Auto-generated constructor stub
	}

	//
	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

	public String getFileName() {
		return filename;
	}

	public void setFileName(String filename) {
		this.filename = filename;
	}

	/*public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}
*/
	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}

	public java.util.Date getCreateDate() {
		return this.createDate;
	}
	@Override
	public String toString() {
		return "Document [id=" + id + ", title=" + title + ", fileName=" + filename  + ", remark="
				+ remark + ", createDate=" + createDate +"]";
	}

}