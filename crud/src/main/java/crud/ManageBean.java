package crud;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean
public class ManageBean {
	private Carro carro = new Carro();
    private List<Carro> carros = new ArrayList<Carro>();

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public List<Carro> getCarros() {
        return carros;
    }

    public void setCarros(List<Carro> carros) {
        this.carros = carros;
    }
    

    public void adicionar(){
        if(this.carro != null)
            this.carros.add(this.carro);
        this.carro = new Carro();
    }
}
