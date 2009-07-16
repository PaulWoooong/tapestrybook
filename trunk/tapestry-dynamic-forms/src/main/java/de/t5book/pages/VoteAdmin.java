package de.t5book.pages;

import org.apache.tapestry5.ValueEncoder;
import org.apache.tapestry5.annotations.PageActivationContext;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;

import de.t5book.entities.Option;
import de.t5book.entities.Vote;
import de.t5book.services.VoteService;

public class VoteAdmin {
	@Property
	@Persist
	private Vote vote;

	@Property
	private Option currentOption;

	@Inject
	private VoteService voteService;

	void onActivate() {
		vote = voteService.findVote();
	}

	Object onAddRowFromOptions() {
		Option option = new Option();

		this.vote.getOptions().add(option);
		this.voteService.saveOrUpdateVote(this.vote);

		return option;
	}

	void onRemoveRowFromOptions(final Option option) {
		this.vote.getOptions().remove(option);
		this.voteService.saveOrUpdateVote(this.vote);
	}

	void onSuccess() {
		this.voteService.saveOrUpdateVote(this.vote);
	}
}
