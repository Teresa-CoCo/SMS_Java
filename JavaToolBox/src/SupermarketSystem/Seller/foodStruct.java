package SupermarketSystem.Seller;

public class foodStruct {
    //名字, 价格, 数量, 条码, 位置, 保质期, 上货人
    private String name;
    private double price;
    private int quantity;
    private String barcode;
    private String position;
    private int expiration;
    private String owner;

    public foodStruct(String name, double price, int quantity, String barcode, int expiration, String owner) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.barcode = barcode;
        this.position = "";
        this.expiration = expiration;
        this.owner = owner;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getExpiration() {
        return expiration;
    }

    public void setExpiration(int expiration) {
        this.expiration = expiration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }


    @Override
    public String toString() {
        return "foodStruct{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", barcode='" + barcode + '\'' +
                ", position='" + position + '\'' +
                ", expiration=" + expiration +
                ", owner='" + owner + '\'' +
                '}';
    }
    
}
