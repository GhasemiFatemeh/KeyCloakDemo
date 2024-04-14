package com.example.demo;

import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.UserRepresentation;

import java.util.List;

public class KeycloakAdminClientExample {
    public static void main(String[] args) {
        // Keycloak admin credentials
        String adminUsername = "fatemeh";
        String adminPassword = "123";
        String keycloakBaseUrl = "http://localhost:8080/auth";
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
    }
}
