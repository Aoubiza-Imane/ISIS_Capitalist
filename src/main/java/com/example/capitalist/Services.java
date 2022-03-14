package com.example.capitalist;

import generated.PallierType;
import generated.ProductType;
import generated.TyperatioType;
import generated.World;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.List;

public class Services {
    InputStream input;

    /* FUNCTIONS TO RETRIEVE THE WORLD AND SAVE IT FOR A SPECIFIC USER*/
    public World readWorldFromXml(String username) {
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

    /* UPDATE OF MANAGERS AND PRODUCTS*/


    public Boolean updateManager(String username, PallierType manager) throws JAXBException, FileNotFoundException {
        // takes as parameters the player's nickname and the manager bought.
        // returns false if the action could not be processed

        // fetch the world that matches the player
        World world = getWorld(username);
        // find in this world, the manager equivalent to the one passed in parameter
        manager = findManagerByName(world, manager.getName());
        if (manager == null) {
            return false;
        }
        // unlock this manager
        manager.setUnlocked(true);

        // find the product corresponding to the manager
        ProductType product = findProductById(world, manager.getIdcible());
        if (product == null) {
            return false;
        }
        // unlock this manager of this product
        product.setManagerUnlocked(true);
        // subtract from the player's money the cost of the manager
        double money = world.getMoney();
        double seuil = manager.getSeuil();

        double newMoney = money - seuil;
        world.setMoney(newMoney);

        // save the changes to the world
        saveWorldToXml(world, username);
        return true;
    }


    public Boolean updateProduct(String username, ProductType newproduct) throws JAXBException, FileNotFoundException {
        // takes as parameter the player's nickname and the product
        // on which an action has taken place (manual production launch or
        // purchase of a certain quantity of product)

        // fetch the world that matches the player
        World world = getWorld(username);
        // find in this world, the product equivalent to the one passed in parameter
        ProductType product = findProductById(world, newproduct.getId());
        if (product == null) {
            return false;
        }

        // calculate the quantity change. If it is positive it means that
        // that the player has bought a certain quantity of this product
        // if not, it means that a production launch has taken place.
        int qtchange = newproduct.getQuantite() - product.getQuantite();
        if (qtchange > 0) {
            double money = world.getMoney();
            double growth = product.getCroissance();
            double cost = product.getCout();
            int newQt = newproduct.getQuantite();
            // Update player's money after purchase
            double newMoney = money - cost;
            world.setMoney(newMoney);

            //Update the cost of the purchased product
            double newCout = cost * Math.pow(growth, qtchange);
            product.setCout(newCout);

            //Update product quantity
            product.setQuantite(newQt);
            System.out.println(newQt);

        } else {
            // initialize product.timeleft à product.vitesse
            // to begin the production
            product.timeleft = (product.getVitesse());
            world.setMoney(world.getMoney() + (product.getRevenu() * product.getQuantite()));
        }
        List<PallierType> unlocks = product.getPalliers().getPallier();
        for (PallierType u : unlocks) {
            if (u.isUnlocked() == false && product.getQuantite() >= u.getSeuil()) {
                unlockUpgrade(u, product);
            }
        }
        // save the changes in the world
        saveWorldToXml(world, username);
        return true;
    }

    public void unlockUpgrade(PallierType paltype, ProductType product) {
        paltype.setUnlocked(true);
        if (paltype.getTyperatio() == TyperatioType.VITESSE) {
            double vitesse = product.getVitesse();
            vitesse = (int) (vitesse * paltype.getRatio());
            product.setVitesse((int) vitesse);
        }
        if (paltype.getTyperatio() == TyperatioType.GAIN) {
            double revenu = product.getRevenu();
            revenu = revenu * paltype.getRatio();
            product.setRevenu(revenu);
        }
    }

    /* FIND AN ELEMENT*/
    public ProductType findProductById(World world, int id) {
        ProductType product = null;
        for (ProductType p : world.getProducts().getProduct()) {
            if (id == p.getId()) {
                product = p;
            }
        }
        return product;
    }
    public PallierType findManagerByName(World world, String name) {
        PallierType man = null;
        for (PallierType p : world.getManagers().getPallier()) {
            if (name.equals(p.getName())) {
                man = p;
            }
        }
        return man;
    }
    public PallierType findUpgradeByName(World world, String name) {
        PallierType upg = null;
        for (PallierType p : world.getUpgrades().getPallier()) {
            if (name.equals(p.getName())) {
                upg = p;
            }
        }
        return upg;
    }

    /*ADDING AN UPGRADE TO A PRODUCT AND MODIFYING THE PRODUCT LEVEL*/

    public void addUnlockProduct(PallierType pallier, ProductType product) {
        pallier.setUnlocked(true);
        if (pallier.getTyperatio() == TyperatioType.VITESSE) {
            double vitesse = product.getVitesse();
            vitesse = vitesse * pallier.getRatio();
            product.setVitesse((int) vitesse);
        }
        if (pallier.getTyperatio() == TyperatioType.GAIN) {
            double revenu = product.getRevenu();
            revenu = revenu * pallier.getRatio();
            product.setRevenu(revenu);
        }
    }

    public Boolean makeUpgrade(String username, PallierType newUpgrade) throws JAXBException, FileNotFoundException {
        System.out.println("Début de l'ajout de l'upgrade");
        World world = getWorld(username);
        // find in this world the upgrade
        for (PallierType p : world.getUpgrades().getPallier()) {
            System.out.println("Upgrade : " + p.getName());
            if (newUpgrade.getName().equals(p.getName())) {
                System.out.println("Upgrade correspondant");
                p.setUnlocked(true);
                // find the product corresponding to the upgrade
                ProductType product = findProductById(world, p.getIdcible());
                if (product == null) {
                    return false;
                }
                // subtract the cost of the cash upgrade from the player's money
                double money = world.getMoney();
                double seuil = p.getSeuil();

                double newMoney = money - seuil;
                world.setMoney(newMoney);

                // modify the product according to the upgrade
                addUnlockProduct(p, product);

                // save the changes to the world
                saveWorldToXml(world, username);
            }
            else {
                System.out.println("Upgrade non correspondant");
            }
        }
        return true;
    }

    /*UPDATING USER'S WORLD*/

    public World getScoreandWorld(String pseudo) throws JAXBException, FileNotFoundException {
        // Recovery of the world
        World world = readWorldFromXml(pseudo);
        long timePassed = System.currentTimeMillis() - world.getLastupdate();

        // Calculation of the score
        for (ProductType product : world.getProducts().getProduct()) {
            // Case where the product has a manager
            if (product.isManagerUnlocked()) {
                long numberProducted = Math.floorDiv(timePassed, product.getVitesse());
                double moneyProduced = numberProducted * product.getQuantite() * product.getRevenu() * (1 + (world.getActiveangels() * world.getAngelbonus()) / 100);
                world.setMoney(world.getMoney() + moneyProduced);
                world.setScore(world.getScore() + moneyProduced);

                product.setTimeleft(timePassed % product.getVitesse());
            }

            // Case where the product does not have a manager
            if ((product.isManagerUnlocked() == false) && (product.getTimeleft() != 0)) {
                product.setTimeleft(product.getTimeleft() - timePassed);

                if (product.getTimeleft() <= 0) {
                    double moneyProduced = product.getQuantite() * product.getRevenu() * (1 + (world.getActiveangels() * world.getAngelbonus()) / 100);
                    world.setMoney(world.getMoney() + moneyProduced);
                    world.setScore(world.getScore() + moneyProduced);

                    product.setTimeleft(0);
                }
            }

        }
        // Update of the last backup
        world.setLastupdate(System.currentTimeMillis());

        // Saving the world
    saveWorldToXml(world, pseudo);
    return world;
}

    /* RESETTING USER'S WORLD*/
    public Object deleteWorld(String username) throws JAXBException{
        // setting the new world's score and money
        try {
            World world = readWorldFromXml(username);
            double score = world.getScore();

            //recreating a new instance
            JAXBContext cont = JAXBContext.newInstance(World.class);
            Unmarshaller u = cont.createUnmarshaller();
            world = (World) u.unmarshal(input);
            world.setScore(score);
            world.setMoney(0);
            saveWorldToXml(world, username);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}