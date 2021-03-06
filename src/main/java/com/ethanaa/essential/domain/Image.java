package com.ethanaa.essential.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@MappedSuperclass
public abstract class Image extends AbstractAuditingEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Size(max = 50)
	@Column(name = "title", length = 50)
	private String title;
	
	@Size(max = 50)
	@Column(name = "alt_text", length = 50)	
	private String altText;
	
	@Size(max = 256)
	@Column(name = "description", length = 256)	
	private String description;
	
	@NotNull
	@Pattern(regexp = "^.*\\.(?:jpe?g|png|gif|bmp)$")
	@Column(name = "filepath", nullable = false)	
	private String filepath;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "image_type", nullable = false)
	private ImageType imageType;	
	
	public Image() {

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAltText() {
		return altText;
	}

	public void setAltText(String altText) {
		this.altText = altText;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public ImageType getImageType() {
		return imageType;
	}

	public void setImageType(ImageType imageType) {
		this.imageType = imageType;
	}
}
