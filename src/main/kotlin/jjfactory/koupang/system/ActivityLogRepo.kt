package jjfactory.koupang.system

import org.springframework.data.jpa.repository.JpaRepository

interface ActivityLogRepo : JpaRepository<ActivityLog, Long>{
}