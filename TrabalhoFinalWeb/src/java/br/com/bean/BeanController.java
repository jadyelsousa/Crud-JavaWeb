
package br.com.bean;

import br.com.dao.BebidaDAO;
import br.com.dao.CategoriaDAO;
import br.com.dao.UsuarioDAO;
import br.com.model.Bebida;
import br.com.model.Categoria;
import br.com.model.Usuario;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean(name="bean")
@SessionScoped
public class BeanController implements Serializable {
        
    private Usuario user;
    private UsuarioDAO userdao;
    private Categoria categoria;
    private CategoriaDAO categoriadao;
    private Bebida bebida;
    private BebidaDAO bebidadao;
    private ArrayList<Categoria> categorialist;
    private ArrayList<Bebida> bebidalist;

    public BeanController() {
        user= new Usuario();
        userdao = new UsuarioDAO();
        categoria = new Categoria();
        categoriadao = new CategoriaDAO();
        bebida = new Bebida();
        bebidadao = new BebidaDAO();
        categorialist = new ArrayList<>();
        bebidalist = new ArrayList<>();
        
        
    }

    public ArrayList<Bebida> getBebidalist() {
        return bebidalist;
    }

    public void setBebidalist(ArrayList<Bebida> bebidalist) {
        this.bebidalist = bebidalist;
    }

    public BebidaDAO getBebidadao() {
        return bebidadao;
    }

    public void setBebidadao(BebidaDAO bebidadao) {
        this.bebidadao = bebidadao;
    }

    public Bebida getBebida() {
        return bebida;
    }

    public void setBebida(Bebida bebida) {
        this.bebida = bebida;
    }

    public ArrayList<Categoria> getCategorialist() {
        return categorialist;
    }

    public void setCategorialist(ArrayList<Categoria> categorialist) {
        this.categorialist = categorialist;
    }

    public UsuarioDAO getUserdao() {
        return userdao;
    }

    public void setUserdao(UsuarioDAO userdao) {
        this.userdao = userdao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public CategoriaDAO getCategoriadao() {
        return categoriadao;
    }

    public void setCategoriadao(CategoriaDAO categoriadao) {
        this.categoriadao = categoriadao;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
    
    public String logar(){
        FacesMessage message = null;
        if (userdao.login(user)==true){
            HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            session.setAttribute("usuario", user);
            categorialist=categoriadao.selectCategoria();
            return "pages/home?faces-redirect=true";
        }
        else{
           FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login ou senha invalidos","Erro no Login!"));
            return null;
        }
        
    }
    public void sair() throws IOException{
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        FacesContext.getCurrentInstance().getExternalContext().redirect("../index.xhtml");
    }
    public void inserirUsuario(){
        userdao.novoUsuario(user);
        user=new Usuario();
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastrado com sucesso",""));
    }
    public void inserirCategoria(){
        categoriadao.novaCategoria(categoria);
        categoria=new Categoria();
        categorialist=categoriadao.selectCategoria();
    }
    public void inserirBebida(){
        bebidadao.novaBebida(bebida);
        bebida = new Bebida();
    }
    public void pesquisarBebida(){
        bebidalist=bebidadao.selectBebida(bebida);
        bebida = new Bebida();
        
    }
    
}
