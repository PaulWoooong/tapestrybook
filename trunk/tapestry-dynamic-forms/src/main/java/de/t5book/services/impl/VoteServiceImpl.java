package de.t5book.services.impl;

import java.util.List;

import org.apache.tapestry5.hibernate.HibernateSessionManager;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import de.t5book.entities.Option;
import de.t5book.entities.Vote;
import de.t5book.services.VoteService;

public class VoteServiceImpl implements VoteService {

	private final HibernateSessionManager hibernateSessionManager;

	public VoteServiceImpl(final HibernateSessionManager hibernateSessionManager) {
		super();
		this.hibernateSessionManager = hibernateSessionManager;
	}

	public void deleteOption(final Option option) {
		this.hibernateSessionManager.getSession().delete(option);
		this.hibernateSessionManager.commit();
	}

	public Option findOptionById(final Long id) {
		final Session session = this.hibernateSessionManager.getSession();
		return (Option) session.createCriteria(Option.class).add(
				Restrictions.eq("id", id)).uniqueResult();
	}

	public void saveOrUpdateVote(final Vote vote) {
		this.hibernateSessionManager.getSession().saveOrUpdate(vote);
		this.hibernateSessionManager.commit();
	}

	public void createDemoData() {
		final Vote vote = new Vote();
		vote.setQuestion("Welches Web-Framework setzen Sie ein?");
		saveOrUpdateVote(vote);
	}

	public Vote findVote() {
		List list = this.hibernateSessionManager.getSession().createCriteria(
				Vote.class).list();
		if (list.isEmpty()) {
			return null;
		}
		return (Vote) list.get(0);
	}

	public List<Vote> findAll() {
		return hibernateSessionManager.getSession().createCriteria(Vote.class)
				.list();
	}

}