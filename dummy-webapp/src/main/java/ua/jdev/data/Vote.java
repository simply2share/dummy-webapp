package ua.jdev.data;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("VOTE")
record Vote(@Id Long id, Boolean decision, Date voteDate) {
}
