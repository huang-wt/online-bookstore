package uk.ac.ucl.pojo;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Taobang
 * @create 2022-09-25 14:42
 */
public class Cart {

    private Integer totalCount = 0;
    private BigDecimal totalPriceAmount = new BigDecimal(0);
    private Map<Integer, CartItem> items = new LinkedHashMap<>();

    public void addItem(CartItem cartItem) {
        CartItem item = items.get(cartItem.getId());

        // Check if the item already exists in Cart
        if (item == null) {
            items.put(cartItem.getId(), cartItem);
            totalCount += cartItem.getCount();
            totalPriceAmount = totalPriceAmount.add(cartItem.getTotalPriceAmount());
        } else {
            item.setCount(item.getCount() + 1);
            totalCount += 1;
            item.setTotalPriceAmount(item.getPrice().multiply(new BigDecimal(item.getCount())));
            totalPriceAmount = totalPriceAmount.add(item.getPrice());
        }
    }

    public void deleteItem(Integer id) {
        CartItem item = items.get(id);
        if (item != null) {
            totalCount -= item.getCount();
            totalPriceAmount = totalPriceAmount.subtract(item.getTotalPriceAmount());
        }
        items.remove(id);

    }

    public void clear() {
        totalCount = 0;
        totalPriceAmount = totalPriceAmount = new BigDecimal(0);
        items.clear();
    }

    public void updateCount(Integer id, Integer count) {
        CartItem item = items.get(id);

        // Check if the item already exists in Cart
        if (item != null) {
            totalCount += count - item.getCount();
            totalPriceAmount = totalPriceAmount.add(item.getPrice().multiply(new BigDecimal(count - item.getCount())));
            item.setCount(count);
            item.setTotalPriceAmount(item.getPrice().multiply(new BigDecimal(item.getCount())));

        }
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public BigDecimal getTotalPriceAmount() {
        return totalPriceAmount;
    }

    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + totalCount +
                ", totalPriceAmount=" + totalPriceAmount +
                ", items=" + items +
                '}';
    }
}
