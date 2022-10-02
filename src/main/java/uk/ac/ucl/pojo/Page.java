package uk.ac.ucl.pojo;

import java.util.List;

/**
 * Paging
 * @author huang-wt
 * @create 2022-09-24 18:54
 */
public class Page<T> {

    public static final Integer ITEMS_NUMBER_PER_PAGE = 4;
    private Integer pageNo;
    private Integer pagesTotalNumber;
    private Integer itemsNumberPerPage = ITEMS_NUMBER_PER_PAGE;
    private Integer itemsTotalNumber;
    private List<T> items;
    private String url;

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        if (pageNo < 1) {
            pageNo = 1;
        } else if (pageNo > pagesTotalNumber) {
            pageNo = pagesTotalNumber;
        }
        this.pageNo = pageNo;
    }

    public Integer getPagesTotalNumber() {
        return pagesTotalNumber;
    }

    public void setPagesTotalNumber(Integer pagesTotalNumber) {
        this.pagesTotalNumber = pagesTotalNumber;
    }

    public Integer getItemsNumberPerPage() {
        return itemsNumberPerPage;
    }

    public void setItemsNumberPerPage(Integer item_number_per_page) {
        this.itemsNumberPerPage = item_number_per_page;
    }

    public Integer getItemsTotalNumber() {
        return itemsTotalNumber;
    }

    public void setItemsTotalNumber(Integer itemsTotalNumber) {
        this.itemsTotalNumber = itemsTotalNumber;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", pagesTotalNumber=" + pagesTotalNumber +
                ", itemsNumberPerPage=" + itemsNumberPerPage +
                ", itemsTotalNumber=" + itemsTotalNumber +
                ", items=" + items +
                ", url='" + url + '\'' +
                '}';
    }
}
