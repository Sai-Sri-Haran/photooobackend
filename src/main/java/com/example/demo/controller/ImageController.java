package com.example.demo.controller;
import java.awt.image.BufferedImage;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ImageModel;
import com.example.demo.model.RequestModel;
import com.example.demo.repository.ImageRepository;

@CrossOrigin
@RestController
public class ImageController {	
	@Autowired
    ImageRepository imageRepository;
	
	@PostMapping("/api/uploadimage/")
	public String  uploadImage(@RequestBody RequestModel image_url, HttpServletResponse response) throws IOException{
		ImageModel  i= new ImageModel();
		i.setImage_url(image_url.getImage_url());
		System.out.println(i.getImage_url());
		imageRepository.save(i);
		/*
		 * String str=image_url.getImage_url(); String base64Image = str.split(",")[1];
		 * byte[] imageBytes =
		 * javax.xml.bind.DatatypeConverter.parseBase64Binary(base64Image);
		 * BufferedImage img = ImageIO.read(new ByteArrayInputStream(imageBytes)); File
		 * pathFile = new
		 * File("/home/saisriharan/Downloads/downloads/"+System.currentTimeMillis()+
		 * ".jpg"); ImageIO.write(img,"jpg", pathFile);
		 * 
		 * 
		 * HttpHeaders headers = new HttpHeaders(); headers.add("Cache-Control",
		 * "no-cache, no-store, must-revalidate"); headers.add("Pragma", "no-cache");
		 * headers.add("Expires", "0"); InputStreamResource resource = new
		 * InputStreamResource(new FileInputStream(pathFile));
		 */

	    return "Uploaded Succesfully";
		/*
		 * System.out.println(img); File outputfile = new File("image.png");
		 * ImageIO.write(img, "png", outputfile);
		 */
		
		/* InputStream in =getClass() .getResourceAsStream("outpt"); */
		/*
		 * public @ResponseBody byte[] getImage() throws IOException { InputStream in =
		 * getClass() .getResourceAsStream("/com/baeldung/produceimage/image.jpg");
		 * return IOUtils.toByteArray(in); }
		 */
		  }
		/*
		 * byte[] name = Base64.getEncoder().encode(str.getBytes()); HttpHeaders headers
		 * = new HttpHeaders(); headers.setContentType(MediaType.IMAGE_JPEG);
		 * headers.setContentLength(name.length);
		 */
		
	
	@GetMapping("/api/image/") 
	public List<ImageModel> text() {
		return imageRepository.findAll();
	}
	@GetMapping("api/enhance")
	public String enhance(@RequestBody RequestModel image_url, HttpServletResponse response) throws IOException{
		ImageModel  var= new ImageModel();
		var.setImage_url(image_url.getImage_url());
		String str=image_url.getImage_url();
			
		return str	;}
	@PostMapping("/api/download")
	public ResponseEntity<InputStreamResource>  downloadimage(@RequestBody RequestModel image_url, HttpServletResponse response) throws IOException{		
		
		ImageModel  var= new ImageModel();
		var.setImage_url(image_url.getImage_url());
		String str=image_url.getImage_url();
		String base64Image = str.split(",")[1];
		byte[] imageBytes = javax.xml.bind.DatatypeConverter.parseBase64Binary(base64Image);
		BufferedImage img = ImageIO.read(new ByteArrayInputStream(imageBytes));
		File pathFile = new File("/home/saisriharan/Downloads/downloads/"+System.currentTimeMillis()+".jpg");
		ImageIO.write(img,"jpg", pathFile);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add("Pragma", "no-cache");
		headers.add("Expires", "0");
		InputStreamResource resource = new InputStreamResource(new FileInputStream(pathFile));

		return ResponseEntity.ok()
				.headers(headers)
				.contentLength(pathFile.length())
				.contentType(MediaType.APPLICATION_OCTET_STREAM)
				.body(resource);
		}
	
	/*
	 * Long uploadImage(@RequestParam MultipartFile multipartImage) throws
	 * Exception{ ImageModel dbImage =new ImageModel();
	 * dbImage.setImage_url(multipartImage.getBytes()); return
	 * imageRepository.save(dbImage) .getImage_id(); }
	 */

}
