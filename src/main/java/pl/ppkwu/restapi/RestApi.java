package pl.ppkwu.restapi;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import library1.FileDownloader;

@RestController
public class RestApi {

	@RequestMapping(value = "/download", params = {"url"})
	public HttpEntity<byte[]> downloadFile(@RequestParam("url") String url) {
		try {
			FileDownloader.downloadFile(url, "plik");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	 
}
