package co.edu.poli.showtime.clientFeign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import co.edu.poli.common.response.Response;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@FeignClient(name = "movie")
public interface MovieClient {

    @GetMapping("/api/v1/poli/movie/{id}")
    Response findById(@PathVariable("id") Long id);

    @GetMapping("/api/v1/poli/movie/byIds")
    Response getMoviesByIds(@RequestParam List<Long> ids);

}