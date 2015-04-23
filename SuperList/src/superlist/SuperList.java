/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superlist;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

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
    static int indexOf(Product[] list, String article) {

        for (int i = 0; i < list.length; i++) {
            if (list[i].name.equalsIgnoreCase(article)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Ritorna la lista aggiornata con il nuovo articolo
     *
     * @param list l'array con gli articoli che verranno copiati nel nuovo array
     * con l'articolo nuovo
     * @param article il nuovo articolo aggiunto all'array
     * @return ritorna la lista aggiornata
     */
    static Product[] addArticle(Product[] list, String article) {
        Product art = new Product();
        art.name = article;
        Product[] list2 = new Product[list.length + 1];
        for (int i = 0; i < list.length; i++) {
            list2[i] = list[i];
        }
        list2[list2.length - 1] = art;
        return list2;
    }

    /**
     *      * Carica la lista dal fine, se il file non esiste, ritorna una lista di
     * dimensione 0
     *
     * @param f file path del percorso
     * @return un array di stringhe oppure un array di dimensione 0 se il file
     * non esiste
     *
     * @throws FileNotFoundException
     *
     */
    public static Product[] loadList(File f) throws IOException {

        Product list[] = new Product[0];
        DataInputStream dis = null;

        try {
            dis = new DataInputStream(new FileInputStream(f));

            while (dis.available() > 0) {
                String product = dis.readUTF();
                list = addArticle(list, product);
            }
        } catch (FileNotFoundException e) {

        } finally {
            if (dis != null) {
                dis.close();
            }
        }

        return list;
    }

    public static void saveList(File file, Product[] list) throws IOException, FileNotFoundException {
        DataOutputStream dos = null;

        try {
            dos = new DataOutputStream(new FileOutputStream(file));
            for (int i = 0; i < list.length; i++) {
                dos.writeUTF(list[i].name);
            }

        } finally {
            if (dos != null) {
                dos.close();
            }
        }

    }

    /**
     *
     * Interpreta una riga di comando (line) fornite dall'utente e se corretta
     * esegue il comando, esempi di comandi:
     * <ul>
     * <li>add panes</li>
     * <li>remove pane</li>
     * <li>list</li>
     * <li>clear</li>
     * <li>help</li>
     * </ul>
     *
     * @param line La riga di comando che verrà interpretata
     * @throws IOException nel caso che ci siao un errore nella lettura del file
     * @throws IOException nel caso che la linea non abbia tutti i comandi
     * richiesti
     */
    public static void parseLine(File f, String line) throws IOException, NoSuchElementException, FileNotFoundException {
        Product[] list = loadList(f);
        Scanner scan = new Scanner(line);
        switch (scan.next()) {
            case "add":
                list = addArticle(list, scan.nextLine().trim());
                saveList(f, list);
                break;
            case "remove":
                list = removeArticle(list, scan.nextLine().trim());
                saveList(f, list);
                break;
            case "list":
                printList(list);
                break;
            case "clear":
                saveList(f, new Product[0]);
                break;
            case "help":
                printHelp();
                break;
            case "quit":
                System.exit(0);
                break;
            default:
                System.out.println("Comando non trovato\n");
                printHelp();
                break;

        }

    }

    /**
     * Metodo che crea la pagina di Help
     */
    public static void printHelp() {
        System.out.println("HELP:\n"
                + "-add <articolo>\t\taggiunge <articolo> dalla list\n"
                + "-remove <articolo>\trimuove <articolo dalla lista\n"
                + "-list\t\t\tmostra la lista di tutti gli articoli\n"
                + "-clear\t\t\telimina tutti gli elementi della lista\n"
                + "-help\t\t\tmostra questa schermata");
    }

    /**
     * Stampa gli elementi della lista list.
     *
     * @param list La lista contenente gli elementi da stampare.
     */
    public static void printList(Product[] list) {
        for (int i = 0; i < list.length; i++) {
            System.out.println("-> " + list[i].name);
        }
    }

    /**
     * Ritorna una nuova lista contenente i prodotti di list meno il prodotto.
     * article.
     *
     * @param list
     * @param article
     * @return
     */
    public static Product[] removeArticle(Product[] list, String article) {
        int indexToBeRemoved = indexOf(list, article);
                                           // trovo l'indice di article dentro a list.
        // se esiste (>=0)
        if (indexToBeRemoved >= 0) {            //Controllo se l'elemento da rimuovere esiste.
            Product[] temp = new Product[list.length - 1]; //Creo il nuovo array temporaneo
            int pos = 0;
            for (int i = 0; i < list.length; i++) {     // Lettura arrayList
                if (indexToBeRemoved != i) {                // Se indexToBeRemoved è diverso da i effettua la copia.
                    temp[pos] = list[i];
                    pos++;
                }

            }
            return temp;                               // Ritorna l'Array con l'elemento rimosso.
        }
        return list;                                   // Ritorna l'Array list originale.
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        File f = new File("list.dat");
        try {
            do {
                try {
                    System.out.print("SuperList# >");
                    parseLine(f, in.nextLine());
                } catch (NoSuchElementException e) {
                    System.out.println("Comando non valido");
                }
            } while (true);
        } catch (IOException e) {
            System.out.println("Errore nel accesso del file");
        } finally {
            in.close();
        }
    }

}

