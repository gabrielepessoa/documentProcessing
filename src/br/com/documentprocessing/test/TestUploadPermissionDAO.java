package br.com.documentprocessing.test;

import br.com.documentprocessing.entity.UploadPermission;
import br.com.documentprocessing.jdbc.UploadPermissionDAO;

public class TestUploadPermissionDAO {

	public static void main(String[] args) {
				
		UploadPermission up = new UploadPermission();
		up.setName("Maria");
		up.setDoc_type("PDF");
		up.setDevice("Mobile");
		
		UploadPermissionDAO upDAO = new UploadPermissionDAO();
		upDAO.cadastrarUploadPermission(up);
	}

}
