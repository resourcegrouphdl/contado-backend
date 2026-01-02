package com.motos.contado.contado_backend.views;

import com.motos.contado.contado_backend.persistence.entity.Product;
import com.motos.contado.contado_backend.service.ProductService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;

import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.server.VaadinSession;
import org.springframework.data.domain.PageRequest;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.component.sidenav.SideNav;

import java.util.List;

@Route("homeDashboard")
public class MainView extends AppLayout {

    //private final ProductService productService;

    public MainView() {
        DrawerToggle toggle = new DrawerToggle();

        H1 title = new H1("MyApp");
        title.getStyle().set("font-size", "1.125rem").set("margin", "0");

        SideNav nav = getSideNav();
        nav.getStyle().set("margin", "var(--vaadin-gap-s)");

        Scroller scroller = new Scroller(nav);

        addToDrawer(scroller);
        addToNavbar(toggle, title);
    }


    private SideNav getSideNav() {
        SideNav sideNav = new SideNav();


        SideNavItem homeIte0 = new SideNavItem("INVENTARIO");
        SideNavItem homeIte1 = new SideNavItem("POR UNIDAD");
        SideNavItem homeIte2 = new SideNavItem("CREAR PRODUCTO");
        SideNavItem homeIte3 = new SideNavItem("ACTUALIZAR PRODUCTO");
        SideNavItem homeIte4 = new SideNavItem("CERRAR SESION");


        sideNav.addItem(homeIte0);
        sideNav.addItem(homeIte1);
        sideNav.addItem(homeIte2);
        sideNav.addItem(homeIte3);
        sideNav.addItem(homeIte4);
        return sideNav;
    }

}
