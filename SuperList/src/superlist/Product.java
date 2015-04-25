package superlist;

/**
 *
 * @author simonemacri
 */
public class Product {

    public String name;
    public int qty;

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

    @Override
    public String toString() {
        return qty+" "+this.name;
    }

}
