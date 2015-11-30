package pl.ppkwu.restapi;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestApi {

	@RequestMapping(value = "/download", params = {"url"})
	public HttpEntity<byte[]> downloadFile(@RequestParam("url") String url) {
		return null;
	}
}
