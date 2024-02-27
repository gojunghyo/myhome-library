package com.myhome.library.repository.member.rental

import com.myhome.library.domain.member.rental.MemberRentalHistory
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRentalRepository : JpaRepository<MemberRentalHistory, Long>, MemberRentalRepositoryCustom {
}
