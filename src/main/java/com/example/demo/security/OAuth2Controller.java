package com.example.demo.security;

import org.apache.coyote.Response;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
public class OAuth2Controller {


    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/app")
    public void app() {

        {
            // Keycloak admin credentials
            String adminUsername = "fatemeh";
            String adminPassword = "123";
            String keycloakBaseUrl = "http://localhost:8080";
            String realmName = "myrealm"; // Name of the realm

            // Create a Keycloak admin instance
            Keycloak keycloak = Keycloak.getInstance(
                    keycloakBaseUrl,
                    "master",
                    adminUsername,
                    adminPassword,
                    "admin-cli"
            );

            // Get the realm resource
            RealmResource realmResource = keycloak.realm(realmName);

            // Get the users resource
            UsersResource usersResource = realmResource.users();

            // Retrieve all users in the realm
            List<UserRepresentation> users = usersResource.list();

            // Print user details
            System.out.println("Users in the realm:");
            for (UserRepresentation user : users) {
                System.out.println("Username: " + user.getUsername());
                System.out.println("Email: " + user.getEmail());
                System.out.println("First Name: " + user.getFirstName());
                System.out.println("Last Name: " + user.getLastName());
                System.out.println();
            }
        };
    }



}
