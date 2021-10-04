package com.unibosque.Service;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import com.google.gson.Gson;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.unibosque.Model.Response;
import com.unibosque.Model.User;

public class LoginServiceImpl {
	
	public LoginServiceImpl() {
		
	}
	
	public Response authCliente(User user) {
		 Response res = new Response();
		try {
		       URL ul1 = new URL("http://localhost:8080/api/users/name/" + user.getUsuario());

		       HttpURLConnection urlC = (HttpURLConnection) ul1.openConnection();
		       urlC.setRequestMethod("GET");

		       InputStream inputStream = urlC.getInputStream();
		       BufferedInputStream reader = new BufferedInputStream(inputStream);

		       int readerBuffer = reader.read();

		       String myJson = "";

		       while(readerBuffer != -1){
		                char u = (char) readerBuffer;
		                myJson += u;
		                readerBuffer = reader.read();
		       }

 		       reader.close();
		       inputStream.close();

		       JsonParser json = new JsonParser();
		       Gson gson = new Gson();
		       JsonObject jsonObj = json.parse(myJson).getAsJsonObject();
		       User userf = gson.fromJson(jsonObj, User.class);
		       
		       List<User> Listado = new ArrayList<User>();
		       Listado.add(userf);
		       
		       res.Respuesta = "00";
		       res.Mensaje = "Consulta Exitosa";
		       res.Listado = Listado;

		      
		  } catch (MalformedURLException ex) {
		            System.out.println(ex.getMessage());
		            res.Respuesta = "99";
				       res.Mensaje = "Error de MailformedURL";
				       res.Listado = null;
				   	return res;
		  } catch (IOException | NullPointerException ex) {
		            System.out.println(ex.getMessage());
		            res.Respuesta = "98";
				       res.Mensaje = "Error de IO";
				       res.Listado = null;
				   	return res;
				       
		  }
		return res;
	}

}
