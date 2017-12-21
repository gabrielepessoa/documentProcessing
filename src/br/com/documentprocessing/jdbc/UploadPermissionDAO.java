package br.com.documentprocessing.jdbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Parameter;

import br.com.documentprocessing.entity.UploadPermission;
import br.com.documentprocessing.jdbc.Connection;

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
	
}
