package crud;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import crud.model.Costumer;

import javax.annotation.PostConstruct;

@SessionScoped
@ManagedBean(name = "manageBean")
public class ManageBean implements Serializable {
    private static final long serialVersionUID = 1L;
	
	private Costumer item = new Costumer();
	private Costumer beforeEditItem;
    private List<Costumer> list;
    
    //DAO
    private CostumerDAO dao;


    private boolean editing;
    
    @PostConstruct
    public void init() {
    	dao = new CostumerDAO();
        list = dao.list();
        
        if(list == null)
        	list = new ArrayList<Costumer>();
    }
    
    public void add() {
        // DAO save the add
        //item.setId(list.isEmpty() ? 1 : list.get(list.size() - 1).getId() + 1);
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
    
    public boolean isEditing() {
        return this.editing;
    }
}
