package com.motos.contado.contado_backend.views;


import com.motos.contado.contado_backend.service.MockAuthService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("login")
public class LoginView extends VerticalLayout{
    public LoginView(MockAuthService authService) {
        setSizeFull();
        setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.CENTER);

        H1 title = new H1("Iniciar sesiónn");
        TextField username = new TextField("Usuario");
        username.setPlaceholder("usuario");
        PasswordField password = new PasswordField("Contraseña");
        password.setPlaceholder("contraseña");

        Button loginBtn = new Button("Entrar", event -> {
            boolean ok = authService.authenticate(username.getValue(), password.getValue());
            if (ok) {
                Notification.show("Bienvenido " + username.getValue(), 2000, Notification.Position.TOP_CENTER);
                // UI.getCurrent().navigate("ruta-privada"); // descomentar para navegar
            } else {
                Notification.show("Credenciales incorrectas", 2000, Notification.Position.TOP_CENTER);
            }
        });

        add(title, username, password, loginBtn);
        setAlignItems(FlexComponent.Alignment.CENTER);
        setPadding(true);
        setSpacing(true);
    }

}
