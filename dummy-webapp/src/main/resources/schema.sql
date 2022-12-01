create table if not exists vote (
	id identity,
	decision boolean,
	vote_date timestamp
);