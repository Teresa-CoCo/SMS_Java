package functions;

public class DiscountSystem {
    //TODO: 搭建一个折扣系统，能够根据用户的购买历史记录，计算出用户的折扣率（1次购物-10%，以此类推，到50%封顶，到50%后折扣固定为15%）
    public static double calculateDiscount(int historyCount) {
        if (historyCount == 1) {
            return 0.9;
        } else if (historyCount == 2) {
            return 0.8;
        } else if (historyCount == 3) {
            return 0.7;
        } else if (historyCount == 4) {
            return 0.6;
        } else if (historyCount == 5) {
            return 0.5;
        } else if (historyCount > 5) {
            return 0.75;
        } else {
            return 1;
        }
    }
}
