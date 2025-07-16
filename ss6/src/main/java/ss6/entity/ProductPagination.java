package ss6.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@NoArgsConstructor
@Data
@AllArgsConstructor
public class ProductPagination {
    private List<Product> products;
    private int totalPage;
    private int pageSize;
    private int currentPage;
}
