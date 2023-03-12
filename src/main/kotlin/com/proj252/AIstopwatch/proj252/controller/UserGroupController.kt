package com.proj252.AIstopwatch.proj252.controller

import com.proj252.AIstopwatch.proj252.domain.Event
import com.proj252.AIstopwatch.proj252.dto.user.UserGroupsDto
import com.proj252.AIstopwatch.proj252.service.EventService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("user")
class UserController {

    private final var eventService: EventService

    @Autowired
    constructor(eventService: EventService) {
        this.eventService = eventService
    }

    @GetMapping("/groups")
    @ResponseBody
    fun getInvolvingGroup(@RequestParam uid: Long): UserGroupsDto {
        val userGroupsDto: UserGroupsDto =
            UserGroupsDto(
                hostGroupId = eventService.getGroupsByUser(uid, 3),
                partisGroupId = eventService.getGroupsByUser(uid, 2)
            )

        return userGroupsDto
    }

    @PostMapping("/events")
    @ResponseBody
    fun getRecentEvent(@RequestBody groupIds:List<Long>):List<Event> {
        var events: List<Event> = eventService.getEventsByGroups(groups = groupIds)

        return events
    }


}
