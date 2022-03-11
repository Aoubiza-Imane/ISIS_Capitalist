package com.example.capitalist;

import generated.ProductType;
import generated.World;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class Services {
    public World readWorldFromXml(String username) {
    InputStream input;
        try {
            File file = new File(username + "-world.xml"); //getting the known user's world
            input = new FileInputStream(file);

        } catch (FileNotFoundException e) {
            input = getClass().getClassLoader().getResourceAsStream("world.xml"); //handing out a world to a new user
        }

        World world = null;
        try {
            JAXBContext cont = JAXBContext.newInstance(World.class);
            Unmarshaller u = cont.createUnmarshaller();
            world = (World) u.unmarshal(input);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return world;
    }

    public void saveWorldToXml(World world, String username) throws JAXBException, FileNotFoundException {
        File file = new File(username + "-world.xml");
        OutputStream output = new FileOutputStream(file);
        JAXBContext cont = JAXBContext.newInstance(World.class);
        Marshaller m = cont.createMarshaller();
        m.marshal(world, output);
    }

    public World getWorld(String username) {
        return readWorldFromXml(username);
    }

    // prend en paramètre le pseudo du joueur et le produit
// sur lequel une action a eu lieu (lancement manuel de production ou
// achat d’une certaine quantité de produit)
// renvoie false si l’action n’a pas pu être traitée
    /*public Boolean updateProduct(String username, ProductType newproduct) throws JAXBException, FileNotFoundException {
        // aller chercher le monde qui correspond au joueur
        World world = getWorld(username);
        // trouver dans ce monde, le produit équivalent à celui passé
        // en paramètre
        ProductType product = findProductById(world, newproduct.getId());
        if (product == null) { return false;}

        // calculer la variation de quantité. Si elle est positive c'est
        // que le joueur a acheté une certaine quantité de ce produit
        // sinon c’est qu’il s’agit d’un lancement de production.
        int qtchange = newproduct.getQuantite() - product.getQuantite();
        if (qtchange > 0) {
            // soustraire de l'argent du joueur le cout de la quantité
            // achetée et mettre à jour la quantité de product

        } else {
            // initialiser product.timeleft à product.vitesse
            // pour lancer la production
        }
        // sauvegarder les changements du monde
        saveWorldToXml(world, username);
        return true;
    }*/
}

