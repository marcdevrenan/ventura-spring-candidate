package br.edu.infnet.domain.controller;

import br.edu.infnet.domain.model.CandidateJob;
import br.edu.infnet.domain.repository.CandidateJobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/candidateJob")
public class CandidateJobController {

    @Autowired
    private CandidateJobRepository candidateJobRepository;

    @GetMapping(path = {"/{id}"})
    public ResponseEntity getById(@PathVariable Integer id) {

        ResponseEntity response = ResponseEntity.notFound().build();
        CandidateJob candidateJob = candidateJobRepository.findCandidateJobByCandidateId(id);
        if (candidateJob != null) {
            response = ResponseEntity.ok().body(candidateJob);
        }

        return response;
    }

    @GetMapping(path = {"/applications/{id}"})
    public ResponseEntity getListById(@PathVariable Integer id) {

        ResponseEntity response = ResponseEntity.notFound().build();
        List<CandidateJob> applications = candidateJobRepository.findCandidateJobsByCandidateId(id);
        if (applications != null) {
            response = ResponseEntity.ok().body(applications);
        }

        return response;
    }

    @PostMapping
    public ResponseEntity candidateJobRelationship(@RequestBody CandidateJob candidateJob) {

        ResponseEntity response = ResponseEntity.badRequest().build();
        if (candidateJob != null && candidateJob.getId() == null) {
            CandidateJob registered = candidateJobRepository.save(candidateJob);
            response = ResponseEntity.status(HttpStatus.CREATED).body(registered);
        }

        return response;
    }
}
