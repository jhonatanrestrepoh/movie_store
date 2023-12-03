package co.edu.poli.showtime.clientFeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import response.Response;

@FeignClient(name = "movie")
public interface MovieClient {

    @GetMapping("/api/v1/poli/movie/{id}")
    Response findById(@PathVariable Long id);

}
