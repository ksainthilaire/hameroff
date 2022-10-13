package com.hameroff.api.repositories

import com.hameroff.api.model.database.NewsletterMember
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface INewsletterRepository : JpaRepository<NewsletterMember, Long>