package com.unibosque.Funcionality;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.unibosque.Model.ResponseT;
import com.unibosque.Service.ProductServiceImpl;


@WebServlet(name = "FileUploadServlet", urlPatterns = { "/fileuploadservlet" })
@MultipartConfig(
  fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
  maxFileSize = 1024 * 1024 * 10,      // 10 MB
  maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class FileUploadServlet extends HttpServlet {

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
	String uploadPath = "C:\\Users\\jhrui\\Documents";
	File uploadDir = new File(uploadPath);
	if (!uploadDir.exists()) uploadDir.mkdir();
    /* Receive file uploaded to the Servlet from the HTML5 form */
    Part filePart = request.getPart("file");
    String fileName = filePart.getSubmittedFileName();
    for (Part part : request.getParts()) {
      part.write(uploadPath + "/" + fileName );
    }
    ProductServiceImpl prd = new ProductServiceImpl();
    prd.uploadCSV(uploadPath + "/" +fileName);
    ResponseT res = new ResponseT();
    res.Respuesta ="00";
    res.Mensaje = "Subida Completada";
	request.setAttribute("ResponseT", res);
	request.getRequestDispatcher("Productos.jsp").forward(request, response);
	}catch(Exception e) {
		
	}
  }


}
