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
import com.unibosque.Model.Detalle;
import com.unibosque.Model.Response;
import com.unibosque.Model.ResponseProduct;
import com.unibosque.Model.ResponseT;
import com.unibosque.Model.ResponseVentas;
import com.unibosque.Model.User;
import com.unibosque.Model.Venta;

public class VentasServiceImpl {
	
	public VentasServiceImpl() {
	
	}

	public Response readAllUsers() {
		 Response res = new Response();
			try {
			       URL ul1 = new URL("http://localhost:8080/api/users/");

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
			       User[] array = gson.fromJson(myJson, User[].class);
			       List<User> Listado = new ArrayList<User>();
			       for(User user : array) {
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
	
	public ResponseVentas createVenta(Venta venta, List<Detalle> detalle) {
		ResponseVentas res = new ResponseVentas();
			try {
			       Gson gson = new Gson();
			       URL ul1 = new URL("http://localhost:8080/api/ventas/");

			       HttpURLConnection urlC = (HttpURLConnection) ul1.openConnection();
			       urlC.setRequestMethod("POST");
			       urlC.setRequestProperty("Content-Type", "application/json; utf-8");
			       urlC.setRequestProperty("Accept", "application/json");
			       urlC.setDoOutput(true);
			       
			       String jsoninput = gson.toJson(venta);
			       
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
			       Venta ventad = gson.fromJson(jsonObj, Venta.class);
			       
			       if(urlC.getResponseCode() == 201) {
				       List<Venta> Listado = new ArrayList<Venta>();
				       Integer codventa = ventad.getCodigo()
;				       ResponseT res1 = createDetalle(detalle, codventa );
				       
				       if(res1.Respuesta == "00") {
				    	   res.Respuesta = "00";
					       res.Mensaje = "Creación Exitosa";
					       res.Listado = Listado;
				       }else {
				    	   res.Respuesta = "95";
					       res.Mensaje = "Creación Exitosa de Venta pero no de Detalle";
					       res.Listado = Listado;
				       }
				    
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
	
	
	public ResponseT createDetalle(List<Detalle> detalle, Integer codventa) {
		 ResponseT res =  new ResponseT();
		try {
				for (Detalle d : detalle) 
				{ 
				   d.setCodigo_venta(codventa.toString());
				}
		       Gson gson = new Gson();
		       URL ul1 = new URL("http://localhost:8080/api/detalle/");

		       HttpURLConnection urlC = (HttpURLConnection) ul1.openConnection();
		       urlC.setRequestMethod("POST");
		       urlC.setRequestProperty("Content-Type", "application/json; utf-8");
		       urlC.setRequestProperty("Accept", "application/json");
		       urlC.setDoOutput(true);
		       
		       String jsoninput = gson.toJson(detalle).replace("[", "").replace("]", "");
		       
		       try(OutputStream os = urlC.getOutputStream()) {
		    	    byte[] input = jsoninput.getBytes("utf-8");
		    	    os.write(input, 0, input.length);			
		    	}

		       if(urlC.getResponseCode() == 201) {
			       res.Respuesta = "00";
			       res.Mensaje = "Creación Exitosa";
		       }
		       else {
		    	   res.Respuesta = "98";
			       res.Mensaje = urlC.getResponseMessage();
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
	
}
