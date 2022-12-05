package rian.example.model;

import java.io.Serializable;

public class AppArsenalRequestModel implements Serializable {
	private static final long serialVersionUID = 6583265823414333531L;

	private String otherInfo;

	public String getOtherInfo() {
		return otherInfo;
	}

	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}

}
