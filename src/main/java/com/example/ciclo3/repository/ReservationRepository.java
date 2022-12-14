package com.example.ciclo3.repository;

import com.example.ciclo3.entities.Client;
import com.example.ciclo3.entities.CountClient;
import com.example.ciclo3.entities.Reservation;
import com.example.ciclo3.repository.crudRepository.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<Reservation> getAll() {
        return (List<Reservation>) reservationCrudRepository.findAll();
    }
    public Optional<Reservation> getReservation(int idReservation) {
        return reservationCrudRepository.findById(idReservation);
    }

    public Reservation save(Reservation c) {
        return reservationCrudRepository.save(c);
    }
    public void delete(Reservation c) {
        reservationCrudRepository.delete(c);
    }

    public List<Reservation> getReservationByStatus(String status){
        return reservationCrudRepository.findAllByStatus(status);
    }

    public List<Reservation> informePeriodoTiempoReservas(Date a, Date b){
        return reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(a,b);
    }

    public List<CountClient> getTopClient(){
        List<CountClient> res = new ArrayList<>();
        List<Object[]> report = reservationCrudRepository.countTotalReservationByClient();
        for(int i=0; i< report.size(); i++){
            res.add(new CountClient((Long)report.get(i)[1],(Client)report.get(i)[0]));
        }
        return res;
    }
}
