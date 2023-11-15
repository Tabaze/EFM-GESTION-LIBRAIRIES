package ma.ismo.crjj.efm;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ma.ismo.crjj.efm.idao.DaoLivre;
import ma.ismo.crjj.efm.idao.IDAO;
import ma.ismo.crjj.efm.model.Livre;

@Path("/livres")
public class LivreServices {

	private IDAO<Livre> dao;

//	public LivreServices(IDAO<Livre> dao) {
	// this.dao = dao;
	// }
	public LivreServices() {
		this.dao = new DaoLivre();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Livre> getAll() {
		return dao.getAll();
	}

	@GET
	@Path("/{codeLivre}")
	@Produces(MediaType.APPLICATION_JSON)
	public Livre getOne(@PathParam("codeLivre") Long codeLivre) {
		return dao.getOne(codeLivre);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public boolean save(Livre livre) {
		return dao.save(livre);
	}

	@PUT
	@Path("/{codeLivre}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public boolean update(@PathParam("codeLivre") Long codeLivre, Livre livre) {
		livre.setCodeLivre(codeLivre);
		return dao.update(livre);
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public boolean delete(Livre livre) {
		return dao.delete(livre);
	}
}
