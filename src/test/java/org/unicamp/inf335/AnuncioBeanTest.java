package org.unicamp.inf335;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

class AnuncioBeanTest {

    @Test
    void getValor() throws MalformedURLException {
        ProdutoBean produto1 = new ProdutoBean("01", "Prod 1", "Prod 1", 100.0, "new");
        AnuncioBean anuncio1 = new AnuncioBean(produto1, new ArrayList<URL>(List.of(new URL("http://example.com"))), 10.0);
        assertEquals(90.0, anuncio1.getValor());

        ProdutoBean produto2 = new ProdutoBean("01", "Prod 1", "Prod 1", 100.0, "new");
        AnuncioBean anuncio2 = new AnuncioBean(produto2, new ArrayList<URL>(List.of(new URL("http://example.com"))), 0.0);
        assertEquals(100.0, anuncio2.getValor());
    }
}
