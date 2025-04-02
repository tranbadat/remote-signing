package vn.com.dattb.coreservice.dto;

import lombok.Data;

/**
 * PageDto is the DTO class for pagination
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 2/10/2025
 * Version: 1.0.0
 * <p>
 * Description: PageDto is the DTO class for pagination
 */
@Data
public class PageDto<T> {
    private int page;
    private int size;
    private long total;
    private T data;

    public PageDto(int page, int size, long total, T data) {
        this.page = page;
        this.size = size;
        this.total = total;
        this.data = data;
    }

    public int getPage() {
        return page;
    }

    public int getSize() {
        return size;
    }

    public long getTotal() {
        return total;
    }

    public T getData() {
        return data;
    }

}
