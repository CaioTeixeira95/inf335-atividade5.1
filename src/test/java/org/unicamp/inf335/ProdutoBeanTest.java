package org.unicamp.inf335;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoBeanTest {
    @Test
    void testCompareTo() {
        ProdutoBean prod1 = new ProdutoBean("01", "Prod 1", "Prod 1", 10.55, "new");
        ProdutoBean prod2 = new ProdutoBean("02", "Prod 1", "Prod 1", 8.33, "new");
        ProdutoBean prod3 = new ProdutoBean("03", "Prod 1", "Prod 1", 9.0, "used");
        ArrayList<ProdutoBean> productList = new ArrayList<ProdutoBean>(List.of(prod1, prod2, prod3));

        Collections.sort(productList);

        ArrayList<ProdutoBean> expectedProductList = new ArrayList<ProdutoBean>(List.of(prod2, prod3, prod1));
        assertEquals(expectedProductList, productList);
    }
}