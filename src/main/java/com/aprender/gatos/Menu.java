package com.aprender.gatos;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;

public class Menu {
    public static void Menu() throws IOException {
        String op = "";
        do {
            op = (String) JOptionPane.showInputDialog(null, "Gatos java", "Gatos"
                    , JOptionPane.PLAIN_MESSAGE, null, new String[]{"Selecciona", "Ver Gato", "Ver Favoritos", "Salir"}, "Seleccione");
            op = op.toLowerCase();

            switch (op) {
                case "ver gato":
                    menuRead(CatService.readCat());
                    break;
                case "ver favoritos":
                    Cat cat[] = CatService.listFavorite();
                    ImageIcon ima[] = new ImageIcon[cat.length];
                    for (int i = 0; i < cat.length; i++) {
                        ima[i] = imageC(cat[i].getImaFavo());
                    }
                    new Layout(ima);
                    break;
                default:
                    break;
            }

        } while (!op.equals("salir"));
    }

    private static void menuRead(Cat cat) throws IOException {
        String op = (String) JOptionPane.showInputDialog(null, "Gatos java", "Gatos"
                , JOptionPane.PLAIN_MESSAGE, imageC(cat), new String[]{"Opciones", "Ver otra imagen", "Favorito", "Volver"}, "Seleccione");
        op = op.toLowerCase();

        switch (op) {
            case "ver otra imagen":
                menuRead(CatService.readCat());
                break;
            case "favorito":
                CatService.favorite(cat);
                break;
            default:
                break;
        }
    }

    private static ImageIcon imageC(Cat cat) {
        Image image = null;
        ImageIcon imageCat = null;
        try {
            System.out.println(cat.getUrl());
            image = ImageIO.read(new URL(cat.getUrl()));
            System.out.println(cat.getUrl());
            image = image.getScaledInstance(100, 200, Image.SCALE_SMOOTH);
            imageCat = new ImageIcon(image);
            return imageCat;
        } catch (IOException e) {
            System.out.println(e + "Error ima");
        }
        return null;
    }
}