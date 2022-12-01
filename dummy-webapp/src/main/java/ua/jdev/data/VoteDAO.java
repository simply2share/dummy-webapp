package ua.jdev.data;

import java.time.Instant;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class VoteDAO {
	VoteRepository repo;

	public VoteDAO(VoteRepository repository) {
		this.repo = repository;
	}

	public void vote(boolean decision) {
		repo.save(new Vote(null, decision, Date.from(Instant.now())));
	}

	public Statistics statistics() {
		return repo.getStatistics();
	}
}
