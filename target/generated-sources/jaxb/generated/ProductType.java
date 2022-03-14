//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.3.2 
// Voir <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2022.03.11 à 11:06:30 AM CET 
//


package generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour productType complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="productType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="logo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="cout" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="croissance" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="revenu" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="vitesse" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="quantite" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="timeleft" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="managerUnlocked" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="palliers" type="{}palliersType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "productType", propOrder = {
    "id",
    "name",
    "logo",
    "cout",
    "croissance",
    "revenu",
    "vitesse",
    "quantite",
    "timeleft",
    "managerUnlocked",
    "palliers"
})
public class ProductType {

    protected int id;
    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String logo;
    protected double cout;
    protected double croissance;
    protected double revenu;
    protected int vitesse;
    protected int quantite;
    public long timeleft;
    protected boolean managerUnlocked;
    @XmlElement(required = true)
    protected PalliersType palliers;

    /**
     * Obtient la valeur de la propriété id.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Définit la valeur de la propriété id.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Obtient la valeur de la propriété name.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Définit la valeur de la propriété name.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Obtient la valeur de la propriété logo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLogo() {
        return logo;
    }

    /**
     * Définit la valeur de la propriété logo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLogo(String value) {
        this.logo = value;
    }

    /**
     * Obtient la valeur de la propriété cout.
     * 
     */
    public double getCout() {
        return cout;
    }

    /**
     * Définit la valeur de la propriété cout.
     * 
     */
    public void setCout(double value) {
        this.cout = value;
    }

    /**
     * Obtient la valeur de la propriété croissance.
     * 
     */
    public double getCroissance() {
        return croissance;
    }

    /**
     * Définit la valeur de la propriété croissance.
     * 
     */
    public void setCroissance(double value) {
        this.croissance = value;
    }

    /**
     * Obtient la valeur de la propriété revenu.
     * 
     */
    public double getRevenu() {
        return revenu;
    }

    /**
     * Définit la valeur de la propriété revenu.
     * 
     */
    public void setRevenu(double value) {
        this.revenu = value;
    }

    /**
     * Obtient la valeur de la propriété vitesse.
     * 
     */
    public int getVitesse() {
        return vitesse;
    }

    /**
     * Définit la valeur de la propriété vitesse.
     * 
     */
    public void setVitesse(int value) {
        this.vitesse = value;
    }

    /**
     * Obtient la valeur de la propriété quantite.
     * 
     */
    public int getQuantite() {
        return quantite;
    }

    /**
     * Définit la valeur de la propriété quantite.
     * 
     */
    public void setQuantite(int value) {
        this.quantite = value;
    }

    /**
     * Obtient la valeur de la propriété timeleft.
     * 
     */
    public long getTimeleft() {
        return timeleft;
    }

    /**
     * Définit la valeur de la propriété timeleft.
     * 
     */
    public void setTimeleft(long value) {
        this.timeleft = value;
    }

    /**
     * Obtient la valeur de la propriété managerUnlocked.
     * 
     */
    public boolean isManagerUnlocked() {
        return managerUnlocked;
    }

    /**
     * Définit la valeur de la propriété managerUnlocked.
     * 
     */
    public void setManagerUnlocked(boolean value) {
        this.managerUnlocked = value;
    }

    /**
     * Obtient la valeur de la propriété palliers.
     * 
     * @return
     *     possible object is
     *     {@link PalliersType }
     *     
     */
    public PalliersType getPalliers() {
        return palliers;
    }

    /**
     * Définit la valeur de la propriété palliers.
     * 
     * @param value
     *     allowed object is
     *     {@link PalliersType }
     *     
     */
    public void setPalliers(PalliersType value) {
        this.palliers = value;
    }

}
