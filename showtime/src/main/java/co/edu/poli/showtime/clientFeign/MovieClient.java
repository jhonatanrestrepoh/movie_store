package co.edu.poli.showtime.clientFeign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import co.edu.poli.common.response.Response;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "movie")
public interface MovieClient {

    @GetMapping("/api/v1/poli/movie/{id}")
    Response findById(@PathVariable("id") Long id);

}