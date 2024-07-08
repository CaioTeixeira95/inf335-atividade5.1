package org.unicamp.inf335;

import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AnuncianteBeanTest {

    @Test
    void testAddAnuncio() throws MalformedURLException {
        AnuncianteBean anunciante = new AnuncianteBean();
        assertEquals(0, anunciante.getAnuncios().size());
        assertEquals(new ArrayList<AnuncioBean>(), anunciante.getAnuncios());

        ProdutoBean produto = new ProdutoBean("01", "Prod 1", "Prod 1", 100.0, "new");
        ArrayList<URL> urls = new ArrayList<URL>(List.of(new URL("http://example.com")));
        AnuncioBean anuncio = new AnuncioBean(produto, urls, 10.0);
        anunciante.addAnuncio(anuncio);
        assertEquals(1, anunciante.getAnuncios().size());
        assertEquals(List.of(anuncio), anunciante.getAnuncios());
    }

    @Test
    void testRemoveAnuncioEmptyAnuncios() {
        AnuncianteBean anunciante = new AnuncianteBean();
        anunciante.removeAnuncio(0);
    }

    @Test
    void testRemoveAnuncioIndexOutOfBounds() throws MalformedURLException {
        AnuncianteBean anunciante = new AnuncianteBean();
        ProdutoBean produto = new ProdutoBean("01", "Prod 1", "Prod 1", 100.0, "new");
        ArrayList<URL> urls = new ArrayList<URL>(List.of(new URL("http://example.com")));
        AnuncioBean anuncio = new AnuncioBean(produto, urls, 10.0);
        anunciante.addAnuncio(anuncio);
        assertThrows(IndexOutOfBoundsException.class, () -> anunciante.removeAnuncio(2));
    }

    @Test
    void testRemoveAnuncioRemovesAnuncioSuccessfully() throws MalformedURLException {
        AnuncianteBean anunciante = new AnuncianteBean();
        ProdutoBean produto = new ProdutoBean("01", "Prod 1", "Prod 1", 100.0, "new");
        ArrayList<URL> urls = new ArrayList<URL>(List.of(new URL("http://example.com")));
        AnuncioBean anuncio = new AnuncioBean(produto, urls, 10.0);
        anunciante.addAnuncio(anuncio);
        anunciante.removeAnuncio(0);
        assertTrue(anunciante.getAnuncios().isEmpty());
    }

    @Test
    void testValorMedioAnuncios() throws MalformedURLException {
        AnuncioBean anuncio1 = new AnuncioBean(new ProdutoBean("01", "Prod 1", "Prod 1", 100.0, "new"), new ArrayList<URL>(List.of(new URL("http://example.com"))), 1.0);
        AnuncioBean anuncio2 = new AnuncioBean(new ProdutoBean("02", "Prod 2", "Prod 2", 100.0, "new"), new ArrayList<URL>(List.of(new URL("http://example.com"))), 1.0);
        AnuncioBean anuncio3 = new AnuncioBean(new ProdutoBean("03", "Prod 3", "Prod 3", 100.0, "new"), new ArrayList<URL>(List.of(new URL("http://example.com"))), 1.0);

        AnuncianteBean anunciante = new AnuncianteBean();
        anunciante.addAnuncio(anuncio1);
        anunciante.addAnuncio(anuncio2);
        anunciante.addAnuncio(anuncio3);

        assertEquals(99.0, anunciante.valorMedioAnuncios());
    }
}