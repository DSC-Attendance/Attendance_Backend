package com.proj252.AIstopwatch.proj252.controller

import com.proj252.AIstopwatch.proj252.service.EventService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("alarm")
class EventController {

    private final var eventService: EventService

    @Autowired
    constructor(eventService: EventService){
        this.eventService = eventService
    }
    @GetMapping("/group")
    fun getEventByGroup(@RequestParam groupId: Long){
        eventService.getEventByGroup(groupId)
    }
    @GetMapping("/host")
    fun getEventByHost(@RequestParam userId: Int){
        eventService
    }
    @GetMapping("/partis")
    fun getEventByPartis(@RequestParam userId: Int){
        eventService
    }


}
