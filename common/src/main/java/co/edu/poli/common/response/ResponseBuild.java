package co.edu.poli.common.response;



import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import org.springframework.stereotype.Component;

@Component
public class ResponseBuild {

    public Response success(){
        return Response.builder().code(OK.value()).build();
    }

    public Response success(Object data){
        return Response.builder().code(OK.value()).data(data).build();
    }

    public Response failed(){
        return Response.builder().code(INTERNAL_SERVER_ERROR.value()).build();
    }

    public Response failed(Object data){
        return Response.builder().code(INTERNAL_SERVER_ERROR.value()).data(data).build();
    }
}
