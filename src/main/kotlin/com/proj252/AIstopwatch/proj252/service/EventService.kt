package com.proj252.AIstopwatch.proj252.service

import com.proj252.AIstopwatch.proj252.domain.Event
import com.proj252.AIstopwatch.proj252.domain.Group
import com.proj252.AIstopwatch.proj252.repository.SdjEventRepo
import com.proj252.AIstopwatch.proj252.repository.SdjGroupRepo
import com.proj252.AIstopwatch.proj252.repository.SdjRelatedGroupRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
//!! Service니까 날짜 변화시 초기화 등이 여기서 반영되어야 한다는 것. 각자마다 조회 & 날짜 변경 확인 & 이후 진행하는 로직을 만들 것.
class EventService {
    private lateinit var eventRepo: SdjEventRepo
    private lateinit var groupRepo: SdjGroupRepo
    private lateinit var relatedGroupRepo: SdjRelatedGroupRepo

    @Autowired
    //여기서 repo 갈아끼울 수 있음
    constructor(eventRepo: SdjEventRepo) {
        this.eventRepo = eventRepo
        this.groupRepo = groupRepo
        this.relatedGroupRepo = relatedGroupRepo
    }

    public fun getEventByGroup(groupId: Long): Event? {

        try {
            val event: Event? =
                eventRepo.getByGroupId(groupId)

            return event

        } catch (e: Exception) {
            print("stopwatch get time err, retry?")
            return null
        }

    }

    //역할에 맞는 Group을 불러오는 로직
    public fun getGroupsByUser(uid: Long, role: Int): List<Long> {

        var groupsId: List<Long>

        //groupId를 얻어오고,
        //얻어 온 group_id로 조회해본 group이 존재하면 List에 눌러담기
        try {
            groupsId = relatedGroupRepo.findGroupIdByUserUidAndRole(uid, role)
        } catch (e: Exception) {
            groupsId = listOf<Long>()
            //TODO error handling
        }
        return groupsId
    }

    public fun getEventsByGroups(groups: List<Long>): List<Event>{
        var events = mutableListOf<Event>()

        try {
            for(groupId in groups){
                eventRepo.getByGroupId(groupId)?.let { events.add(it) }
            }

        }catch (e: Exception){
            //TODO error handling
        }

        return events
    }


}