package pl.ppkwu.restapi;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import library1.FileDownloader;
import library1.ZIP;

@RestController
public class RestApi {

	@RequestMapping(value = "/download", params = {"url"})
	public HttpEntity<byte[]> downloadFile(@RequestParam("url") String url) {
		try {
			FileDownloader.downloadFile(url, "plik");
			byte[] readAllBytes = Files.readAllBytes(Paths.get("plik.txt"));
			return ResponseEntity
			          .ok()
			          .header("Content-Disposition", "attachement; filename=file.txt")
			          .body(readAllBytes);
		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/zip", params = {"url"})
	public HttpEntity<byte[]> zipFile(@RequestParam("url") String url) {
		try {
			ZIP.compressFile(url, "plik.zip");
			byte[] readAllBytes = Files.readAllBytes(Paths.get("plik.txt"));
			return ResponseEntity
			          .ok()
			          .header("Content-Disposition", "attachement; filename=file.txt")
			          .body(readAllBytes);
		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "uznip", method = RequestMethod.GET)
    public String unzip() {
        return "<form action=\"/unzip\" enctype=\"multipart/form-data\" method=\"post\">\n" +
                "  <input type=\"file\" name=\"file\">\n" +
                "  <input type=\"submit\">\n" +
                "</form>";
    }
	 
}
