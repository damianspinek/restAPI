package pl.ppkwu.restapi;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestApi {

	public HttpEntity<byte[]> downloadFile(@RequestParam("url") String url) {
		return null;
	}
}
