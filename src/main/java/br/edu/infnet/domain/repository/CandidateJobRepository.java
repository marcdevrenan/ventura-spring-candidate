package br.edu.infnet.domain.repository;

import br.edu.infnet.domain.model.CandidateJob;
import org.springframework.data.repository.CrudRepository;

public interface CandidateJobRepository extends CrudRepository<CandidateJob, Integer> {

    CandidateJob findCandidateJobByCandidateId(Integer id);
}
