package com.motos.contado.contado_backend.views;

import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "inventario", layout = MainView.class)
public class InventarioView extends VerticalLayout {
    public InventarioView() {
        H3 t = new H3("inventario");
        add(t);
    }
}
