/*

Author: 4dh4r5h 
Language: Java
Last Modified: 10/05/2023

*/

import java.lang.Object;
import java.lang.*;
import com.azure.core.credential.TokenCredential;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.util.Context;
import com.azure.identity.ClientSecretCredential;
import com.azure.identity.ClientSecretCredentialBuilder;
import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.resourcemanager.communication.*;
import com.azure.resourcemanager.communication.CommunicationManager;
import com.azure.resourcemanager.communication.models.EmailServiceResource;

// This is a public class

public class Email {

    public static void main(String[] args) {
        try {
            AzureProfile profile = new AzureProfile(AzureEnvironment.AZURE); // checking the environment
            TokenCredential credential = new DefaultAzureCredentialBuilder().authorityHost(profile.getEnvironment().getActiveDirectoryEndpoint()).build(); // building the credential
            CommunicationManager manager = CommunicationManager.authenticate(credential, profile); // can create a comms manager.
            PagedIterable <EmailServiceResource>  emailServiceResources = manager.emailServices().list(Context.NONE); // make a PagedIterable container with email services listed.
            for (EmailServiceResource x : emailServiceResources) {
                System.out.println(x.name().toString());    // Need to print the name using toString().
            }
            
            // Lines 32 - 34 does not seem to work, I can see my subscription ID and related details.
            
        }
        catch (Exception e) {
            System.out.println(e.toString());   // Read with the exception.
        }

    }
}
