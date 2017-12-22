package br.com.documentprocessing.test;

import java.util.List;

import br.com.documentprocessing.entity.UploadPermission;
import br.com.documentprocessing.jdbc.UploadPermissionDAO;

public class TestUploadPermissionDAO {

	public static void main(String[] args) {
				
		//testeCadastrarUploadPermission();
		testeBuscaTodosUploadPermission();
	}

	private static void testeCadastrarUploadPermission() {
		UploadPermission up = new UploadPermission();
		up.setName("Maria");
		up.setDoc_type("PDF");
		up.setDevice("Mobile");
		
		UploadPermissionDAO upDAO = new UploadPermissionDAO();
		upDAO.cadastrarUploadPermission(up);
	}
	
	private static void testeBuscaTodosUploadPermission(){
		UploadPermissionDAO upDAO = new UploadPermissionDAO();
		
		List<UploadPermission> listResult = upDAO.buscaTodosUploadPermission();
		
		for (UploadPermission u: listResult){
			System.out.println(u.getName() + " só pode enviar arquivos do tipo " 
		+ u.getDoc_type() + " através de um device " +u.getDevice()  );
		}
	}

}
