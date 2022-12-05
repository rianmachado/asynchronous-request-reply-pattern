package rian.example.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "Arsenal")
@NamedQuery(name = "Arsenal.findAll", query = "SELECT arsenal FROM AppArsenalEntity arsenal ORDER BY arsenal.otherInfo")
public class AppArsenalEntity{

	@Id
	@SequenceGenerator(name = "apparsenalSequence", sequenceName = "apparsenal_id_seq", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "apparsenalSequence")
	private Long id;

	@Column(length = 40, unique = true)
	private String otherInfo;

	
	@Column(name = "created_at", nullable = false, updatable = false)
	private LocalDateTime createdAt;

	@Column(name = "modified_at", nullable = false)
	private LocalDateTime modifiedAt;

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

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(LocalDateTime modifiedAt) {
		this.modifiedAt = modifiedAt;
	}
	
	

}
