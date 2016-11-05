package repository;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import domain.Usuario;

@Repository(value = "usuarioDao")
public class UsuarioDaoImpl implements UsuarioDao {

	@Autowired
	@Qualifier(value="hibernateTemplate")
	private HibernateTemplate hibernateTemplate;

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public Usuario getUser(String login) {
		List<Usuario> userList = hibernateTemplate.find("from Usuario  as u where u.codUsu='" + login + "'");
		if (userList.size() > 0)
			return (Usuario) userList.get(0);
		else
			return null;
	}

	public String getPassword(String username) {
		// TODO Auto-generated method stub
		try {
			String queryStr = "select u.password from Usuario u where u.codUsu = ?1";

//			TypedQuery<String> query = em.createQuery(queryStr, String.class);
//			query.setParameter(1, username);
//			String resultado = query.getSingleResult();
			return "";
		} catch (NoResultException e) {
			return null;
		}
	}

	@Transactional
	public void cambiarPassword(Usuario usuario) {
		// TODO Auto-generated method stub
		hibernateTemplate.merge(usuario);
	}


}
