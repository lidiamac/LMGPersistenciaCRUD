package br.com.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class UserDAO {
	
	public UserDAO() {

	}
	
	public void adicionarUsuario(User u) {
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		
		try {
			PreparedStatement p = con.prepareStatement("insert into users (nome, email, pais) values (?, ?, ?)");
			p.setString(1, u.getNome());
			p.setString(2, u.getEmail());
			p.setString(3, u.getPais());
			System.out.println(p);
			p.executeUpdate();
			System.out.println("Comando executado");
			p.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<User> mostrarUsuarios(){
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		ArrayList<User> usuarios = new ArrayList<User>();
		try {
			PreparedStatement p = con.prepareStatement("select * from users");
			ResultSet r = p.executeQuery();			
			
			while (r.next()) {
				Integer id = r.getInt("id");
				String nome = r.getString("nome");
				String email = r.getString("email");
				String pais = r.getString("pais");
				User u = new User(nome, email, pais);
				u.setId(id);
				usuarios.add(u);
			}
			r.close();
			p.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usuarios;
	}
	
	
	public void removerUsuario(Integer id) {
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		
		try {
			PreparedStatement p = con.prepareStatement("delete from users where id = ?");
			p.setInt(1, id);
			System.out.println(p);
			p.executeUpdate();
			System.out.println("Comando executado");
			p.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//public void updateUser(Integer id, String newName) {
	public void alterarUsuario(User updateUser) {
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		
		try {
			PreparedStatement p = con.prepareStatement("update users set nome = ?, email = ?, pais = ? where id = ?");
			p.setString(1, updateUser.getNome());
			p.setString(2, updateUser.getEmail());
			p.setString(3, updateUser.getPais());
			p.setInt(4, updateUser.getId());
			
			System.out.println(p);
			p.executeUpdate();
			System.out.println("Comando executado");
			p.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	
	public User buscarUsuario(Integer id) {
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		User u = null;
		try {
			PreparedStatement p = con.prepareStatement("select * from users where id = ?");
			p.setInt(1, id);
			ResultSet r = p.executeQuery();			
			
			
			while (r.next()) {
				Integer id2 = r.getInt("id");
				String nome = r.getString("nome");
				String email = r.getString("email");
				String pais = r.getString("pais");
				u = new User(nome,email,pais);
				u.setId(id2);
			}
			r.close();
			p.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}
	

}
