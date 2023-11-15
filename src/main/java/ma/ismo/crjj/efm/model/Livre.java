package ma.ismo.crjj.efm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "livre")
public class Livre {

    @Id
    @Column(name="code_livre")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codeLivre;
    @Column(name="titre")
    private String titre;
    @Column(name="prix")
    private Float prix;
    @Column(name="auteur")
    private String auteur;

    public Livre() {
    }

    public Livre(Long codeLivre, String titre, Float prix, String auteur) {
        this.codeLivre = codeLivre;
        this.titre = titre;
        this.prix = prix;
        this.auteur = auteur;
    }

	public Long getCodeLivre() {
		return codeLivre;
	}

	public void setCodeLivre(Long codeLivre) {
		this.codeLivre = codeLivre;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Float getPrix() {
		return prix;
	}

	public void setPrix(Float prix) {
		this.prix = prix;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

}