package ss5.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JacksonXmlRootElement(localName = "response")
public class DataResponse<T> {

    @JsonProperty("data")
    private T data;

    @JsonProperty("status")
    private HttpStatus status;

    public DataResponse(T data, HttpStatus status) {
        this.data = data;
        this.status = status;
    }
}
