package com.dddsample.rds.infrastructure.domain;

import com.dddsample.rds.domain.Snapshot;
import com.dddsample.rds.domain.SnapshotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Component("snapshotRepository")
public class SnapshotRepositoryDBImpl extends SimpleJpaRepository<Snapshot, String> implements SnapshotRepository {

    public SnapshotRepositoryDBImpl(@Autowired EntityManager em) {
        super(Snapshot.class, em);
    }

    @Override
    @Transactional
    public Snapshot save(Snapshot snapshot) {
        return super.save(snapshot);
    }
}
