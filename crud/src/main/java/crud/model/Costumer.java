package crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity(name = "costumers")
@Table(name = "costumers")
public class Costumer {
 
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
 
    @Column(name = "name")
    private String name;
 
 
    @Column(name = "cpf")
    private String cpf;
 
    public Costumer() {
    	
    }
 
    public Costumer(int id, String name, String cpf) {
        this.setId(id);
        this.setName(name);
        this.setCpf(cpf);
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
