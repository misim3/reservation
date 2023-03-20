package dto;

public class DisplayInfoImage {
	private int id;
	private int dipalyInfoId;
	private int fileId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDipalyInfoId() {
		return dipalyInfoId;
	}
	public void setDipalyInfoId(int dipalyInfoId) {
		this.dipalyInfoId = dipalyInfoId;
	}
	public int getFileId() {
		return fileId;
	}
	public void setFileId(int fileId) {
		this.fileId = fileId;
	}
	@Override
	public String toString() {
		return "DisplayInfoImage [id=" + id + ", dipalyInfoId=" + dipalyInfoId + ", fileId=" + fileId + "]";
	}
}
