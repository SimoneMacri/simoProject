package superlist;

/**
 *
 * @author simonemacri
 */
public class Product {

    public String name;

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

    @Override
    public String toString() {
        return this.name;
    }

}
