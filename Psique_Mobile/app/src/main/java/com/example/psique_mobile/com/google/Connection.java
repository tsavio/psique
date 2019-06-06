package com.example.psique_mobile.com.google;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.classroom.ClassroomScopes;
import com.google.api.services.people.v1.model.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;

public class Connection {
    private static final String APPLICATION_NAME = "Google Classroom API Java Quickstart";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final String TOKENS_DIRECTORY_PATH = "tokens";
    private static final Context ctx = null;
    private static final String message = "Success in room request";
    private static final String urlShare = "https://hangouts.google.com/hangouts/_/raaystieqjdojcqw26iapnwjvye";
    private static final String imgPath = "https://hangouts.google.com/hangouts/{localParticipantld}/{user.id}/participants/{participantsId}";
    /**
     * Global instance of the scopes required by this quickstart.
     * If modifying these scopes, delete your previously saved tokens/ folder.
     */
    private static final List<String> SCOPES = Collections.singletonList(ClassroomScopes.CLASSROOM_COURSES_READONLY);
    private static final String CREDENTIALS_FILE_PATH = "/credentials.json";

    /**
     * Creates an authorized Credential object.
     * @param HTTP_TRANSPORT The network HTTP Transport.
     * @return An authorized Credential object.
     * @throws IOException If the credentials.json file cannot be found.
     */

    private Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {
        // Load client secrets.
        InputStream in = Connection.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
        if (in == null) {
            throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
        }
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
                .setAccessType("offline")
                .build();
        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
        return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
    }
    public void sendHangout() {
        Intent hangouts = new Intent(Intent.ACTION_SEND);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR2){
            if(!UtilsGoogle.isNullorEmpty(imgPath)){
                String file = (String)imgPath.subSequence(0, imgPath.lastIndexOf("/") + 1) + message.replace(" ", "").replace(":", "").replace(".", "")
                        .replace("/", "") + ".jpeg";
                UtilsGoogle.copyFile(imgPath, file);
                hangouts.setType("image/*");
                hangouts.putExtra(Intent.EXTRA_STREAM, Uri.parse("file:///" + file));
            }
        }
        hangouts.setPackage("com.google.android.talk");
        hangouts.setType("text/plain");
        hangouts.putExtra(Intent.EXTRA_TEXT, message + ": \n" + urlShare);
        ctx.startActivity(Intent.createChooser(hangouts, "Hangouts is not installed."));
    }

    public String getChatRoom (){
        Intent hangouts = new Intent(Intent.ACTION_CALL);
        return hangouts.getDataString();
    }
    public String getResourceNameByContract (ContactGroupResponse contactGroupResponse){
        return contactGroupResponse.getRequestedResourceName();
    }


}
