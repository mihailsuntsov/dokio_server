/*
Приложение Dokio-server - учет продаж, управление складскими остатками, документооборот.
Copyright © 2020 Сунцов Михаил Александрович. mihail.suntsov@yandex.ru
Эта программа является свободным программным обеспечением: Вы можете распространять ее и (или) изменять,
соблюдая условия Генеральной публичной лицензии GNU редакции 3, опубликованной Фондом свободного
программного обеспечения;
Эта программа распространяется в расчете на то, что она окажется полезной, но
БЕЗ КАКИХ-ЛИБО ГАРАНТИЙ, включая подразумеваемую гарантию КАЧЕСТВА либо
ПРИГОДНОСТИ ДЛЯ ОПРЕДЕЛЕННЫХ ЦЕЛЕЙ. Ознакомьтесь с Генеральной публичной
лицензией GNU для получения более подробной информации.
Вы должны были получить копию Генеральной публичной лицензии GNU вместе с этой
программой. Если Вы ее не получили, то перейдите по адресу:
<http://www.gnu.org/licenses/>
 */
package com.dokio.security.services;

import com.dokio.model.User;
import com.dokio.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@PersistenceContext
	private EntityManager entityManager;
	@Autowired
	UserRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username).orElseThrow(
				() -> new UsernameNotFoundException("User Not Found with -> username or email : " + username));
		return UserPrinciple.build(user);
	}

	public Long getUserId() {
		String username = getUserName();
		if(!username.equals("anonymousUser")) {
//			String stringQuery = "select p.id from users p where username="+username;
//			Query query = entityManager.createNativeQuery(stringQuery);
			Long id = userRepository.findByUsername(username).get().getId();
			return id;
			//return Long.valueOf(query.getFirstResult());
		}else{
			return null;
		}
	}

	public Long getUserIdByUsername(String username) {
		if(!username.equals("anonymousUser")) {
			Long id = userRepository.findByUsername(username).get().getId();
			return id;
		}else{
			return null;
		}
	}

	public User getUserByUsername(String username) {
		User user = userRepository.findByUsername(username).orElseThrow(
				() -> new UsernameNotFoundException("User Not Found with -> username or email : " + username));
		return user;
	}

	public String getUserName(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return auth.getName(); // auth так же может давать список ролей юзера
	}

	public String getUserTimeZone(){
		String stringQuery;
		stringQuery=    " select " +
				" s.canonical_id " +
				" from " +
				" sprav_sys_timezones s" +
				" where s.id=(" +
				" select u.time_zone_id from users u where u.id=" + getUserId() +
				")";
		Query query = entityManager.createNativeQuery(stringQuery);
		return query.getSingleResult().toString();
	}

}