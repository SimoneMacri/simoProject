package superlist;

/**
 *
 * @author simonemacri
 */
public class Product {

    private String name;
    private int qty;
    private boolean done;

    /**
     * Costruttore vuoto.
     */
    public Product() {
    }

    /**
     * Costruttore personalizzato.
     *
     * @param name il nome del prodotto
     */
    public Product(String name) {
        this.name = name;
    }
    public Product(String name, int qty) {
        this.name = name;
        this.qty = qty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    
    @Override
    public String toString() {
        return qty+" "+this.name;
    }

}
