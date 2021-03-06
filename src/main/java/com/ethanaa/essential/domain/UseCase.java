package com.ethanaa.essential.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "T_USE_CASE")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class UseCase implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;	
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "category", nullable = false)
	private UseCaseCategory category;
	
	@Size(min = 1, max = 50)
	@Column(name = "name", length = 50, unique = true)	
	private String name;
	
	@Size(max = 256)
	@Column(name = "description", length = 256)	
	private String description;
	
	@OneToMany(mappedBy = "id.useCase", fetch = FetchType.LAZY)	
	private List<OilApplication> applications = new ArrayList<>();

	public UseCase(String name, String description, UseCaseCategory category) {
		
		this.name = name;
		this.description = description;
		this.category = category;
	}
	
	public UseCase() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UseCaseCategory getCategory() {
		return category;
	}

	public void setCategory(UseCaseCategory category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<OilApplication> getApplications() {
		return applications;
	}

	public void setApplications(List<OilApplication> applications) {
		this.applications = applications;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UseCase other = (UseCase) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
