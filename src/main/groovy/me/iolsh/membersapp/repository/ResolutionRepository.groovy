package me.iolsh.membersapp.repository;

import org.springframework.data.repository.CrudRepository;
import me.iolsh.membersapp.domain.membership.Resolution;

interface ResolutionRepository extends CrudRepository<Resolution, Long> {

}
