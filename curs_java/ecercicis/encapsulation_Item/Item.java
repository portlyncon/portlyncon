package curs_java.ecercicis.encapsulation_Item;

public class Item {

    public String name;
    public String description;
    public Integer precio;

    /**
     * Metode constructor de la classe, inicialitzem les variables
     */

    public Item(String name, String description, Integer precio) {

        this.name = name;
        this.description = description;
        this.precio = precio;

    }

    public boolean equals(Object o) {

        boolean isEqual = false;
        if (o instanceof Item) {
            Item it = (Item) o;
            isEqual = (this.name) == (((Item) o).getName());
        }
        return isEqual;
    }

    public String getName() {
        return this.name;
    }

    public Integer getPrice() {
        return this.precio;
    }

}
