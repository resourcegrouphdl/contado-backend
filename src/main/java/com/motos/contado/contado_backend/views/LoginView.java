package com.motos.contado.contado_backend.views;


import com.motos.contado.contado_backend.service.MockAuthService;
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


@Route("login")
public class LoginView extends Div{
    public LoginView(MockAuthService authService) {
        LoginOverlay loginOverlay = new LoginOverlay();
        loginOverlay.setTitle("TaskMob");
        loginOverlay.setDescription("Built with ♥ by Vaadin");
        add(loginOverlay);
        loginOverlay.setOpened(true);
        // Prevent the example from stealing focus when browsing the
        // documentation
        loginOverlay.getElement().setAttribute("no-autofocus", "");
    }

}
