package service.dto;

public class HobbyDTO {
	private int[] hobbyId;
	private String title;
	private String mbti;
	
	public HobbyDTO() {
		super();
	}

	public int[] getHobbyId() {
		return hobbyId;
	}

	public void setHobbyId(int[] hobbyId) {
		this.hobbyId = hobbyId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMbti() {
		return mbti;
	}

	public void setMbti(String mbti) {
		this.mbti = mbti;
	}

	@Override
	public String toString() {
		return "HobbyDTO [hobbyId=" + hobbyId + ", title=" + title + ", mbti=" + mbti + "]";
	}
	
	
}
