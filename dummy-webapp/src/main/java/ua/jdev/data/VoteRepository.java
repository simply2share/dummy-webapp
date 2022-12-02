package ua.jdev.data;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface VoteRepository extends CrudRepository<Vote, Long> {
	@Query(value = "select count(*) as total, "
			+ "	 coalesce(sum(case when decision=true then 1 else 0 end),0) as likes, "
			+ "	 coalesce(sum(case when decision=false then 1 else 0 end),0) as dislikes from vote")
	Statistics getStatistics();
}
