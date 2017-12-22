package br.com.documentprocessing.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Result;

import br.com.documentprocessing.entity.UploadPermission;

public class UploadPermissionDAO {

	private java.sql.Connection con = Connection.getConnection();
	
	public void cadastrarUploadPermission(UploadPermission uploadPermission){
		String sql = "INSERT INTO UPLOAD_PERMISSION (name, doc_type, device) values (?,?,?)";
		
		try {
			PreparedStatement p = con.prepareStatement(sql);
			p.setString(1, uploadPermission.getName());
			p.setString(2, uploadPermission.getDoc_type());
			p.setString(3, uploadPermission.getDevice());
			
			p.execute();
			p.close();
			
			System.out.println("Permissão cadastrada com sucesso para " + uploadPermission.getName() + "!");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public List<UploadPermission> buscaTodosUploadPermission(){
		String sql = "SELECT * "
				+ "FROM UPLOAD_PERMISSION ";	
		
		List<UploadPermission> list = new ArrayList<UploadPermission>();
		
		try {
			PreparedStatement p = con.prepareStatement(sql);
			ResultSet result = p.executeQuery();			
			
			while(result.next()){
				UploadPermission up = new UploadPermission();
				
				up.setId(result.getInt("id"));
				up.setName(result.getString("name"));
				up.setDoc_type(result.getString("doc_type"));
				up.setDevice(result.getString("device"));
				
				list.add(up);
			}
			
			p.close();
			System.out.println("Consulta de todas as permissões executada com sucesso! ");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	public void verificarUploadPermission(UploadPermission uploadPermission){
		String sql = "SELECT * "
				+ "FROM UPLOAD_PERMISSION "
				+ "WHERE name=?"
				+ "AND doc_type=?"
				+ "AND device=?" ;		
		try {
			PreparedStatement p = con.prepareStatement(sql);
			
			
			p.executeQuery();
			p.close();
			System.out.println("Permissão cadastrada com sucesso para " + uploadPermission.getName() + "!");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
