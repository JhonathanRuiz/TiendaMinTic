package com.unibosque.Service;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.unibosque.Model.ResponseClient;
import com.unibosque.Model.Client;

public class ClientServiceImpl {
	
	public ClientServiceImpl() {
	
	}

	public ResponseClient readAllClients() {
		ResponseClient res = new ResponseClient();
			try {
			       URL ul1 = new URL("http://localhost:8080/api/clients/");

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

			       Gson gson = new Gson();
			       Client[] array = gson.fromJson(myJson, Client[].class);
			       List<Client> Listado = new ArrayList<Client>();
			       for(Client user : array) {
			    	   Listado.add(user);
			    	}
			       
			       
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
	public ResponseClient getClient(String cedula) {
		ResponseClient res = new ResponseClient();
	
			try {
			       URL ul1 = new URL("http://localhost:8080/api/clients/" + cedula);

			       HttpURLConnection urlC = (HttpURLConnection) ul1.openConnection();
			       urlC.setRequestMethod("GET");

			       if(urlC.getResponseCode() == 200) {
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
			       Client userf = gson.fromJson(jsonObj, Client.class);
			       
			       List<Client> Listado = new ArrayList<Client>();
			       Listado.add(userf);
			       
			       res.Respuesta = "00";
			       res.Mensaje = "Consulta Exitosa";
			       res.Listado = Listado;
			       }else if(urlC.getResponseCode() == 404 ){
			    	     res.Respuesta = "96";
					       res.Mensaje = "No encontrado";
					       res.Listado = null;
					       return res;
			       }
			      
			  } catch (MalformedURLException ex) {
			            System.out.println(ex.getMessage());
			            res.Respuesta = "99";
					       res.Mensaje = "Error de MailformedURL";
					   	return res;
			  } catch (IOException | NullPointerException ex) {
			            System.out.println(ex.getMessage());
			            res.Respuesta = "98";
					       res.Mensaje = "Error de IO";
					   	return res;
					       
			  }
			return res;
	}
	
	public ResponseClient createClient(Client user) {
		ResponseClient res = new ResponseClient();
			try {
			       Gson gson = new Gson();
			       URL ul1 = new URL("http://localhost:8080/api/clients/");

			       HttpURLConnection urlC = (HttpURLConnection) ul1.openConnection();
			       urlC.setRequestMethod("POST");
			       urlC.setRequestProperty("Content-Type", "application/json; utf-8");
			       urlC.setRequestProperty("Accept", "application/json");
			       urlC.setDoOutput(true);
			       
			       String jsoninput = gson.toJson(user);
			       
			       try(OutputStream os = urlC.getOutputStream()) {
			    	    byte[] input = jsoninput.getBytes("utf-8");
			    	    os.write(input, 0, input.length);			
			    	}
			       
		
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

			       JsonObject jsonObj = json.parse(myJson).getAsJsonObject();
			       Client userf = gson.fromJson(jsonObj, Client.class);
			       
			       if(urlC.getResponseCode() == 201) {
				       List<Client> Listado = new ArrayList<Client>();
				       Listado.add(userf);
				       
				       res.Respuesta = "00";
				       res.Mensaje = "Creación Exitosa";
				       res.Listado = Listado;
			       }
			       else {
			    	   res.Respuesta = "98";
				       res.Mensaje = urlC.getResponseMessage();
				       res.Listado = null; 
			       }
			      
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
	
	public ResponseClient updateClient(Client user) {
		ResponseClient res = new ResponseClient();
			try {
			       Gson gson = new Gson();
			       URL ul1 = new URL("http://localhost:8080/api/clients/" + user.getCedula());

			       HttpURLConnection urlC = (HttpURLConnection) ul1.openConnection();
			       urlC.setRequestMethod("PUT");
			       urlC.setRequestProperty("Content-Type", "application/json; utf-8");
			       urlC.setRequestProperty("Accept", "application/json");
			       urlC.setDoOutput(true);
			       
			       String jsoninput = gson.toJson(user);
			       
			       try(OutputStream os = urlC.getOutputStream()) {
			    	    byte[] input = jsoninput.getBytes("utf-8");
			    	    os.write(input, 0, input.length);			
			    	}
			       
		
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

			       JsonObject jsonObj = json.parse(myJson).getAsJsonObject();
			       Client userf = gson.fromJson(jsonObj, Client.class);
			       
			       if(urlC.getResponseCode() == 201) {
				       List<Client> Listado = new ArrayList<Client>();
				       Listado.add(userf);
				       
				       res.Respuesta = "00";
				       res.Mensaje = "Actualización Exitosa";
				       res.Listado = Listado;
			       }
			       else {
			    	   res.Respuesta = "98";
				       res.Mensaje = urlC.getResponseMessage();
				       res.Listado = null; 
			       }
			      
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
	
	public ResponseClient deleteClient(String cedula) {
		ResponseClient res = new ResponseClient();
			try {
			       URL ul1 = new URL("http://localhost:8080/api/clients/" + cedula);

			       HttpURLConnection urlC = (HttpURLConnection) ul1.openConnection();
			       urlC.setRequestMethod("DELETE");

			 
			       
			       int responseCode = urlC.getResponseCode();
			     
			       if(responseCode == 200) {
			    	    res.Respuesta = "00";
					    res.Mensaje = "Eliminado Exitoso";
					    res.Listado = null;
			       }else if (responseCode == 404) {
			    	   res.Respuesta = "99";
					    res.Mensaje = "No encontrado";
					    res.Listado = null;
			       }
			       else {
			    	   res.Respuesta = "98";
					    res.Mensaje = urlC.getResponseMessage();
					    res.Listado = null;
			    	   
			       }
			       
			   
			      
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
