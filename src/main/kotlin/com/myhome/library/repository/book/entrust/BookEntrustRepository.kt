package com.myhome.library.repository.book.entrust

import com.myhome.library.domain.book.entrust.BookEntrustHistory
import org.springframework.data.jpa.repository.JpaRepository

//회원 위탁 도서
interface BookEntrustRepository : JpaRepository<BookEntrustHistory, Long>,
    BookEntrustRepositoryCustom {

}
