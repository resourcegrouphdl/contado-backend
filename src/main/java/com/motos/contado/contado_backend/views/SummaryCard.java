package com.motos.contado.contado_backend.views;


import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Paragraph;
public class SummaryCard  extends Div{
    public SummaryCard(String title, String value) {
        addClassName("summary-card");

        H3 t = new H3(title);
        Paragraph v = new Paragraph(value);

        getStyle().set("border", "1px solid var(--lumo-contrast-10pct)");
        getStyle().set("padding", "0.75rem");
        getStyle().set("border-radius", "8px");
        getStyle().set("min-width", "160px");

        add(t, v);
    }

}
