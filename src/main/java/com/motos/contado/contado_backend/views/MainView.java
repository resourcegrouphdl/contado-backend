package com.motos.contado.contado_backend.views;


import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.router.Route;


@Route("homeDashboard")
public class MainView extends AppLayout {

    //private final ProductService productService;

    public MainView() {
        DrawerToggle toggle = new DrawerToggle();

        H1 title = new H1("MyApp");
        title.getStyle().set("font-size", "1.50rem").set("margin", "0");

        Component drawerContent = createDrawerContent();


        addToDrawer(drawerContent);
        addToNavbar(toggle, title);
//        SideNav nav = getSideNav();
//        nav.getStyle().set("margin", "var(--vaadin-gap-s)");
//        Scroller scroller = new Scroller(nav);
//        scroller.setSizeFull();
//        addToDrawer(scroller);
//        addToNavbar(toggle, title);


    }


    private SideNav getSideNav() {
        SideNav sideNav = getNav();
        sideNav.setHeightFull();
        SideNavItem homeIte0 = new SideNavItem("INVENTARIO",InventarioView.class);
        SideNavItem homeIte1 = new SideNavItem("POR UNIDAD",UnitedView.class);
        SideNavItem homeIte2 = new SideNavItem("CREAR PRODUCTO",CreateView.class);
        SideNavItem homeIte3 = new SideNavItem("ACTUALIZAR PRODUCTO",UpdateView.class);
        SideNavItem homeIte4 = new SideNavItem("CERRAR SESION");

        homeIte4.getStyle()
                .set("margin-top", "auto")
                .set("padding-top", "var(--lumo-space-m)");

        //SideNavItem homeIte4 = new SideNavItem("CERRAR SESION",LoginView.class);
        sideNav.addItem(homeIte0);
        sideNav.addItem(homeIte1);
        sideNav.addItem(homeIte2);
        sideNav.addItem(homeIte3);
        sideNav.addItem(homeIte4);


        return sideNav;
    }

    private Component createDrawerContent() {

        SideNav sideNav = getNav();

        Button logout = new Button("CERRAR SESIÓN", e -> {
            // Lógica para cerrar sesión
            UI.getCurrent().getPage().setLocation("/"); // Redirigir al login u otra página
        });
        logout.setWidthFull();
        //logout.addThemeVariants(ButtonVariant.LUMO_ERROR);

        VerticalLayout layout = new VerticalLayout(sideNav, logout);
        layout.setSizeFull();
        //layout.setPadding(false);
        //layout.setSpacing(false);
        layout.expand(sideNav); // 🔥 ESTO empuja el botón abajo
        //layout.getStyle().set("width", "100%");
        return layout;
    }

    private static SideNav getNav() {
        SideNav sideNav = new SideNav();
        SideNavItem homeIte0 = new SideNavItem("INVENTARIO",InventarioView.class);
        SideNavItem homeIte1 = new SideNavItem("POR UNIDAD",UnitedView.class);
        SideNavItem homeIte2 = new SideNavItem("CREAR PRODUCTO",CreateView.class);
        SideNavItem homeIte3 = new SideNavItem("ACTUALIZAR PRODUCTO",UpdateView.class);
        sideNav.addItem(homeIte0);
        sideNav.addItem(homeIte1);
        sideNav.addItem(homeIte2);
        sideNav.addItem(homeIte3);
        return sideNav;
    }


}
