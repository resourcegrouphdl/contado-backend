package com.motos.contado.contado_backend.views;


import com.motos.contado.contado_backend.service.MockAuthService;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;


@Route("login")
public class LoginView extends Div{
    public LoginView(MockAuthService authService) {
        LoginOverlay loginOverlay = new LoginOverlay();
        loginOverlay.setTitle("Admin");
        loginOverlay.setForgotPasswordButtonVisible(false);
        loginOverlay.setDescription("motos al contado");
        loginOverlay.addLoginListener(e -> {
            String username = e.getUsername();
            String password = e.getPassword();
            if (true) {
                // marcar usuario en la sesión de Vaadin (ejemplo simple)
                VaadinSession.getCurrent().setAttribute("user", username);
                // cierra solo el overlay
                loginOverlay.close();
                // navegar a la vista protegida
                UI.getCurrent().navigate("homeDashboard");
            } else {
                loginOverlay.setError(true);
            }
        });
        add(loginOverlay);
        loginOverlay.setOpened(true);


    }

}
