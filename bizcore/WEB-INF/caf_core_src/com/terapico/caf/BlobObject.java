package com.terapico.caf;

import java.util.HashMap;
import java.util.Map;

public class BlobObject {
	private String fileName;
	private String mimeType;
	private byte[] data;
	private Map<String, String> headers;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public Map<String, String> getHeaders() {
		if (headers == null) {
			headers = new HashMap<String, String>();
		}
		return headers;
	}

	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}

	public BlobObject addHeader(String name, String value) {
		getHeaders().put(name, value);
		return this;
	}

}
