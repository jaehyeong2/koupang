package jjfactory.koupang.system

import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController("/test")
class TestCont(
    private val memberRepo: MemberRepo,
    private val activityLogRepo: ActivityLogRepo,
    private val accountRepo: AccountRepo,
    private val systemRepo: SystemRepo
) {

    @PostMapping("/test")
    fun setUp() {
        val list: MutableList<CollectedDataRequest> = ArrayList()

        for (i in 1..1000) {
            val data = CollectedDataRequest(
                username = "lee",
                postCnt = 20,
                viewCnt = 100,
                commentCnt = 30
            )

            list.add(data)
        }

        for (i in 1..500) {
            val data = CollectedDataRequest(
                username = "lee2",
                postCnt = 20,
                viewCnt = 100,
                commentCnt = 30
            )

            list.add(data)
        }

        for (i in 1..500) {
            val data = CollectedDataRequest(
                username = "kim",
                postCnt = 20,
                viewCnt = 100,
                commentCnt = 30
            )

            list.add(data)
        }

        test(list)
    }

    @PostMapping("/test2")
    fun setUp2() {
        val list: MutableList<CollectedDataRequest> = ArrayList()

        for (i in 1..1000) {
            val data = CollectedDataRequest(
                username = "lee",
                postCnt = 20,
                viewCnt = 100,
                commentCnt = 30
            )

            list.add(data)
        }

        for (i in 1..500) {
            val data = CollectedDataRequest(
                username = "lee2",
                postCnt = 20,
                viewCnt = 100,
                commentCnt = 30
            )

            list.add(data)
        }

        for (i in 1..500) {
            val data = CollectedDataRequest(
                username = "kim",
                postCnt = 20,
                viewCnt = 100,
                commentCnt = 30
            )

            list.add(data)
        }

        useMap(list)
    }


    fun test(dataList: List<CollectedDataRequest>) {
        val list: MutableList<ActivityLog> = ArrayList()

        //data 2000
        dataList.forEach {
            //2000
            val account = accountRepo.findByUsername(it.username)

            val log = ActivityLog(
                // 쿼리 2방
                member = account.member,
                viewCnt = it.viewCnt,
                commentCnt = it.commentCnt,
                postCnt = it.postCnt
            )

            list.add(log)
        }

//        activityLogRepo.saveAll(list)
    }

    fun useMap(dataList: List<CollectedDataRequest>) {
        val list: MutableList<ActivityLog> = ArrayList()
        val map: MultiValueMap<Member, String> = LinkedMultiValueMap()

        accountRepo.findAll().forEach {
            map.add(it.member, it.username)
        }

        dataList.forEach {
            map.forEach { key, value ->
                if (value.contains(it.username)){
                    val log = ActivityLog(
                        // 쿼리 2방
                        member = key,
                        viewCnt = it.viewCnt,
                        commentCnt = it.commentCnt,
                        postCnt = it.postCnt
                    )

                    list.add(log)
                }
            }

        }

//        activityLogRepo.saveAll(list)
    }

}

data class CollectedDataRequest(
    val username: String,
    val postCnt: Int,
    val commentCnt: Int,
    val viewCnt: Int
)