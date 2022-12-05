package rian.example.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class RequestOperationModel {
	public String guid;
	@JsonInclude(Include.NON_NULL)
	public Integer status;
	@JsonInclude(Include.NON_NULL)
	public String urlRedirect;

	public RequestOperationModel(String guid, int status, String urlRedirect) {
		this.guid = guid;
		this.status = status;
		this.urlRedirect = urlRedirect;
	}

	public RequestOperationModel(String guid) {
		this.guid = guid;
	}

	public RequestOperationModel() {
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getUrlRedirect() {
		return urlRedirect;
	}

	public void setUrlRedirect(String urlRedirect) {
		this.urlRedirect = urlRedirect;
	}
	
	
}