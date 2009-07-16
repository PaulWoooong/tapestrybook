package de.t5book.services;

import java.util.List;

import de.t5book.entities.Option;
import de.t5book.entities.Vote;

public interface VoteService {
	
   void createDemoData();

   Vote findVote();

   Option findOptionById(Long id);

   void saveOrUpdateVote(Vote vote);

   void deleteOption(Option option);
   
   List<Vote> findAll();
}