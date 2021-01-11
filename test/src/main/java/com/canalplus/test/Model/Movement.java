package com.canalplus.test.Model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MOVEMENT")
public class Movement implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "MOVEMENT_ID", updatable = false, nullable = false)
	private long id;
	
	@Column(name = "MODIFICATION_TYPE")
	private String modification_type;
	
	@Column(name = "MODIFICATION_DATE")
	private Date modification_date;
	
	@Column(name = "OLD_VALUE")
	private String old_value;
	
	@Column (name = "NEW_VALUE")
	private String new_value;
	
	@Column(name = "SUBSCRIBER_ID")
	private Long subscriber_id;
	
	@ElementCollection
	@Column (name = "SUBSCRIPTIONS")
	private Set<Long> subscriptions_id;

	public Movement() {
		super();
	}

	public Movement(long id, String modification_type,
			Date modification_date, String old_value, String new_value, Long subscriber_id, Set<Long> subscriptions_id) {
		super();
		this.id = id;
		this.modification_type = modification_type;
		this.modification_date = modification_date;
		this.old_value = old_value;
		this.new_value = new_value;
		this.subscriber_id = subscriber_id;
		this.subscriptions_id = subscriptions_id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Long getSubscriberId() {
		return subscriber_id;
	}

	public void setSubscriber(Long subscriber_id) {
		this.subscriber_id = subscriber_id;
	}

	public Set<Long> getSubscriptions() {
		return subscriptions_id;
	}

	public void setSubscription(Set<Long> subscriptions_id) {
		this.subscriptions_id = subscriptions_id;
	}

	public String getModification_type() {
		return modification_type;
	}

	public void setModification(String modification_type) {
		this.modification_type = modification_type;
	}

	public Date getModification_date() {
		return modification_date;
	}

	public void setModification_date(Date modification_date) {
		this.modification_date = modification_date;
	}

	public String getOld_value() {
		return old_value;
	}

	public void setOld_value(String old_value) {
		this.old_value = old_value;
	}

	public String getNew_value() {
		return new_value;
	}

	public void setNew_value(String new_value) {
		this.new_value = new_value;
	}

	@Override
	public String toString() {
		return "Movement [id=" + id 
				+ ", modification_type=" + modification_type + ", modification_date=" + modification_date + ", old_value="
				+ old_value + ", new_value=" + new_value + "]";
	}
	
	
	
	
	
	
	
	
	

}
