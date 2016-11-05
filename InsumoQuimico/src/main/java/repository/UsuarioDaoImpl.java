package repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import domain.Usuario;

@Repository(value = "usuarioDao")
public class UsuarioDaoImpl implements UsuarioDao {

	private EntityManager em = null;

	/*
	 * Sets the entity manager.
	 */
	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public Usuario getUser(String login) {
		List userList = new ArrayList();
		userList = em.createQuery(
				"from Usuario  as u where u.codUsu='" + login + "'")
				.getResultList();
		if (userList.size() > 0)
			return (Usuario) userList.get(0);
		else
			return null;
	}

	public String getPassword(String username) {
		// TODO Auto-generated method stub
		try {
			String queryStr = "select u.password from Usuario u where u.codUsu = ?1";

			TypedQuery<String> query = em.createQuery(queryStr, String.class);
			query.setParameter(1, username);
			String resultado = query.getSingleResult();
			return resultado;
		} catch (NoResultException e) {
			return null;
		}
	}

	@Transactional
	public void cambiarPassword(Usuario usuario) {
		// TODO Auto-generated method stub
		em.merge(usuario);
	}


}
