package net.passioncloud.audit.repositories;

import net.passioncloud.audit.models.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Integer> {
}
