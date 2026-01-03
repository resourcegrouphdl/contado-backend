package com.motos.contado.contado_backend.views;

import com.motos.contado.contado_backend.persistence.entity.Product;
import com.motos.contado.contado_backend.service.ProductService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Route(value = "inventario", layout = MainView.class)
public class InventarioView extends VerticalLayout {

    private final ProductService productService;

    @Autowired
    public InventarioView(ProductService productService) {
        this.productService = productService;

        setPadding(true);
        setSpacing(true);

        H3 title = new H3("Inventario");
        add(title);

        List<Product> products = productService.findAll();
        if (products.isEmpty()) {
            products = mockProducts();
        }

        FlexLayout cardsContainer = new FlexLayout();
        cardsContainer.setFlexWrap(FlexLayout.FlexWrap.WRAP);
        cardsContainer.setWidthFull();
        cardsContainer.getStyle().set("gap", "16px");

        for (Product p : products) {
            VerticalLayout card = createCard(p);
            cardsContainer.add(card);
        }

        add(cardsContainer);
    }
    private VerticalLayout createCard(Product product) {
        VerticalLayout card = new VerticalLayout();
        card.setWidth("220px");
        card.setPadding(true);
        card.setSpacing(false);
        card.getStyle()
                .set("border", "1px solid var(--lumo-contrast-20pct)")
                .set("border-radius", "8px")
                .set("box-shadow", "0 2px 6px rgba(0,0,0,0.06)")
                .set("padding", "12px")
                .set("background", "white");

        // imagen placeholder
        Image img = new Image("https://via.placeholder.com/200x120.png?text=Moto", "imagen moto");
        img.setWidth("100%");
        img.getStyle().set("border-radius", "6px");

        H4 name = new H4(product.getName() != null ? product.getName() : "Sin nombre");
        name.getStyle().set("margin", "8px 0 4px 0");

        Span idSpan = new Span("ID: " + (product.getId() != null ? product.getId().toString() : "-"));

        Button verBtn = new Button("Ver");
        verBtn.getElement().getStyle().set("margin-top", "8px");
        // verBtn.addClickListener(e -> navigate or abrir detalle);

        card.add(img, name, idSpan, verBtn);
        return card;
    }
    private List<Product> mockProducts() {
        List<Product> mocks = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            Product p = new Product();
            p.setId((long) i);
            p.setName("Moto Modelo " + i);
            mocks.add(p);
        }
        return mocks;
    }

}
