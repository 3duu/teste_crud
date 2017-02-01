package crud;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean
public class ManageBean {
	
	private Costumer item;
	private Costumer beforeEditItem;
    private List<Costumer> list;
    
    //DAO
    private CostumerDAO costumerDAO = new CostumerDAO();


    private boolean editing;
    
    //@PostConstruct
    public void init() {
        list = new ArrayList<Costumer>();
    }
    
    public void add() {
        // DAO save the add
        item.setId(list.isEmpty() ? 1 : list.get(list.size() - 1).getId() + 1);
        list.add(item);
        item = new Costumer();
    }
    
    public void resetAdd() {
        item = new Costumer();
    }
    
    public void edit(Costumer item) {
        beforeEditItem = new Costumer(item.getId(), item.geName(), item.getCpf());
        this.item = item;
        editing = true;
    }
    
    public void cancelEdit() {
        //this.item.restore(beforeEditItem);
        //this.item = new Student();
        editing = false;
    }
    
    public void saveEdit() {
        this.item = new Costumer();
        editing = false;
    }
    
    public void delete(Costumer item) throws IOException {
        list.remove(item);
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
