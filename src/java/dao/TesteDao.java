package dao;



import modelo.ContatoModelo;

public class TesteDao {

    public static void main(String[] args) {
        
    
    ContatoDao d = new ContatoDao();
    ContatoModelo m = new ContatoModelo();
    
    System.out.println(d);
    
    m.setNome("Mazy");
    m.setTelefone("7777-2222");
    m.setEmail("mazy@gmail.com");
        System.out.println(m.getNome());
        System.out.println(m.getTelefone());
        System.out.println(m.getEmail());
        System.out.println("");
     
    d.salvar(m);
    
    
    
    
    }}
