package br.edu.infnet.domain.repository;

import br.edu.infnet.domain.model.CandidateJob;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CandidateJobRepository extends CrudRepository<CandidateJob, Integer> {

    CandidateJob findCandidateJobByCandidateId(Integer id);
    List<CandidateJob> findCandidateJobsByCandidateId(Integer id);
}
