package com.api.serie.a.Service;
import com.api.serie.a.Model.Time;
import com.api.serie.a.Repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TimeService {

    @Autowired
    private TimeRepository timeRepository;

    public List<Time> getAllTimes() {
        return timeRepository.findAll();
    }

}
