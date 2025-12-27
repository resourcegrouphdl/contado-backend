package com.motos.contado.contado_backend.views;

import com.motos.contado.contado_backend.persistence.entity.Product;
import com.motos.contado.contado_backend.service.ProductService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("pas")

public class MainView extends VerticalLayout {

    public MainView(ProductService productService) {
        H1 title = new H1("Hola Mundo");
        add(title);
        setSizeFull();
    }
}
