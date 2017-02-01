package crud;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Access {
	private static String ip;
	private String user;
	private String password;
	protected String connectionString;
	
	/**
	 * 
	 */
	public Access(){
		Path path = Paths.get("C:\\Java\\dbconfig.cfg");
		if(Files.exists(path)){
			List<String> dados = null;
			try {
				dados = Files.readAllLines(path);
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(dados != null){
				if(dados.size() == 3){
					ip = dados.get(0);
					this.user = dados.get(1);
					this.password = dados.get(2);
				}
			}
		}
		
		if(!ip.isEmpty())
			connectionString = String.format("jdbc:sqlserver://%s;databaseName=teste_crud;", ip);
	}
	
	/**
	 * com.microsoft.sqlserver.jdbc.SQLServerDriver
	 */
	
	/**
	 * 
	 */
	protected String getIP(){
		return ip;
	}
	
	/**
	 * 
	 */
	protected String getUser(){
		return user;
	}
	
	/**
	 * 
	 */
	protected String getPassword(){
		return password;
	}
	
}
