/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleacademico.model;

/**
 *
 * @author Double
 */
public class User {
    
    private int id;
    private String Nome;
    private String userName;
    private String password;
    private String role;
    
    public User(int id, String Nome, String userName, String password, String role) {
        this.id = id;
        this.Nome = Nome;
        this.userName = userName;
        this.password = password;
        this.role = role;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getNome() {
        return Nome;
    }
    
    public void setNome(String Nome) {
        this.Nome = Nome;
    }
    
    public String getUserName() {
        
        return userName;
    }
    
    public void setUserName(String userName) {
        if (userName.contains("")) {
            this.userName = userName.replace(" ", ".");
        }
        this.userName = userName;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getRole() {
        return role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }
    
}
