package com.myhome.library.repository.book.entrust

import com.myhome.library.domain.book.entrust.BookEntrustHistory
import com.myhome.library.type.BookEntrustStatus

interface BookEntrustRepositoryCustom {

    fun find(isbn: String, status: BookEntrustStatus): BookEntrustHistory?
}
