package com.brainyway.mrs.tpms.users;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.brainyway.mrs.tpms.model.TPMSUser;

@Repository
public class TPMSUserDaoImpl implements TPMSUserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public TPMSUser findByUserName(String username) {

		List<TPMSUser> users = new ArrayList<TPMSUser>();

		users = sessionFactory.getCurrentSession().createQuery("from TPMSUser where username=?").setParameter(0, username)
				.list();

		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}

	}
}