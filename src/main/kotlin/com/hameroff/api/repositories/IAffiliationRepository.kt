package com.hameroff.api.repositories

import com.hameroff.api.model.database.Affiliation
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface IAffiliationRepository: JpaRepository<Affiliation, Long>