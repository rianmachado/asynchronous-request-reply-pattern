package rian.example.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class AppArsenalResponseModel implements Serializable {
	private static final long serialVersionUID = -4661784289660158948L;
	@JsonInclude(Include.NON_NULL)
	private Long id;
	@JsonInclude(Include.NON_NULL)
	private String otherInfo;
	@JsonInclude(Include.NON_NULL)
	private String urlOperationStatus;

	@Override
	public String toString() {
		return "AppArsenalResponseModel [id=" + id + ", otherInfo=" + otherInfo + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOtherInfo() {
		return otherInfo;
	}

	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}

	public String getUrlOperationStatus() {
		return urlOperationStatus;
	}

	public void setUrlOperationStatus(String urlOperationStatus) {
		this.urlOperationStatus = urlOperationStatus;
	}

}
