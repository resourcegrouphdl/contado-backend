package com.motos.contado.contado_backend.views;


import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "create", layout = MainView.class)
public class CreateView extends VerticalLayout {
    public CreateView() {


        H3 t = new H3("create");
        add(t);


    }

}
