package ma.ismo.crjj.efm.idao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ma.ismo.crjj.efm.model.Livre;
import ma.ismo.crjj.efm.utils.HibernateUtils;

public class DaoLivre implements IDAO<Livre> {
	@Override
	public List<Livre> getAll() {
		Session s = HibernateUtils.getSessionfactory().getCurrentSession();
		Transaction t = s.beginTransaction();

		List<Livre> commande = s.createQuery("from Livre").list();

		t.commit();
		s.close();

		return commande;
	}

	@Override
	public Livre getOne(Long id) {
		Session session = HibernateUtils.getSessionfactory().getCurrentSession();
		Transaction t = session.beginTransaction();
		System.out.println(id);
		Livre commande = session.get(Livre.class, id);
		t.commit();
		session.close();
		return commande;
	}

	@Override
	public boolean save(Livre obj) {
		try {
			Session s = HibernateUtils.getSessionfactory().getCurrentSession();
			Transaction t = s.beginTransaction();

			s.save(obj);
			t.commit();
			s.close();

			return true;
		} catch (Exception ex) {
			System.out.println("Error " + ex.getMessage());
			return false;
		}
	}

	@Override
	public boolean update(Livre obj) {
		try {
			Session session = HibernateUtils.getSessionfactory().getCurrentSession();
			Transaction t = session.beginTransaction();

			session.update(obj);

			t.commit();
			session.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean delete(Livre obj) {
		try {
			Session session = HibernateUtils.getSessionfactory().getCurrentSession();
			Transaction t = session.beginTransaction();

			session.delete(obj);

			t.commit();
			session.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
