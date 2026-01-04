package com.motos.contado.contado_backend.views;


import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.router.Route;


@Route("homeDashboard")
public class MainView extends AppLayout {


    public MainView() {
        DrawerToggle toggle = new DrawerToggle();
        H1 title = new H1("MyApp");
        title.getStyle().set("font-size", "1.50rem").set("margin", "0");
        Component drawerContent = createDrawerContent();
        addToDrawer(drawerContent);
        addToNavbar(toggle, title);
    }


    private Component createDrawerContent() {
        SideNav sideNav = getNav();
        Button logout = new Button("CERRAR SESIÓN", e -> {
            UI.getCurrent().getPage().setLocation("/");
        });
        logout.setWidthFull();
        VerticalLayout layout = new VerticalLayout(sideNav, logout);
        layout.setSizeFull();
        layout.expand(sideNav);
        return layout;
    }

    private static SideNav getNav() {
        SideNav sideNav = new SideNav();
        SideNavItem homeIte0 = new SideNavItem("INVENTARIO", InventarioView.class);
        SideNavItem homeIte1 = new SideNavItem("POR UNIDAD", UnitedView.class);
        SideNavItem homeIte2 = new SideNavItem("CREAR PRODUCTO", CreateView.class);
        SideNavItem homeIte3 = new SideNavItem("ACTUALIZAR PRODUCTO", UpdateView.class);
        sideNav.addItem(homeIte0);
        sideNav.addItem(homeIte1);
        sideNav.addItem(homeIte2);
        sideNav.addItem(homeIte3);
        return sideNav;
    }


}
