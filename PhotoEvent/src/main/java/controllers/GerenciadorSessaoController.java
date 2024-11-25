package controllers;

import java.io.*;

public class GerenciadorSessaoController {
    private static final String SESSION_FILE = "session.txt";
    public static void saveSession(String email) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(SESSION_FILE))) {
            writer.write(email);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String getSession() {
        try (BufferedReader reader = new BufferedReader(new FileReader(SESSION_FILE))) {
            return reader.readLine();
        } catch (IOException e) {
            return null;
        }
    }
    public static void clearSession() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(SESSION_FILE))) {
            writer.write("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
