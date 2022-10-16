package com.AJD.filemngt.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Attachment {



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String fileName;
    private String fileType;
    
    @Lob
    private byte[] data;
    
    private int productId;
    private int clientId;

    public Attachment() {
		super();
	
	}

    
    public Attachment( String fileName, String fileType, int productId, int clientId, byte[] data) {
		this.fileName = fileName;
		this.fileType = fileType;
		this.productId = productId;
		this.clientId = clientId;
		this.data = data;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}
}
