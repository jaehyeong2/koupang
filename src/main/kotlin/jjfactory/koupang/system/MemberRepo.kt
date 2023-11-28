package jjfactory.koupang.system

import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepo : JpaRepository<Member, Long>{
}