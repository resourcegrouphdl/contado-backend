package com.motos.contado.contado_backend.views;


import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "actualizar", layout = MainView.class)
public class UpdateView extends VerticalLayout {
    public UpdateView() {


        H3 t = new H3("update");
        add(t);


    }

}
