package com.myhome.library.repository.member.rental

import com.myhome.library.domain.member.rental.MemberRentalHistory
import com.myhome.library.type.MemberRentalStatus

interface MemberRentalRepositoryCustom {
    fun find(isbn: String, status: MemberRentalStatus): MemberRentalHistory?
}
