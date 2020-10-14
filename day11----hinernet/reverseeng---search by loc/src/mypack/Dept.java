package mypack;
// Generated Sep 28, 2020 9:52:28 PM by Hibernate Tools 3.2.2.GA

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Dept generated by hbm2java
 */
@Entity
@Table(name = "dept", catalog = "mydb")
public class Dept implements java.io.Serializable {

	private DeptId id;

	public Dept() {
	}

	public Dept(DeptId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "name", column = @Column(name = "Name", length = 30)),
			@AttributeOverride(name = "location", column = @Column(name = "Location", length = 50)) })
	public DeptId getId() {
		return this.id;
	}

	public void setId(DeptId id) {
		this.id = id;
	}

}