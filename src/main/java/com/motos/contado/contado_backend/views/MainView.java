package com.motos.contado.contado_backend.views;

import com.motos.contado.contado_backend.persistence.entity.Product;
import com.motos.contado.contado_backend.service.ProductService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.server.VaadinSession;
import org.springframework.data.domain.PageRequest;

import java.util.List;

@Route("homeDashboard")

public class MainView extends VerticalLayout {

    private final ProductService productService;

    public MainView(ProductService productService) {
        this.productService = productService;
        setSizeFull();
        setPadding(true);
        setSpacing(true);

        add(createHeader());
        add(createSummaryLayout());
        add(createGrid());
        expand(createGrid()); // hace que la grid ocupe el espacio restante
    }
    private Component createHeader() {
        H1 title = new H1("Dashboard");
        Button logout = new Button("Cerrar sesión", e -> {
            // invalidar sesión y volver al login
            try {
                VaadinSession.getCurrent().close();
            } catch (Exception ex) {
                // manejar si hace falta
            }
            UI.getCurrent().navigate("login");
        });

        HorizontalLayout header = new HorizontalLayout(title, logout);
        header.expand(title);
        header.setWidthFull();
        return header;
    }

    private Component createSummaryLayout() {

        List<Product> products = productService.findAll(); // adapta si tu método tiene otro nombre
        int totalProducts = products.size();

        SummaryCard totalCard = new SummaryCard("Productos", String.valueOf(totalProducts));
        HorizontalLayout layout = new HorizontalLayout(totalCard);
        layout.setWidthFull();
        return layout;
    }

    private Component createGrid() {
        Grid<Product> grid = new Grid<>(Product.class, false);
        List<Product> products = productService.findAll();

        // columna genérica que usa toString() para evitar depender de campos concretos
        grid.addColumn(p -> p == null ? "" : p.toString()).setHeader("Producto");
        grid.setItems(products);
        grid.setSizeFull();
        return grid;
    }

}
