package com.motos.contado.contado_backend.views;


import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "unidad", layout = MainView.class)
public class UnitedView extends VerticalLayout {
    public UnitedView() {


        H3 t = new H3("united");
        add(t);


    }

}
