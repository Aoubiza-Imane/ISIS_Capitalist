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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="logo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="money" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="score" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="totalangels" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="activeangels" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="angelbonus" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="lastupdate" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="products" type="{}productsType"/&gt;
 *         &lt;element name="allunlocks" type="{}palliersType"/&gt;
 *         &lt;element name="upgrades" type="{}palliersType"/&gt;
 *         &lt;element name="angelupgrades" type="{}palliersType"/&gt;
 *         &lt;element name="managers" type="{}palliersType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "name",
    "logo",
    "money",
    "score",
    "totalangels",
    "activeangels",
    "angelbonus",
    "lastupdate",
    "products",
    "allunlocks",
    "upgrades",
    "angelupgrades",
    "managers"
})
@XmlRootElement(name = "world")
public class World {

    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String logo;
    protected double money;
    protected double score;
    protected double totalangels;
    protected double activeangels;
    protected int angelbonus;
    protected long lastupdate;
    @XmlElement(required = true)
    protected ProductsType products;
    @XmlElement(required = true)
    protected PalliersType allunlocks;
    @XmlElement(required = true)
    protected PalliersType upgrades;
    @XmlElement(required = true)
    protected PalliersType angelupgrades;
    @XmlElement(required = true)
    protected PalliersType managers;

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
     * Obtient la valeur de la propriété money.
     * 
     */
    public double getMoney() {
        return money;
    }

    /**
     * Définit la valeur de la propriété money.
     * 
     */
    public void setMoney(double value) {
        this.money = value;
    }

    /**
     * Obtient la valeur de la propriété score.
     * 
     */
    public double getScore() {
        return score;
    }

    /**
     * Définit la valeur de la propriété score.
     * 
     */
    public void setScore(double value) {
        this.score = value;
    }

    /**
     * Obtient la valeur de la propriété totalangels.
     * 
     */
    public double getTotalangels() {
        return totalangels;
    }

    /**
     * Définit la valeur de la propriété totalangels.
     * 
     */
    public void setTotalangels(double value) {
        this.totalangels = value;
    }

    /**
     * Obtient la valeur de la propriété activeangels.
     * 
     */
    public double getActiveangels() {
        return activeangels;
    }

    /**
     * Définit la valeur de la propriété activeangels.
     * 
     */
    public void setActiveangels(double value) {
        this.activeangels = value;
    }

    /**
     * Obtient la valeur de la propriété angelbonus.
     * 
     */
    public int getAngelbonus() {
        return angelbonus;
    }

    /**
     * Définit la valeur de la propriété angelbonus.
     * 
     */
    public void setAngelbonus(int value) {
        this.angelbonus = value;
    }

    /**
     * Obtient la valeur de la propriété lastupdate.
     * 
     */
    public long getLastupdate() {
        return lastupdate;
    }

    /**
     * Définit la valeur de la propriété lastupdate.
     * 
     */
    public void setLastupdate(long value) {
        this.lastupdate = value;
    }

    /**
     * Obtient la valeur de la propriété products.
     * 
     * @return
     *     possible object is
     *     {@link ProductsType }
     *     
     */
    public ProductsType getProducts() {
        return products;
    }

    /**
     * Définit la valeur de la propriété products.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductsType }
     *     
     */
    public void setProducts(ProductsType value) {
        this.products = value;
    }

    /**
     * Obtient la valeur de la propriété allunlocks.
     * 
     * @return
     *     possible object is
     *     {@link PalliersType }
     *     
     */
    public PalliersType getAllunlocks() {
        return allunlocks;
    }

    /**
     * Définit la valeur de la propriété allunlocks.
     * 
     * @param value
     *     allowed object is
     *     {@link PalliersType }
     *     
     */
    public void setAllunlocks(PalliersType value) {
        this.allunlocks = value;
    }

    /**
     * Obtient la valeur de la propriété upgrades.
     * 
     * @return
     *     possible object is
     *     {@link PalliersType }
     *     
     */
    public PalliersType getUpgrades() {
        return upgrades;
    }

    /**
     * Définit la valeur de la propriété upgrades.
     * 
     * @param value
     *     allowed object is
     *     {@link PalliersType }
     *     
     */
    public void setUpgrades(PalliersType value) {
        this.upgrades = value;
    }

    /**
     * Obtient la valeur de la propriété angelupgrades.
     * 
     * @return
     *     possible object is
     *     {@link PalliersType }
     *     
     */
    public PalliersType getAngelupgrades() {
        return angelupgrades;
    }

    /**
     * Définit la valeur de la propriété angelupgrades.
     * 
     * @param value
     *     allowed object is
     *     {@link PalliersType }
     *     
     */
    public void setAngelupgrades(PalliersType value) {
        this.angelupgrades = value;
    }

    /**
     * Obtient la valeur de la propriété managers.
     * 
     * @return
     *     possible object is
     *     {@link PalliersType }
     *     
     */
    public PalliersType getManagers() {
        return managers;
    }

    /**
     * Définit la valeur de la propriété managers.
     * 
     * @param value
     *     allowed object is
     *     {@link PalliersType }
     *     
     */
    public void setManagers(PalliersType value) {
        this.managers = value;
    }

}
