package ra.ss10.entity.dto.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class DataErrorResponse <T>{
    private String message;
    private HttpStatus status;
    private T data;

}
