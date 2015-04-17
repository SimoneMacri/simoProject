/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superlist;

/**
 *
 * @author Simone, Arturo, Davide, Tiziano, Hergys, Bogo, Andrea, Loris, Gabriele
 */
public class SuperList {

    /**
     * Ritorna l'indice dell'elemento article all'interno dell'array list. Se
     * l'elemento non esiste, ritorna -1.
     *
     * @param list l'array in cui cercare article.
     * @param article la stringa da cercare dentro la lista.
     * @return l'indice di article dentro list se esiste, altrimenti torna -1.
     */
    static int indexOf(String[] list, String article) {

        for (int i = 0; i < list.length; i++) {
            if (list[i].equalsIgnoreCase(article)) {
                return i;
            }
        }
        return -1aa;
    }

    /**
     * Ritorna la lista aggiornata con il nuovo articolo
     *
     * @param list l'array con gli articoli che verranno copiati nel nuovo array
     * con l'articolo nuovo
     * @param article il nuovo articolo aggiunto all'array
     * @return ritorna la lista aggiornata
     */
    static String[] addArticle(String[] list, String article) {

        String[] list2 = new String[list.length + 1];
        for(int i = 0; i < list.length; i++) {
            list2[i] = list[i];
        }
        list2[list2.length - 1] = article;
        return list2;
    }

    public static void main(String[] args) {

        String[] list = {"Carta", "Pane", "Latte", "Uova"};
        //System.out.println(indexOf(list, "Pane"));

        addArticle(list, "Vino");
        addArticle(list, "Acqua");

    }

}
