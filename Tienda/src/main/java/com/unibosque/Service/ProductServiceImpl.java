package com.unibosque.Service;

import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FileUtils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.unibosque.Model.ResponseProduct;
import com.unibosque.Model.ResponseT;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import com.unibosque.Model.Product;

public class ProductServiceImpl {
	
	public ProductServiceImpl() {
	
	}

	
	
	
	public ResponseProduct readAllProducts() {
		ResponseProduct res = new ResponseProduct();
			try {
			       URL ul1 = new URL("http://localhost:8080/api/products/");

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
			       Product[] array = gson.fromJson(myJson, Product[].class);
			       List<Product> Listado = new ArrayList<Product>();
			       for(Product user : array) {
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
	
	public ResponseProduct getProduct(String codigo) {
		ResponseProduct res = new ResponseProduct();
	
			try {
			       URL ul1 = new URL("http://localhost:8080/api/products/" + codigo);

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
			       Product userf = gson.fromJson(jsonObj, Product.class);
			       
			       List<Product> Listado = new ArrayList<Product>();
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
	
	public ResponseProduct createProduct(Product user) {
		ResponseProduct res = new ResponseProduct();
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
			       Product userf = gson.fromJson(jsonObj, Product.class);
			       
			       if(urlC.getResponseCode() == 201) {
				       List<Product> Listado = new ArrayList<Product>();
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
	
	public ResponseProduct createProducts(List<Product> products) {
		ResponseProduct res = new ResponseProduct();
			try {
			       Gson gson = new Gson();
			       URL ul1 = new URL("http://localhost:8080/api/clients/");

			       HttpURLConnection urlC = (HttpURLConnection) ul1.openConnection();
			       urlC.setRequestMethod("POST");
			       urlC.setRequestProperty("Content-Type", "application/json; utf-8");
			       urlC.setRequestProperty("Accept", "application/json");
			       urlC.setDoOutput(true);
			       
			       String jsoninput = gson.toJson(products);
			       
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
			       Product userf = gson.fromJson(jsonObj, Product.class);
			       
			       if(urlC.getResponseCode() == 201) {
				       List<Product> Listado = new ArrayList<Product>();
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
	
	public void uploadCSV(String filepath) throws IOException {
		OkHttpClient client = new OkHttpClient().newBuilder()
				  .build();
				MediaType mediaType = MediaType.parse("text/csv");
				RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
				  .addFormDataPart("file","/C:/Users/jhrui/OneDrive/Documentos/productos.csv",
				    RequestBody.create(MediaType.parse("application/octet-stream"),
				    new File("/C:/Users/jhrui/OneDrive/Documentos/productos.csv")))
				  .build();
				Request request = new Request.Builder()
				  .url("http://localhost:8080/api/csv/upload")
				  .method("POST", body)
				  .build();
				Response response = client.newCall(request).execute();
				System.out.print(response.message());
	}
	
	public ResponseProduct updateProduct(Product user) {
		ResponseProduct res = new ResponseProduct();
			try {
			       Gson gson = new Gson();
			       URL ul1 = new URL("http://localhost:8080/api/clients/" + user.getCodigo());

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
			       Product userf = gson.fromJson(jsonObj, Product.class);
			       
			       if(urlC.getResponseCode() == 201) {
				       List<Product> Listado = new ArrayList<Product>();
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
	

	




}
