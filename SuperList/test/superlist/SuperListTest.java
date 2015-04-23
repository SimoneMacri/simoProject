/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superlist;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author andreaalbertini
 */
public class SuperListTest {

    @Test
    public void test_add_100_elementi() {
        Product[] expected = new Product[0];
        Product[] before = new Product[0];
        for (int i = 0; i < 100; i++) {
            expected = Arrays.copyOf(expected, i + 1);
            expected[i] = new Product("item" + i);
            Product[] after = SuperList.addArticle(before, expected[i].name);

            for (int j = 0; j < expected.length; j++) {
                assertTrue("Dopo l'inserimento la lista deve essere integra exp: " + Arrays.toString(expected) + " actual: " + Arrays.toString(after), expected[j].name.equals(after[j].name));
            }
            before = after;
        }
    }

    @Test
    public void testSaveList() throws Exception {
    }

    @Test
    public void testLoadList() throws Exception {
    }

    /**
     * Prova a rimuovere l'unico elemento presente nella lista.
     */
    @Test
    public void test_remove_unico_elemento() {
        Product[] expected = new Product[0];
        Product[] before = {new Product("item1")};
        Product[] after = SuperList.removeArticle(before, "item1");
        assertArrayEquals(expected, after);
    }

    /**
     * Prova a rimuovere un elemento da una lista vuota.
     */
    @Test
    public void test_remove_da_lista_vuota() {
        Product[] expected = new Product[0];
        Product[] before = new Product[0];
        Product[] after = SuperList.removeArticle(before, "item1");
        assertArrayEquals(expected, after);
    }

    /**
     * Prova a rimuovere un elemento che nella lista non è presente.
     */
    @Test
    public void test_remove_di_un_elemento_inesistente() {
        Product[] expected = {new Product("item1"), new Product("item2"), new Product("item3")};
        Product[] before = {new Product("item1"), new Product("item2"), new Product("item3")};
        Product[] after = SuperList.removeArticle(before, "item4");

        for (int j = 0; j < expected.length; j++) {
            assertTrue(j + " Dopo la rimozione di un elemento inesistente la lista deve essere inalterata  exp: " + Arrays.toString(expected) + " actual: " + Arrays.toString(after), expected[j].name.equals(after[j].name));
        }
    }

    /**
     * Prova a rimuovere un elemento fornendo il nome corretto ma con il caso
     * dei caratteri diverso dall'originale.
     */
    @Test
    public void test_remove_di_un_elemento_case_sensitive() {
        Product[] expected = {new Product("item1"), new Product("item3")};
        Product[] before = {new Product("item1"), new Product("item2"), new Product("item3")};
        Product[] after = SuperList.removeArticle(before, "iTeM2");
        for (int j = 0; j < expected.length; j++) {
            assertTrue(j + " dopo la rimozione di un elemento la lista deve essere cambiata exp: " + Arrays.toString(expected) + " actual: " + Arrays.toString(after), expected[j].name.equals(after[j].name));
        }
    }

    /**
     * Rimuove ripetutamente il primo elemento della lista.
     */
    @Test
    public void test_remove_100_elementi_dalla_testa() {
        Product[] expected = new Product[100];
        Product[] before = new Product[100];
        //preparo array
        for (int i = 0; i < 100; i++) {
            expected[i] = new Product("item" + i);
            before[i] = new Product("item" + i);
        }
        for (int i = 0; i < 100; i++) {
            Product[] after = SuperList.removeArticle(before, new String(expected[0].name));
            expected = Arrays.copyOfRange(expected, 1, expected.length);
            for (int j = 0; j < expected.length; j++) {
                assertTrue(j + " Dopo la rimozione la lista deve essere integra exp: " + Arrays.toString(expected) + " actual: " + Arrays.toString(after), expected[j].name.equals(after[j].name));
            }
            before = after;
        }
    }

    /**
     * Rimuove ripetutamente il l'ultimo elemento della lista.
     */
    @Test
    public void test_remove_100_elementi_dalla_coda() {
        Product[] expected = new Product[100];
        Product[] before = new Product[100];
        //preparo array
        for (int i = 0; i < 100; i++) {
            expected[i] = new Product("item" + i);
            before[i] = new Product("item" + i);
        }

        for (int i = 99; i >= 0; i--) {
            Product[] after = SuperList.removeArticle(before, new String(expected[i].name));
            expected = Arrays.copyOfRange(expected, 0, expected.length - 1);
            for (int j = 0; j < expected.length; j++) {
                assertTrue(j + " Dopo la rimozione la lista deve essere integra exp: " + Arrays.toString(expected) + " actual: " + Arrays.toString(after), expected[j].name.equals(after[j].name));
            }
            before = after;
        }
    }

}
