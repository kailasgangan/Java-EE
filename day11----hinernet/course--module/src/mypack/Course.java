package mypack;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity
public class Course 
{
   int id;
   String Name;
   Set<Module> Modules;
   
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   @Column(name="Course_id")
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}

public void setModules(Set<Module> Modules) 
{
	this.Modules = Modules;
}

@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
@JoinColumn(name="Cid",referencedColumnName="Course_id")
@Column(name="Modules")
public Set<Module> getModules()
{
	return Modules;
}

@Override
public String toString() {
	return "Course [id=" + id + ", Name=" + Name + ", Modules=" + Modules + "]";
}
}
