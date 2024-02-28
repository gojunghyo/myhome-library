package com.myhome.library.repository.member.entrust

import com.myhome.library.domain.member.entrust.MemberEntrustHistory
import com.myhome.library.type.MemberEntrustStatus

interface MemberEntrustRepositoryCustom {

    fun find(isbn: String, status: MemberEntrustStatus): MemberEntrustHistory?
}
