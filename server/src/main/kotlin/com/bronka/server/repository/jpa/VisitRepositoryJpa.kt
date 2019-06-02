package com.bronka.server.repository.jpa

import com.bronka.server.entity.Visit
import org.springframework.data.jpa.repository.JpaRepository

interface VisitRepositoryJpa :JpaRepository<Visit, Long> {

}