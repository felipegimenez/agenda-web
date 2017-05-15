package controle;

import dao.ContatoDao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.ContatoModelo;

@ManagedBean(name="contatoBean")
@SessionScoped
public class ContatoBean implements Serializable
{
    
     private ContatoModelo contMode = new ContatoModelo();
     private ContatoDao contDao = new ContatoDao();
     private List<ContatoModelo> lista = new ArrayList<>(); 

    public ContatoBean() {
        
        busca();
    }
     
     

    public ContatoModelo getContMode() {
        return contMode;
    }

    public void setContMode(ContatoModelo contMode) {
        this.contMode = contMode;
    }

    public List<ContatoModelo> getLista() {
        return lista;
    }

    public void setLista(List<ContatoModelo> lista) {
        this.lista = lista;
    }

    public ContatoDao getContDao() {
        return contDao;
    }

    public void setContDao(ContatoDao contDao) {
        this.contDao = contDao;
    }

    public void salvarDados() {

        if (contMode.getId() == null) {
            contDao.salvar(contMode);
            contMode = new ContatoModelo();
            busca();
            
        } else {
            contDao.editar(contMode);
            contMode = new ContatoModelo();
            busca();
            

        }
    }

    public void busca() {

        lista = contDao.busca();

    }

    public void excluir(ContatoModelo c) {

        contMode = c;

        contDao.excluir(contMode);
        contMode = new ContatoModelo();
        busca();

    }

    public void editar(ContatoModelo c) {

        contMode = c; 
        

    }
    
     
        
}

    


