package crud;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import  javax.faces.bean.ManagedBean;//javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import crud.model.Costumer;

import javax.annotation.PostConstruct;

@SuppressWarnings("restriction")
@SessionScoped
@ManagedBean(name = "manageBean")
public class ManageBean implements Serializable {
    private static final long serialVersionUID = 1L;
	
	private Costumer item;
	private Costumer beforeEditItem;
    private List<Costumer> list;
    
    //DAO
    private CostumerDAO dao;
    
    private boolean editing;
    
    @PostConstruct
    public void init() {
    	dao = new CostumerDAO();
    	item = new Costumer();
        list = dao.list();
        
        if(list == null)
        	list = new ArrayList<Costumer>();
    }
    
    public void add() {
        list.add(item);
        dao.create(item);
        item = new Costumer();
    }
    
    public void resetAdd() {
        item = new Costumer();
    }
    
    public void edit(Costumer item) {
        beforeEditItem = new Costumer(item.getId(), item.getName(), item.getCpf());
        this.item = item;
        editing = true;
    }
    
    public void cancelEdit() {
        //this.item.restore(beforeEditItem);
        this.item = new Costumer();
        editing = false;
    }
    
    public void saveEdit() {
    	dao.edit(item);
        this.item = new Costumer();
        editing = false;
    }
    
    public void delete(Costumer item) throws IOException {
        list.remove(item);
        dao.remove(item);
    }
    
    public List<Costumer> getList() {
        return list;
    }
    
    public Costumer getItem() {
        return this.item;
    }
    
    public void setItem(Costumer item) {
        this.item = item;
    }
    
    public boolean isEditing() {
        return this.editing;
    }
}
