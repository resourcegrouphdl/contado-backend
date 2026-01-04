package com.motos.contado.contado_backend.views;


import com.motos.contado.contado_backend.persistence.entity.Product;
import com.motos.contado.contado_backend.service.ProductService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "create", layout = MainView.class)
public class CreateView extends VerticalLayout {
    private final ProductService productService;
    private final Binder<Product> binder = new Binder<>(Product.class);

    @Autowired
    public CreateView(ProductService productService) {
        this.productService = productService;

        setPadding(true);
        setSpacing(true);

        H3 title = new H3("Crear producto");
        add(title);

        TextField nameField = new TextField("Nombre");
        nameField.setRequired(true);

        // Bindings
        binder.forField(nameField)
                .asRequired("El nombre es obligatorio")
                .bind(Product::getName, Product::setName);

        Button saveBtn = new Button("Guardar", event -> saveProduct());
        saveBtn.getElement().getStyle().set("margin-top", "8px");

        add(nameField, saveBtn);
    }

    private void saveProduct() {
        Product product = new Product();
        if (binder.writeBeanIfValid(product)) {
            try {
                productService.save(product);
                Notification.show("Producto guardado").setDuration(2000);
                binder.readBean(new Product()); // limpiar formulario
            } catch (Exception ex) {
                Notification.show("Error al guardar: " + ex.getMessage()).setDuration(3000);
            }
        } else {
            Notification.show("Corrija los campos obligatorios").setDuration(2000);
        }
    }

}
