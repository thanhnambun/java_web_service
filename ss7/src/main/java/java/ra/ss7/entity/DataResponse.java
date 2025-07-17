package java.ra.ss7.entity;


import lombok.*;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DataResponse<T> {
    private T data;
    private HttpStatus status;
}
