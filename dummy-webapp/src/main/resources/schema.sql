create table if not exists vote (
	id bigserial primary key,
	decision boolean,
	vote_date timestamp
);