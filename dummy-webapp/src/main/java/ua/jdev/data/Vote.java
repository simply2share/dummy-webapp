package ua.jdev.data;

import java.util.Date;

import org.springframework.data.annotation.Id;

record Vote(@Id Long id, Boolean decision, Date voteDate) {
}
