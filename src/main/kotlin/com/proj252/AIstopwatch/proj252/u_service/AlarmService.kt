package com.proj252.AIstopwatch.proj252.u_service

import com.proj252.AIstopwatch.proj252.u_domain.Alarm
import com.proj252.AIstopwatch.proj252.u_dto.stopwatch.AlarmDto
import com.proj252.AIstopwatch.proj252.u_repository.SdjAlarmRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AlarmService {

    private lateinit var alarmRepo: SdjAlarmRepo

    @Autowired
    //여기서 repo 갈아끼울 수 있음
    constructor(alarmRepo: SdjAlarmRepo){
        this.alarmRepo = alarmRepo
    }

    public fun setAlarm(userId:Long, ison: Int, ringtone: String){
        try {
            var alarm: Alarm? = alarmRepo.findByUserId(userId).orElse(null)

            if(alarm == null){
                //exception
            }else{
                alarm.ison = ison
                alarm.ringtoneName = ringtone
                alarmRepo.save(alarm)
            }
        }catch (e: Exception){
            //!! 알아서 처리
            print("stopwatch save err, retry?")
        }
    }

    public fun getAlarm(userId: Long): AlarmDto{
        var alarmDto: AlarmDto = try {

            val alarm: Alarm? = alarmRepo.findByUserId(userId).orElse(null)

            if(alarm == null){
                AlarmDto(0, "none")
            }else{
                AlarmDto(alarm.ison, alarm.ringtoneName)
            }

        }catch (e: Exception){
            //!! 알아서 처리
            print("stopwatch save err, retry?")
            AlarmDto(0, "none")
        }
        return alarmDto
    }
}