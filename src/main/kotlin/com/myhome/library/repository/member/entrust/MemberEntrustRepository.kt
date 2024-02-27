package com.myhome.library.repository.member.entrust

import com.myhome.library.domain.member.entrust.MemberEntrustHistory
import org.springframework.data.jpa.repository.JpaRepository

//회원 위탁 도서
interface MemberEntrustRepository : JpaRepository<MemberEntrustHistory, Long>, MemberEntrustRepositoryCustom {

}
